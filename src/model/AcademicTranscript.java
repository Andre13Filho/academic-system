package model;

import java.util.Objects;

// Representa um histórico acadêmico (lancamento de nota / matrícula)
// Atributos: aluno, curso (opcional), disciplina (opcional), nota e status (Aprovado/Reprovado)
// Métodos: calcularStatus, getters e setters
public class AcademicTranscript {

	private Student aluno;
	private Course curso; 
	private Subject disciplina; 
	private double nota;
	private String status;

	public static final double PASSING_GRADE = 6.0;

	public AcademicTranscript(Student aluno, Course curso) {
		this.aluno = aluno;
		this.curso = curso;
		this.disciplina = null;
		this.nota = 0.0;
		this.status = "";
	}

	public AcademicTranscript(Student aluno, Subject disciplina, double nota) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.nota = nota;
		this.curso = null;
		calcularStatus();
	}

	public void calcularStatus() {
		this.status = (this.nota >= PASSING_GRADE) ? "Aprovado" : "Reprovado";
	}

	// getters e setters
	public Student getAluno() {
		return aluno;
	}

	public void setAluno(Student aluno) {
		this.aluno = aluno;
	}

	public Course getCurso() {
		return curso;
	}

	public void setCurso(Course curso) {
		this.curso = curso;
	}

	public Subject getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Subject disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
		calcularStatus();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}