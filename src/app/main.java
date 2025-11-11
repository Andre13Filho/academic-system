import model.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GERENCIAMENTO ACADÊMICO ===\n");
        
        System.out.println("1. CRIANDO DISCIPLINAS");
        Subject programacao = new Subject("CS101", "Programação I", 80);
        Subject estruturaDados = new Subject("CS102", "Estrutura de Dados", 80);
        Subject bancoDados = new Subject("CS201", "Banco de Dados", 60);
        System.out.println("✓ Disciplinas criadas: " + programacao.getNome() + ", " + 
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
        System.out.println("✓ Professor criado: " + prof1.getnome() + " - Depto: " + prof1.getDepartamento());
        System.out.println("✓ Professor criado: " + prof2.getnome() + " - Depto: " + prof2.getDepartamento());
        System.out.println();
        
        System.out.println("3. CRIANDO CURSO");
        Course cursoCienciaComp = new Course("CC001", "Ciência da Computação", 3200);
        cursoCienciaComp.adicionarDisciplina(programacao);
        cursoCienciaComp.adicionarDisciplina(estruturaDados);
        cursoCienciaComp.adicionarDisciplina(bancoDados);
        System.out.println("✓ Curso criado: " + cursoCienciaComp.getNome() + " (Código: " + 
                           cursoCienciaComp.getCodigo() + ")");
        System.out.println("  Carga Horária: " + cursoCienciaComp.getCargaHoraria() + " horas");
        System.out.println("  Disciplinas: " + cursoCienciaComp.getDisciplinas().size());
        System.out.println();
        
        System.out.println("4. CRIANDO ESTUDANTES");
        Student aluno1 = new Student("Ana Costa", "11122233344", "10/05/2003", 
                                     "Ciência da Computação", 202301, "ana.costa@aluno.edu");
        Student aluno2 = new Student("Carlos Oliveira", "55566677788", "18/11/2002", 
                                     "Ciência da Computação", 202302, "carlos.oliveira@aluno.edu");
        
        aluno1.setCourse(cursoCienciaComp);
        aluno2.setCourse(cursoCienciaComp);
        
        System.out.println("✓ Aluno criado: " + aluno1.getnome() + " - Matrícula: " + aluno1.getMatricula());
        System.out.println("✓ Aluno criado: " + aluno2.getnome() + " - Matrícula: " + aluno2.getMatricula());
        System.out.println();
        
        System.out.println("5. LANÇANDO NOTAS NO HISTÓRICO");
        
        AcademicTranscript matricula1 = new AcademicTranscript(aluno1, cursoCienciaComp);
        aluno1.getHistorico().add(matricula1);
        
        AcademicTranscript nota1_prog = new AcademicTranscript(aluno1, programacao, 8.5);
        AcademicTranscript nota1_estrut = new AcademicTranscript(aluno1, estruturaDados, 7.0);
        AcademicTranscript nota1_bd = new AcademicTranscript(aluno1, bancoDados, 9.0);
        
        aluno1.getHistorico().add(nota1_prog);
        aluno1.getHistorico().add(nota1_estrut);
        aluno1.getHistorico().add(nota1_bd);
        
        AcademicTranscript matricula2 = new AcademicTranscript(aluno2, cursoCienciaComp);
        aluno2.getHistorico().add(matricula2);
        
        AcademicTranscript nota2_prog = new AcademicTranscript(aluno2, programacao, 5.5);
        AcademicTranscript nota2_estrut = new AcademicTranscript(aluno2, estruturaDados, 6.5);
        AcademicTranscript nota2_bd = new AcademicTranscript(aluno2, bancoDados, 7.5);
        
        aluno2.getHistorico().add(nota2_prog);
        aluno2.getHistorico().add(nota2_estrut);
        aluno2.getHistorico().add(nota2_bd);
        
        System.out.println("✓ Notas lançadas para todos os alunos");
        System.out.println();
        
        System.out.println("6. HISTÓRICO ACADÊMICO DOS ALUNOS");
        System.out.println("\n--- HISTÓRICO: " + aluno1.getnome() + " ---");
        System.out.println("Curso: " + aluno1.getCourse().getNome());
        System.out.println("Matrícula: " + aluno1.getMatricula());
        System.out.println("\nDisciplinas cursadas:");
        
        for (AcademicTranscript registro : aluno1.getHistorico()) {
            if (registro.getDisciplina() != null) {
                System.out.printf("  - %s: %.1f (%s)%n", 
                    registro.getDisciplina().getNome(),
                    registro.getNota(),
                    registro.getStatus());
            }
        }
        
        System.out.println("\n--- HISTÓRICO: " + aluno2.getnome() + " ---");
        System.out.println("Curso: " + aluno2.getCourse().getNome());
        System.out.println("Matrícula: " + aluno2.getMatricula());
        System.out.println("\nDisciplinas cursadas:");
        
        for (AcademicTranscript registro : aluno2.getHistorico()) {
            if (registro.getDisciplina() != null) {
                System.out.printf("  - %s: %.1f (%s)%n", 
                    registro.getDisciplina().getNome(),
                    registro.getNota(),
                    registro.getStatus());
            }
        }
        
        System.out.println("\n\n7. TESTANDO REMOÇÃO DE DISCIPLINA");
        System.out.println("Disciplinas antes da remoção: " + cursoCienciaComp.getDisciplinas().size());
        cursoCienciaComp.removerDisciplina(bancoDados);
        System.out.println("Disciplinas após remover Banco de Dados: " + cursoCienciaComp.getDisciplinas().size());
        
        System.out.println("\n=== FIM DO TESTE ===");
    }
}
