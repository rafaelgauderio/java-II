package exercicio_revisao;

import java.util.Scanner;

public class ContaCorrente {
	
	
	private String nomeCliente;
	private long agencia;
	private long conta;	
	private double saldo=0.0;	
	
	public ContaCorrente() {
		
	}

	public ContaCorrente(String nomeCliente, long agencia, long conta, double saldo) {
		super();
		this.nomeCliente = nomeCliente;
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public long getAgencia() {
		return agencia;
	}

	public void setAgencia(long agencia) {
		this.agencia = agencia;
	}

	public long getConta() {
		return conta;
	}

	public void setConta(long conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}
	//usuario não pode setar o saldo da propria conta, apenas atraves de saques e depositos
	/*
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	*/
	
	public int sacar(double valor) {
		if(this.saldo <=0) {
			return 0;
		}
		else {
			this.saldo=this.saldo - valor;
			return 1;
			
		}	
		
	}
	
	public void depositar(double valor) {
		this.saldo +=valor;
	}
	
	
	public void imprimir() {
		System.out.println("Ciente=" + nomeCliente + ", agencia=" + agencia + ", conta=" + conta + ", saldo="
				+ String.format("%.2f",saldo));
	}
	
	

	@Override
	public String toString() {
		return "ContaCorrente [Cliente=" + nomeCliente + ", agencia=" + agencia + ", conta=" + conta + ", saldo="
				+ String.format("%.2f",saldo) + "]";
	}

	
	
	
	

}
