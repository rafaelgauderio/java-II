package mavemJdbcDao.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Produto  {

	
	private Integer id;
	private String nome;
	private double preco;

	private Integer qtdEstoque;
	private String descricao;
	
	public Produto() {
		
	}
	
	
	
	public Produto(Integer id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}



	public Produto(Integer id, String nome, double preco, Integer qtdEstoque, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + String.format("%.2f",preco)+ ", qtdEstoque=" + qtdEstoque
				+ ", descricao=" + descricao + "]";
	}
	
	
	

}
