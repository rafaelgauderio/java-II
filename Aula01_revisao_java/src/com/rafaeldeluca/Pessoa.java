package com.rafaeldeluca;

import java.util.Date;

import com.rafaeldeluca.util.Endereco;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private Endereco endereco;	
	
	public Pessoa() {
		
	}

	public Pessoa(String nome, String cpf, Date dataNascimento, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + "\nEnderešo=" + endereco
				+ "]";
	}
	
	

	
	
	
	
	



	

	
}
