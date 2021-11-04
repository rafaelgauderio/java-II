package application;

import java.util.Arrays;

public class BubbleSort {
	
	private int [] arrayInteiros;
	
	public BubbleSort() {
		
		
	}		

	public BubbleSort(int[] arrayInteiros) {
		super();
		this.arrayInteiros = arrayInteiros;
	}

	public int[] getArrayInteiros() {
		return arrayInteiros;
	}

	public void setArrayInteiros(int[] arrayInteiros) {
		this.arrayInteiros = arrayInteiros;
	}

	public void ordenar(int [] arrayInteiros) {
		
		Arrays.sort(arrayInteiros);			
	}	
	
	public boolean isEmpty (int[] arrayInteiros) {
		 
		boolean vazio=false;
		if (arrayInteiros==null) {
			vazio=true;
		}
		return vazio;
		
	}
	
	public int [] adicionarArray(int [] arrayInteiros) {
		int tamanho = arrayInteiros.length;
		int saida[] = new int[tamanho]; 
		for (int i=0; i<arrayInteiros.length; i++) {
			saida[i]=arrayInteiros[i];
		}
		return saida;
	}
	
	
	@Override
	public String toString() {
		return "BubbleSort [arrayInteiros=" + Arrays.toString(arrayInteiros) + "]";
	}			
	

}
