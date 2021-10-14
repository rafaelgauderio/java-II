package exercicio_revisao;

public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data() {
		
	}

	public Data(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String formataData() {
		
		return String.format("%02d",this.dia)+ "/" + String.format("%02d",this.mes) +"/"+String.format("%02d", this.ano);
	}

	@Override
	public String toString() {
		
		return String.format("%02d",this.dia)+ "/" + String.format("%02d",this.mes) +"/"+String.format("%02d", this.ano);
	}
	
	
	
	
	
	

}
