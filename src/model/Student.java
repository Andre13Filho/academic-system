// representa um estudante
// Atributos: course, "transcript" ou histórico ( lista de AcademicTranscript)
// Métodos: matricularEmCurso, visualizarHistorico, getters e setters
package model;
import java.util.List;
import java.util.ArrayList;

public class Student extends Person{
    private Course course;
    private List<AcademicTranscript> historico;
    private int matricula;

    public Student (String nome, String cpf, String datanascimento, String curso, int matricula, String email){
        super(nome, cpf, datanascimento, email);
        this.course = course;
        this.matricula = matricula;
        this.historico = new ArrayList<>();
    }
    
     public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public List<AcademicTranscript> getHistorico() {
        return historico;
    }

  
}
