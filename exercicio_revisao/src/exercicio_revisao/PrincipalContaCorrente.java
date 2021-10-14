package exercicio_revisao;


import java.util.Scanner;


public class PrincipalContaCorrente {
	
		
	static ContaCorrente conta = new ContaCorrente();
	static double valorDeposito=900.50;
	static double valorSaque=200.25;
	


	public static void main(String[] args) {
		
		

		execCadastrar();
		execConsulta();
		execDeposito();
		execSaque();
		
		System.out.println("\n--Imprimindo valores após realizar saque e deposito--");
		execConsulta();		
		



	}

	public static void execCadastrar() {
		
		
		System.out.println("Informe um nome(string), agencia(int) e conta(int): ");
		Scanner sc = new Scanner(System.in);
		conta.setNomeCliente(sc.nextLine());
		conta.setAgencia(sc.nextLong());
		conta.setConta(sc.nextLong());		
		sc.close();

	}

	public static void execConsulta() {
		
		conta.imprimir();

	}

	public static void execDeposito() {
		
		System.out.println("Informe um valor para depositar: ");
		Scanner sc = new Scanner(System.in);
		//valorDeposito = Double.parseDouble(sc.nextLine());
		conta.depositar(valorDeposito);
		sc.close();
		
		
		

	}
	public static void execSaque() {	
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Seu saldo atual é " + conta.getSaldo());
		System.out.println("Informe um valor para sacar: ");	
		//valorSaque = Double.parseDouble(sc.nextLine());
				
		System.out.println("Valor tentado sacar: " + valorSaque);
		if (conta.getSaldo()<=valorSaque) {
			System.out.println("Saque NÃO realizado!");
		}
		else if(conta.getSaldo()>valorSaque) {
			
			
			conta.sacar(valorSaque);
			System.out.println("Saque realizado com sucesso!");
		}
		
		sc.close();
			

	}
	
	

}
