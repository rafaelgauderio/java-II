
public class Program {

	public static void main(String[] args) {		
		
		
		
		System.out.println(fatorial(-7));
		System.out.println(fatorial(0));
		System.out.println(fatorial(1));
		System.out.println(fatorial(2));
		System.out.println(fatorial(3));
		System.out.println(fatorial(4));
		System.out.println(fatorial(5));
		System.out.println(fatorial(6));
		System.out.println(fatorial(15)/fatorial(14));		
		System.out.println(fatorial(25));
		
		
		System.out.println("\nRECURSIVAMENTE\n"+fatorialRecursivo(3));
		System.out.println(fatorialRecursivo(-5));
		System.out.println(fatorialRecursivo(6));
		System.out.println(fatorialRecursivo(10));
		
	}
	
	
	public static long fatorial(int numero) {
		
		long aux=1;
		if (numero<0) {
			System.out.println("Não existe fatorial de número negativo");
		}
		
		if (numero==0 ||numero==1 ) {
			aux=1;
		}
		else {
			for(int i=numero; i>1; i--) {
				aux=aux*i;
			}
		}
		
		return aux;
		
	}
	
	
	public static long fatorialRecursivo(int numero) {
		
		long fat=1;
		if (numero<0) {
			System.out.println("Não existe fatorial de número negativo");
		}
		
		if (numero==0 ||numero==1 ) {
			fat=1;
		}
		else {
			for(int i=numero; i>1; i--) {
				fat=numero* fatorialRecursivo(numero-1);
			}
		}
		
		return fat;
		
	}
	

}
