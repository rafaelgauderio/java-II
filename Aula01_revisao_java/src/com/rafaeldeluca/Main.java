package com.rafaeldeluca;

import com.rafaeldeluca.util.Endereco;

public class Main {

	public static void main(String[] args) {
	//static -> n?o depende de um objeto para disparar um membro static
	//Sen?o teria que instanciar um objeto. Objeto sempre depende de uma classe no java
	//Toda classe ? filha da classe Object (tem algums m?todos prontos)
	
		Pessoa rafael = new Pessoa();		
		Endereco residencial_rafael = new Endereco();
		
		
		rafael.setNome("Rafael De Luca");
		rafael.setCpf("001.019.350-21");
		rafael.setEndereco(residencial_rafael);		
		
		residencial_rafael.setCidade("Porto Alegre");		
		
		System.out.println(rafael);
		
		
			
		

	}

}
