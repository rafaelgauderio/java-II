package model;

import java.util.Calendar;

import javax.swing.table.AbstractTableModel;

public class Funcionario extends AbstractTableModel{

	private int matricula;
	private String nome;
	private Departamento departamento;
	private String CPF;
	private String celular;
	private Calendar dataNascimento;
	

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
	
	

	

	public Funcionario(int matricula, String nome, Departamento departamento, String cPF, String celular,
			Calendar dataNascimento) {
		
		this.matricula = matricula;
		this.nome = nome;
		this.departamento = departamento;
		CPF = cPF;
		this.celular = celular;
		this.dataNascimento = dataNascimento;
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
	
	


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public Calendar getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	@Override
	public int getRowCount() {
		return 0;
	}


	@Override
	public int getColumnCount() {
		
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return null;
	}






}
