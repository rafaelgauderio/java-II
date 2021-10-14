package exercicio_revisao;

public class Funcionario {
	
	private String nome;
	private String departamento;
	private double salario;
	private Data dataEntrada=(new Data (00,00,2000));
	private String rg;
	private boolean estaNaEmpresa=true;
	
	public Funcionario() {
		
				
	}

	public Funcionario(String nome, String departamento, double salario, Data dataEntrada, String rg,
			boolean estaNaEmpresa) {
		super();
		this.nome = nome;
		this.departamento = departamento;
		this.salario = salario;
		this.dataEntrada = dataEntrada;
		this.rg=rg;
		this.estaNaEmpresa = estaNaEmpresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Data getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public boolean isEstaNaEmpresa() {
		return estaNaEmpresa;
	}

	public void setEstaNaEmpresa(boolean estaNaEmpresa) {
		this.estaNaEmpresa = estaNaEmpresa;
	}
	
	public double bonifica(double aumento) {
		
		return this.salario+=aumento;
	}
	
	public void demite() {
		
		this.estaNaEmpresa=false;
		System.out.println("O(A) funcionário(a) " + this.getNome() + " foi demitido(a)!");
		
	}
	
	public void mostra() {
		
		System.out.println("Nome:" + this.nome);
		System.out.println("Departamento: " +this.departamento);
		System.out.println("Salário: " +this.salario);		
		System.out.println("Data de entrada: " +this.dataEntrada);		
		System.out.println("RG: " +this.rg);
		System.out.println("Funcionário está na empresa: " +this.estaNaEmpresa);		
		
	}
	
	public boolean iguais(Funcionario func) {
		if (this == func) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {		
		
		return "Funcionario [nome=" + nome + ", departamento=" + departamento + ", salário=" + String.format("R$%.2f", salario)
				+ "\n\t\tData de entrada=" + dataEntrada + ", RG=" + rg + ", Está na empresa=" + estaNaEmpresa + "]";
	}	
	
	

}
