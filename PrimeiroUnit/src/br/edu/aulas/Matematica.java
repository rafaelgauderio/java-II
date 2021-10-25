package br.edu.aulas;

public class Matematica {
	
	public int divide(int x,int y) {
		
	if (x==0 || y ==0) {
		return 0;
	}
	
	if (x > 999) {
		throw new IllegalArgumentException("X deve ser menor que 1000");
		
	}
	
	return x/y;
	
	}
	
	public int multiplica(int x,int y) {
		return x*y;
	}
	
	public int soma(int x,int y) {
		return x+y;
	}
	
	public int subtracao(int x,int y) {
		return x-y;
	}
	
	public int potencia(int x, int y ) {
		
		return (int) Math.pow(x,y);
		
	}

}
