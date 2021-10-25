package br.edu.aulas;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class MatematicaTest {
	
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
		int divideZero = matematica.divide(0, 5);
		int divididoPorZero=matematica.divide(10,0);
		
		
		int divide = matematica.divide(50,5);
		assertEquals(10,divide);
		assertEquals(0,divideZero);
		assertEquals(0, divididoPorZero);
		
	}

	@Test
	public void testMultiplica() {
		Matematica matematica = new Matematica();
		int multiplica = matematica.multiplica(10,5);
		assertEquals(50,multiplica);
		
	}

	@Test
	public void testSoma() {
		Matematica matematica = new Matematica();
		int soma = matematica.soma(10,5);
		assertEquals(15,soma);
		
		
	}

	@Test
	public void testSubtracao() {
		Matematica matematica = new Matematica();
		int subtrai = matematica.subtracao(40,5);
		assertEquals(35, subtrai);
		
	}
	
	@Test
	public void testSubtracaoNegativo() {
		Matematica matematica = new Matematica();
		int subtrai = matematica.subtracao(-70,-20);
		assertEquals(-50, subtrai);
		
	}
	
	@Test
	public void testExponencial() {
		Matematica matematica = new Matematica();
		int potencia = matematica.potencia(5, 2);
		assertEquals(25, potencia);
	}

}
