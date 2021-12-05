package mavemJpa.view;




import mavemJpa.controller.DataBaseController;
import mavemJpa.model.Produto;

public class Program {
	
	public static void main (String [] args) {		
		
		Produto p1 = new Produto(null,"Camiseta",13.45,20,"Camiseta polo vermelha - tamanho M");
		Produto p2 = new Produto(null,"Calça",50.90,35,"Calça Bege - tamanho 42");
		Produto p3 = new Produto(null,"Cueca",9.90,20,"Cueca Box Branca - tamanho G");
		Produto p4 = new Produto(null,"Meia",3.90,100,"Meia Branca Curta - 38 ao 43");
		Produto p5 = new Produto(null,"Jaqueta",120.50,15,"Jaqueta de Couro Preta - Tamanho GG ");
		Produto p6 = new Produto(null,"Camisa",150.50,30,"Camise executiva Branca - Tamanho P");
		
		
		DataBaseController dbc = new DataBaseController();
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("mavemJpa");  
		//EntityManager em = emf.createEntityManager();
		
		dbc.saveData(p1);
		dbc.saveData(p2);
		dbc.saveData(p3);
		dbc.saveData(p4);
		dbc.saveData(p5);
		dbc.saveData(p6);
		
		
		//busca de produtos
		Produto produto1 = dbc.findProductById(2);
		Produto produto2 = dbc.findProductById(35);		
		System.out.println(produto1);
		System.out.println(produto2);
		System.out.println(dbc.findProductById(3));
		dbc.findProducts("cami");
		dbc.findProducts("EIA");
		
		//remoção de produtos com id null e diferente de null
		dbc.deleteProduct(produto1);
		dbc.deleteProduct(produto2);		
		
		
		//encerrar a conexão com o banco
		dbc.closeConnection();		
		System.out.println("Programa Finalizado com Sucesso!");
		
	
	}		
	
	

}
