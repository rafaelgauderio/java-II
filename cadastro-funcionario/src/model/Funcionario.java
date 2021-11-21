package model;

public class Funcionario {

	private int matricula;
	private String nome;
	private Departamento departamento;

	public Funcionario() {

	}	


	public Funcionario(int matricula, String nome) {	
		this.matricula = matricula;
		this.nome = nome;
	}


	public Funcionario(int matricula, String nome, Departamento departamento) {		
		this.matricula = matricula;
		this.nome = nome;
		this.departamento = departamento;
	}


	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}






}
