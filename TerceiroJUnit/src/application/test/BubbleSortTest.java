package application.test;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import application.BubbleSort;
import java.util.Arrays;

public class BubbleSortTest {	

	boolean boo = false;
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/	
	
	@Test
	public void testIsEmpty() {
		
		
		BubbleSort bubble = new BubbleSort();
		
		//verificando método nulll
		boo = bubble.isEmpty(bubble.getArrayInteiros());
		Assert.assertEquals(true,boo);
		Assert.assertNull(bubble.getArrayInteiros());
		
		
		//verificando com elemento não pode ser num
		int [] vetorArray = new int[]{1,4,7};
		int [] vetorUnicoElemento = new int[] {7};
		boo = bubble.isEmpty(vetorUnicoElemento);
		Assert.assertEquals(false,boo);
		Assert.assertEquals(false,boo);
				
		
	}
	
	
	@Test
	public void testAdicionarArray () {
		
		BubbleSort bubble = new BubbleSort();
		int [] esperado = new int[] {4,1};
		Assert.assertArrayEquals(esperado, bubble.adicionarArray(new int [] {4,1}));
		
	}		
	
	
	@Test
	public void testOrdenarArray() {
		
		BubbleSort bubble2 = new BubbleSort();
		int [] desordenado = new int [] {7,35,6,1};		
		bubble2.ordenar(desordenado);
		int [] ordenado = new int []{1,6,7,35}; 
		Assert.assertArrayEquals(ordenado,desordenado);
		
	}
	
	
		


}
