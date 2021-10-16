package exercicio_revisao;


import java.util.Scanner;


public class PrincipalContaCorrente {


	static ContaCorrente conta = new ContaCorrente();
	static double valorDeposito=0;
	static double valorSaque=0;
	static int opcao = 0;


	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner (System.in);
			menu();		
			opcao= Integer.parseInt(sc.nextLine());

			switch (opcao) {
			case 1:
				execCadastrar();
				execConsulta();
				break;
			case 2:				
				execDeposito();	
				execConsulta();
				break;

			case 3:				
				execSaque();
				execConsulta();
				break;
			case 4:
				execConsulta();
				break;
			case 5:
				System.out.println("Fechando o sistema!");
				break;
			default:
				System.out.println("Informaste um número inválido. Informe um valor entre 1-5");

			}	


			sc.close();
		} catch (NumberFormatException error ) {
			error.printStackTrace();
		}

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

		System.out.println("\n--DADOS DO CORRENTISTA--");
		conta.imprimir();

	}

	public static void execDeposito() {

		System.out.println("Informe um valor para depositar: ");
		Scanner sc = new Scanner(System.in);
		valorDeposito = Double.parseDouble(sc.nextLine());
		conta.depositar(valorDeposito);
		sc.close();		


	}
	public static void execSaque() {	

		Scanner sc = new Scanner (System.in);
		//Depositar um valor na conta para poder realziar um saque
		conta.depositar(1500);
		System.out.println("Seu saldo atual é " + conta.getSaldo());
		System.out.println("Informe um valor para sacar menor que o seu saldo: ");	
		valorSaque = Double.parseDouble(sc.nextLine());		
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

	public static void menu() {
		System.out.println("--MENU--\n"
				+ "Digite 1 um para cadastrar um conta\n"
				+ "Digite 2 para realizar um depósito\n"
				+ "Digite 3 para realizar um saque\n"
				+ "Digite 4 para imprimir os dados do correntista\n"
				+ "Digite 5 para sair do sistema!");
	}



}
