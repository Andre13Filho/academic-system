// representa um estudante
// Atributos: course, "transcript" ou histórico ( lista de AcademicTranscript)
// Métodos: matricularEmCurso, visualizarHistorico, getters e setters

import java.util.List;
import java.util.ArrayList;

public class Student extends Person{
    private List<AcademicTranscript> historico;
    private String curso;
    private int matricula;

    public Student(String nome, String cpf, String datanascimento, String curso, int matricula){
        super(nome, cpf, datanascimento);
        this.curso = curso;
        this.matricula = matricula;
        this.historico = new ArrayList<>();
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
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
    public void setHistorico(List<AcademicTranscript> historico) {
        this.historico = historico;
    }
    
  
}
