package exercicio_revisao;

import java.util.ArrayList;
import java.util.List;


public class FuncionarioTeste {

	public static void main(String [] args) {


		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		
		Data d1 = new Data();
		Data d2 = new Data();

		f1.setNome("Rafael de Luca");
		f1.setDepartamento("Desenvolvedores");
		f1.setSalario(1000);
		d1.setAno(2015);
		d1.setMes(12);
		d1.setDia(24);
		f1.setDataEntrada(d1);
		f1.setRg("304509871239");
		f1.setEstaNaEmpresa(true);
		f1.bonifica(100);

		System.out.println("O salário atual do funcionário " +f1.getNome().toUpperCase() + " é " + String.format("%.2f", f1.getSalario()));

		f2.setNome("Cristina da Silva");
		f2.setDepartamento("Recepção");
		f2.setSalario(2500);
		d2.setAno(2017);
		d2.setMes(07);
		d2.setDia(01);
		f2.setDataEntrada(d2);
		f2.setRg("43249871239");
		f2.setEstaNaEmpresa(true);
		f2.bonifica(300);
		f2.demite();

		System.out.println("\n--método mostra()--");		
		f1.mostra();		


		System.out.println("\n--toString()--");
		System.out.println(f1);
		System.out.println(f2);		


		System.out.println("--Vetor--");
		//armazendo o funcionários em um vetor e depois imprimindo
		Funcionario [] vetorFuncionario = new Funcionario[2];
		vetorFuncionario[0]=f1;
		vetorFuncionario[1]=f2;

		for(int i=0 ; i <vetorFuncionario.length ; i++) {
			System.out.println(vetorFuncionario[i]);
		}


		System.out.println("--Lista--");
		//armazenado em uma lista e depois imprimindo
		List<Funcionario> lista = new ArrayList<Funcionario>();
		lista.add(f1);
		lista.add(f2);

		for(Funcionario apelido : lista) {

			System.out.println(apelido);

		}		
		
		
		System.out.println("\n--testar igualdade--");
		testaFuncionariosIguais();
		testaFuncionariosComMesmaReferencia();
		
		System.out.println("\n--testar data");
		testaDataEntrada();


	}


	public static void testaFuncionariosIguais() {

		Funcionario f1 = new Funcionario();
		f1.setNome("Rodrigo");
		f1.setSalario(100);
		
		Funcionario f2 = new Funcionario();
		f2.setNome("Rodrigo");
		f2.setSalario(100);
		
		
		if (f1.iguais(f2)) {
			System.out.println("Os funcionários são iguais");
		}
		else {
			System.out.println("Os funcionários são diferentes");
		}
	
	}
	
	public static void testaFuncionariosComMesmaReferencia() {
		
		Funcionario f1 = new Funcionario();
		f1.setNome("Leonardo");
		f1.setSalario(100);
		Funcionario f2 = f1;
		
		if (f1.iguais(f2)) {
			System.out.println("Os funcionários são iguais");
		}
		else {
			System.out.println("Os funcionários são diferentes");
		}		
		
		
	}
	
	public static void testaDataEntrada() {
		
		Funcionario f3 = new Funcionario();
		Data d3 = new Data();
		
		f3.setNome("João da Silva");
		f3.setDepartamento("Gerente");
		f3.setSalario(2300);		
		f3.setRg("304509871239");
		f3.setEstaNaEmpresa(true);
		
		System.out.println("--Antes de atribuir data--");
		f3.mostra();
		
		d3.setAno(2014);
		d3.setMes(03);
		d3.setDia(01);
		f3.setDataEntrada(d3);
		System.out.println("--Após de atribuir data--");
		f3.mostra();
		
		
		
		
		
		
	}
	
	
}
