package br.edu.aulas;

public class Aplicacao {

	public static void main(String[] args) {
		
		int x=50,y=2;
		
		Matematica matematica = new Matematica();
		
		System.out.println("Testando com 50 e 2 como x e y");
		
		System.out.println("Soma: " + matematica.soma(x,y));
		System.out.println("Subtrai: " + matematica.subtracao(x, y));
		System.out.println("Multiplica: " + matematica.multiplica(x, y));
		System.out.println("Divide: " + matematica.divide(x, y));
		System.out.println("Eleva ao quadrado: " + matematica.potencia(x, y));
		

	}

}
