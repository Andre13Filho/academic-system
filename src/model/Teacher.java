// representa um professor
// Atributos: departamento, disciplinasMinistradas (lista de Subject)
// Métodos: atribuirNota(Student, Subject), getters e setters

import java.util.List;

public class Teacher extends Person{
    private String departamento;
    private List<Subject> disciplinasMinistradas;
    private float notas;
    public Teacher(String nome, String cpf, String datanascimento, String email, String departamento, List<Subject> disciplinasMinistradas){
        super(nome, cpf, datanascimento, email);
        this.departamento = departamento;
        this.disciplinasMinistradas = disciplinasMinistradas;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public List<Subject> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }
    public void setDisciplinasMinistradas(List<Subject> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

}
