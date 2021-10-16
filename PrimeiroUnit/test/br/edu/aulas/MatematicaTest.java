package br.edu.aulas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatematicaTest {
	
	/*
	Matematica matematica;
	
	@Before
	public void setup() {
		matematica = new Matematica();
	}
	*/

	@Test
	public void testDivide() {
		Matematica matematica = new Matematica();
		int divide = matematica.divide(50,5);
		Assertions.assertEquals(10,divide);
		
	}

	@Test
	public void testMultiplica() {
		Matematica matematica = new Matematica();
		int multiplica = matematica.multiplica(10,5);
		Assertions.assertEquals(50,multiplica);
		
	}

	@Test
	public void testSoma() {
		Matematica matematica = new Matematica();
		int soma = matematica.soma(10,5);
		Assertions.assertEquals(15,soma);
		
		
	}

	@Test
	public void testSubtracao() {
		Matematica matematica = new Matematica();
		int subtrai = matematica.subtracao(40,5);
		Assertions.assertEquals(35, subtrai);
		
	}
	
	@Test
	public void testSubtracaoNegativo() {
		Matematica matematica = new Matematica();
		int subtrai = matematica.subtracao(-70,-20);
		Assertions.assertEquals(-50, subtrai);
		
	}
	
	@Test
	public void testExponencial() {
		Matematica matematica = new Matematica();
		int potencia = matematica.potencia(5, 2);
		Assertions.assertEquals(25, potencia);
	}

}
