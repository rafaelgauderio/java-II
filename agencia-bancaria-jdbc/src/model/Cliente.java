package model;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	private int codCliente;
	private String nome;
	private String endereco;
	private String sexo;
	private Date dataNascimento;
	private double saldo;
	
	public Cliente() {
		
	}

	public Cliente(int codCliente, String nome, String endereco, String sexo, Date dataNascimento, double saldo) {
		super();
		this.codCliente = codCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.saldo = saldo;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSaldo() {
		return saldo;
	}

	//movimentar o saldo apenas por deposito, saque ou transfer�ncia
	/*
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codCliente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codCliente != other.codCliente)
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nome=" + nome + ", endereco=" + endereco + ", sexo=" + sexo
				+ ", dataNascimento=" + dataNascimento + ", saldo=" + String.format("R$ %.2f", saldo)+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}