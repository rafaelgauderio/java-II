package com.rafaeldeluca;

public class MainJogo {
	
	public static void main (String [] args ) {
		
		
		Controle jogo1 = new StreetFighter();		
		Controle jogo2 = new AgeOfEmpires();
		
		jogo1.setBotaoX();
		jogo1.tocarMusica();
		
		System.out.println("\n");
		
		jogo2.setBotaoX();
		jogo2.tocarMusica();
		
		
	}

}
