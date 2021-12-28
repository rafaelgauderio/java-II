package model;

import java.io.Serializable;
import java.util.Calendar;


public class Movimento implements Serializable  {

	
	private static final long serialVersionUID = 1L;
	
	private Integer numMovimento;
	private Integer codCliente;
	private Integer codClienteFavorecido;
	private Integer codOperacao;
	private double valor;
	private Calendar dataHoraMovimento;  
	private Cliente cliente;
	private Operacao operacao;
	
	public Movimento () {
		
	}

	public Movimento(Integer numMovimento, Integer codCliente, Integer codClienteFavorecido, Integer codOperacao,
			double valor, Calendar dataHoraMovimento) {
		super();
		this.numMovimento = numMovimento;
		this.codCliente = codCliente;
		this.codClienteFavorecido = codClienteFavorecido;
		this.codOperacao = codOperacao;
		this.valor = valor;
		this.dataHoraMovimento = dataHoraMovimento;
	}
	
	public Movimento(Integer codCliente, Integer codClienteFavorecido, Integer codOperacao,
			double valor, Calendar dataHoraMovimento) {
		
		this.codCliente = codCliente;
		this.codClienteFavorecido = codClienteFavorecido;
		this.codOperacao = codOperacao;
		this.valor = valor;
		this.dataHoraMovimento = dataHoraMovimento;
	}
	
	public Movimento(Integer codCliente, Integer codOperacao,
			double valor, Calendar dataHoraMovimento) {
		
		this.codCliente = codCliente;		
		this.codOperacao = codOperacao;
		this.valor = valor;
		this.dataHoraMovimento = dataHoraMovimento;
	}	
	

	public Movimento(Integer numMovimento, Integer codCliente, Integer codClienteFavorecido, Integer codOperacao,
			double valor, Calendar dataHoraMovimento, Cliente cliente, Operacao operacao) {
		super();
		this.numMovimento = numMovimento;
		this.codCliente = codCliente;
		this.codClienteFavorecido = codClienteFavorecido;
		this.codOperacao = codOperacao;
		this.valor = valor;
		this.dataHoraMovimento = dataHoraMovimento;
		this.cliente = cliente;
		this.operacao = operacao;
	}

	public Integer getNumMovimento() {
		return numMovimento;
	}

	public void setNumMovimento(Integer numMovimento) {
		this.numMovimento = numMovimento;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodClienteFavorecido() {
		return codClienteFavorecido;
	}

	public void setCodClienteFavorecido(Integer codClienteFavorecido) {
		this.codClienteFavorecido = codClienteFavorecido;
	}

	public Integer getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(Integer codOperacao) {
		this.codOperacao = codOperacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataHoraMovimento() {
		return dataHoraMovimento;
	}

	public void setDataHoraMovimento(Calendar dataHoraMovimento) {
		this.dataHoraMovimento = dataHoraMovimento;
	}	
		

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	@Override
	public String toString() {
		return "Movimento [numMovimento=" + numMovimento + ", codCliente=" + codCliente + ", codClienteFavorecido="
				+ codClienteFavorecido + ", codOperacao=" + codOperacao + ", valor=" + String.format("R$ %.2f",valor) + ", dataHoraMovimento="
				+ dataHoraMovimento + "]";
	}

	
	
	
	
	
	
			
	

}
