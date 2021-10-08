package com.rafaeldeluca.util;

public class Endereco {
	
	private String rua;
	private int numero;
	private String CEP;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco() {
		
	}
	
	

	public Endereco(String rua, int numero, String cEP, String complemento, String bairro, String cidade,
			String estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.CEP = cEP;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}



	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		this.CEP = cEP;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", CEP=" + CEP + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	
	
	

}
