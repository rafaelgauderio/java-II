package model;

import java.io.Serializable;

public class Operacao implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descricao;
	
	public Operacao() {
		
	}

	public Operacao(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Operacao [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
	
	
	
	
	
	

}
