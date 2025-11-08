//ideias de metodos para gerenciar estudantes, professores, cursos e disciplinas:
//buscarHisoricoPorAluno - Localiza um aluno pela sua matrícula e retorna o histórico acadêmico completo dele (todas as notas e status).
// matricularAlunoEmCurso - Garante que a matrícula ocorra corretamente. Pode incluir verificações, como se o aluno já está matriculado em outro curso de tempo integral, se o curso tem vagas, etc.
// gerarRelatorioNotasDisciplina - Calcula e retorna a média de notas de todos os alunos que cursaram uma disciplina específica, além da taxa de aprovação/reprovação.
// vincularProfessorADisciplina - Atribui um professor a uma disciplina, garantindo que o professor tenha a especialidade necessária (se for o caso) e que a disciplina não esteja com o limite de professores excedido.
// criarNovoCurso - Cria e cadastra uma nova instância de Curso no sistema. Este é um método de criação mais direto.

package service;

import model.Student;
import model.Teacher;
import model.Course;
import model.Subject;
import model.AcademicTranscript;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class AcademicManager {

    // repositórios em memória
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();
    private final List<AcademicTranscript> transcripts = new ArrayList<>();

    private final Map<Integer, Student> studentsByRa = new HashMap<>();
    private final Map<Subject, Teacher> subjectTeacherMap = new HashMap<>();

    public void matricularAlunoEmCurso(Student aluno, Course curso) {
        if (aluno == null || curso == null) {
            throw new IllegalArgumentException("Aluno e curso não podem ser nulos");
        }
        
        if (!students.contains(aluno)) {
            students.add(aluno);
            studentsByRa.put(aluno.getMatricula(), aluno);
        }
        
        if (!courses.contains(curso)) {
            courses.add(curso);
        }
        
        AcademicTranscript transcript = new AcademicTranscript(aluno, curso);
        transcripts.add(transcript);
    }

    public boolean alunoEstaMatriculado(Student aluno, Course curso) {
        return transcripts.stream()
            .anyMatch(t -> t.getAluno().equals(aluno) && t.getCurso().equals(curso));
    }

    public List<Course> buscarCursosDoAluno(Student aluno) {
        return transcripts.stream()
            .filter(t -> t.getAluno().equals(aluno))
            .map(AcademicTranscript::getCurso)
            .distinct()
            .toList();
    }

    public Optional<List<AcademicTranscript>> buscarHistoricoPorAluno(int ra) {
        Student aluno = studentsByRa.get(ra);
        if (aluno == null) {
            return Optional.empty();
        }
        List<AcademicTranscript> historicoAluno = transcripts.stream()
            .filter(t -> t.getAluno().equals(aluno))
            .toList();
        return Optional.of(historicoAluno);
    }

    public double gerarMediaDisciplina(Subject disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }
        return transcripts.stream()
            .filter(t -> t.getDisciplina().equals(disciplina))  
            .mapToDouble(t -> t.getNota())                      
            .average()                                         
            .orElse(0.0);                                     
    }

    public void vincularProfessorADisciplina(Teacher professor, Subject disciplina) {
        if (professor == null || disciplina == null) {
            throw new IllegalArgumentException("Professor e disciplina não podem ser nulos");
        }
        if (!teachers.contains(professor)) {
            teachers.add(professor);
        }
        if (!subjects.contains(disciplina)) {
            subjects.add(disciplina);
        }
        subjectTeacherMap.put(disciplina, professor);
    }

    public Optional<Teacher> getProfessorDisciplina(Subject disciplina) {
        return Optional.ofNullable(subjectTeacherMap.get(disciplina));
    }

    public boolean disciplinaTemProfessor(Subject disciplina) {
        return subjectTeacherMap.containsKey(disciplina);
    }

    public void removerAlunoDeMatricula(Student aluno, Course curso) {
        if (aluno == null || curso == null) {
            throw new IllegalArgumentException("Aluno e curso não podem ser nulos");
        }
        transcripts.removeIf(t -> 
            t.getAluno().equals(aluno) && 
            t.getCurso().equals(curso)
        );

        boolean aindaTemMatricula = transcripts.stream()
            .anyMatch(t -> t.getAluno().equals(aluno));
        
        if (!aindaTemMatricula) {
            students.remove(aluno);
            studentsByRa.remove(aluno.getRa());
        }
    }

    public void removerProfessorDeDisciplina(Subject disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode ser nula");
        }
        Teacher professorRemovido = subjectTeacherMap.remove(disciplina);

        if (professorRemovido != null) {
            boolean aindaTemDisciplinas = subjectTeacherMap.containsValue(professorRemovido);
            if (!aindaTemDisciplinas) {
                teachers.remove(professorRemovido);
            }
        }
    }

    public void adicionarAlunoEmDisciplina(Student aluno, Subject disciplina, Course curso) {
        if (aluno == null || disciplina == null || curso == null) {
            throw new IllegalArgumentException("Aluno, disciplina e curso não podem ser nulos");
        }

        boolean matriculado = alunoEstaMatriculado(aluno, curso);
        if (!matriculado) {
            throw new IllegalStateException("Aluno precisa estar matriculado no curso para adicionar disciplina");
        }

        boolean disciplinaDoCurso = curso.getDisciplinas().contains(disciplina);
        if (!disciplinaDoCurso) {
            throw new IllegalStateException("Disciplina não pertence ao curso informado");
        }
        AcademicTranscript transcript = new AcademicTranscript(aluno, disciplina, 0.0); // nota inicial 0
        transcripts.add(transcript);
    }

    public boolean alunoEstaCursandoDisciplina(Student aluno, Subject disciplina) {
        return transcripts.stream()
            .anyMatch(t -> 
                t.getAluno().equals(aluno) && 
                t.getDisciplina().equals(disciplina)
            );
    }
}
