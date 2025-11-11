//Representa um curso academico
//Atributos: codigo, nome, cargaHoraria, disciplinas (lista de Subject)
// Metódos: adicionarDisciplina, removerDisciplina, getters e setters
package model;
import java.util.ArrayList;

public class Course {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private ArrayList<Subject> disciplinas;
    public Course(String codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.disciplinas = new ArrayList<Subject>();
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public ArrayList<Subject> getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(ArrayList<Subject> disciplinas) {
        this.disciplinas = disciplinas;
    }
    public void adicionarDisciplina(Subject disciplina){
        disciplinas.add(disciplina);
    }
    public void removerDisciplina(Subject disciplina){
        disciplinas.remove(disciplina);
    }
    
  
}
