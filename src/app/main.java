package app;

import model.*;
import service.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GERENCIAMENTO ACADÊMICO ===\n");

        AcademicManager manager = new AcademicManager();

        System.out.println("1. CRIANDO DISCIPLINAS");
        Subject programacao = new Subject("CS101", "Programação I", 80);
        Subject estruturaDados = new Subject("CS102", "Estrutura de Dados", 80);
        Subject bancoDados = new Subject("CS201", "Banco de Dados", 60);
    System.out.println("Disciplinas criadas: " + programacao.getNome() + ", " + 
               estruturaDados.getNome() + ", " + bancoDados.getNome());
        System.out.println();

        System.out.println("2. CRIANDO PROFESSORES");
        List<Subject> disciplinasProf1 = new ArrayList<>();
        disciplinasProf1.add(programacao);
        disciplinasProf1.add(estruturaDados);

        List<Subject> disciplinasProf2 = new ArrayList<>();
        disciplinasProf2.add(bancoDados);

        Teacher prof1 = new Teacher("Dr. João Silva", "12345678901", "15/03/1980", 
                                    "joao.silva@universidade.edu", "Ciência da Computação", 
                                    disciplinasProf1);
        Teacher prof2 = new Teacher("Dra. Maria Santos", "98765432109", "22/07/1985", 
                                    "maria.santos@universidade.edu", "Sistemas de Informação", 
                                    disciplinasProf2);
    System.out.println("Professor criado: " + prof1.getnome() + " - Depto: " + prof1.getDepartamento());
    System.out.println("Professor criado: " + prof2.getnome() + " - Depto: " + prof2.getDepartamento());
        
        manager.vincularProfessorADisciplina(prof1, programacao);
        manager.vincularProfessorADisciplina(prof1, estruturaDados);
        manager.vincularProfessorADisciplina(prof2, bancoDados);
    System.out.println("Professores vinculados às disciplinas");
        System.out.println();

        System.out.println("3. CRIANDO CURSO");
        Course cursoCienciaComp = new Course("CC001", "Ciência da Computação", 3200);
        cursoCienciaComp.adicionarDisciplina(programacao);
        cursoCienciaComp.adicionarDisciplina(estruturaDados);
        cursoCienciaComp.adicionarDisciplina(bancoDados);
    System.out.println("Curso criado: " + cursoCienciaComp.getNome() + " (Código: " + 
               cursoCienciaComp.getCodigo() + ")");
        System.out.println("  Carga Horária: " + cursoCienciaComp.getCargaHoraria() + " horas");
        System.out.println("  Disciplinas: " + cursoCienciaComp.getDisciplinas().size());
        System.out.println();

        System.out.println("4. CRIANDO ESTUDANTES E MATRICULANDO");
        Student aluno1 = new Student("Ana Costa", "11122233344", "10/05/2003", 
                                     "Ciência da Computação", 202301, "ana.costa@aluno.edu");
        Student aluno2 = new Student("Carlos Oliveira", "55566677788", "18/11/2002", 
                                     "Ciência da Computação", 202302, "carlos.oliveira@aluno.edu");

    System.out.println("Aluno criado: " + aluno1.getnome() + " - Matrícula: " + aluno1.getMatricula());
    System.out.println("Aluno criado: " + aluno2.getnome() + " - Matrícula: " + aluno2.getMatricula());
        
        manager.matricularAlunoEmCurso(aluno1, cursoCienciaComp);
        manager.matricularAlunoEmCurso(aluno2, cursoCienciaComp);
    System.out.println("Alunos matriculados no curso");
        System.out.println();

        System.out.println("5. LANÇANDO NOTAS NO HISTÓRICO");
        
        manager.adicionarAlunoEmDisciplina(aluno1, programacao, cursoCienciaComp);
        manager.adicionarAlunoEmDisciplina(aluno1, estruturaDados, cursoCienciaComp);
        manager.adicionarAlunoEmDisciplina(aluno1, bancoDados, cursoCienciaComp);
        
        manager.adicionarAlunoEmDisciplina(aluno2, programacao, cursoCienciaComp);
        manager.adicionarAlunoEmDisciplina(aluno2, estruturaDados, cursoCienciaComp);
        manager.adicionarAlunoEmDisciplina(aluno2, bancoDados, cursoCienciaComp);
        
        atualizarNotaAluno(manager, aluno1, programacao, 8.5);
        atualizarNotaAluno(manager, aluno1, estruturaDados, 7.0);
        atualizarNotaAluno(manager, aluno1, bancoDados, 9.0);
        
        atualizarNotaAluno(manager, aluno2, programacao, 5.5);
        atualizarNotaAluno(manager, aluno2, estruturaDados, 6.5);
        atualizarNotaAluno(manager, aluno2, bancoDados, 7.5);
        
    System.out.println("Notas lançadas para todos os alunos");
        System.out.println();

        System.out.println("6. HISTÓRICO ACADÊMICO DOS ALUNOS");
        exibirHistoricoAluno(manager, aluno1.getMatricula(), aluno1.getnome());
        exibirHistoricoAluno(manager, aluno2.getMatricula(), aluno2.getnome());

        System.out.println("\n7. CALCULANDO MÉDIAS POR DISCIPLINA");
        double mediaProgramacao = manager.gerarMediaDisciplina(programacao);
        double mediaEstrutura = manager.gerarMediaDisciplina(estruturaDados);
        double mediaBancoDados = manager.gerarMediaDisciplina(bancoDados);
        
    System.out.printf("Média em %s: %.2f%n", programacao.getNome(), mediaProgramacao);
    System.out.printf("Média em %s: %.2f%n", estruturaDados.getNome(), mediaEstrutura);
    System.out.printf("Média em %s: %.2f%n", bancoDados.getNome(), mediaBancoDados);
        System.out.println();

        System.out.println("8. VERIFICANDO PROFESSOR VINCULADO");
        Optional<Teacher> professorOpt = manager.getProfessorDisciplina(programacao);
        if (professorOpt.isPresent()) {
            Teacher prof = professorOpt.get();
            System.out.println("Professor de " + programacao.getNome() + ": " + prof.getnome());
        } else {
            System.out.println("Nenhum professor vinculado a " + programacao.getNome());
        }
        System.out.println();

        System.out.println("=== FIM DO TESTE ===");
    }
    
    private static void atualizarNotaAluno(AcademicManager manager, Student aluno, Subject disciplina, double nota) {
        Optional<List<AcademicTranscript>> historico = manager.buscarHistoricoPorAluno(aluno.getMatricula());
        historico.ifPresent(transcripts -> {
            for (AcademicTranscript t : transcripts) {
                if (t.getDisciplina() != null && t.getDisciplina().equals(disciplina)) {
                    t.setNota(nota);
                    break;
                }
            }
        });
    }
    
    private static void exibirHistoricoAluno(AcademicManager manager, int matricula, String nomeAluno) {
        System.out.println("\n--- HISTÓRICO: " + nomeAluno + " ---");
        System.out.println("Matrícula: " + matricula);
        System.out.println("\nDisciplinas cursadas:");
        
        Optional<List<AcademicTranscript>> historico = manager.buscarHistoricoPorAluno(matricula);
        if (historico.isPresent()) {
            List<AcademicTranscript> transcripts = historico.get();
            for (AcademicTranscript registro : transcripts) {
                if (registro.getDisciplina() != null) {
                    System.out.printf("  - %s: %.1f (%s)%n", 
                        registro.getDisciplina().getNome(),
                        registro.getNota(),
                        registro.getStatus());
                }
            }
        } else {
            System.out.println("  Nenhum registro encontrado");
        }
    }
}