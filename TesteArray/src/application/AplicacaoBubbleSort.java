package application;




public class AplicacaoBubbleSort {
	
	
	public static void main (String [] args) {
		
		
		BubbleSort bubble = new BubbleSort();		
		System.out.println(bubble.isEmpty(null));
		
		int [] arrayInteiros = new int[] {15,7,9,35,8,56,3,11,4,2,0,4};		
		bubble.setArrayInteiros(arrayInteiros);		
		System.out.println(bubble);
		
		//ordenando
		bubble.ordenar(arrayInteiros);		
		System.out.println("Array ordenado\n"+ bubble);		
		System.out.println(bubble.isEmpty(arrayInteiros));
		
				
		int [] vetorVazio = new int[5];
		bubble.setArrayInteiros(vetorVazio);
		System.out.println(bubble.isEmpty(vetorVazio));	
		
		bubble.adicionarArray((arrayInteiros));
		System.out.println(bubble);
		
				
		int [] desordenado = new int [] {7,35,6,1,4,99,6,-8};
		BubbleSort bubble2 = new BubbleSort(desordenado);
		System.out.println("\nVetor desordenado\n"+bubble2);		
		
		bubble2.ordenar(desordenado);		
		bubble2.setArrayInteiros(desordenado);
		System.out.println("\nVetor ordenado\n"+bubble2);	
	
		
		System.out.println(fatorial(10));
		
	}
	
	public static int fatorial(int numero) {
		int resultado=1;
		if (numero==0 ||numero==1 ) {
			return resultado=1;
		}
		else {
			for(int i=numero; i<1; i--) {
				resultado = resultado+resultado*numero;
			}
		}
		
		return resultado;
		
	}
	

}
