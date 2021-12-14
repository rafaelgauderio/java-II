package mavemJdbcDao.view;

import mavemJdbcDao.controller.ProdutoDAO;
import mavemJdbcDao.model.Produto;

public class ProgramInsert {
	
	public static void main(String [] args) {
		
		Produto p1 = new Produto(null,"Camiseta",13.45,20,"Camiseta polo vermelha - tamanho M");
		Produto p2 = new Produto(null,"Calça",50.90,35,"Calça Bege - tamanho 42");
		Produto p3 = new Produto(null,"Cueca",9.90,20,"Cueca Box Branca - tamanho G");
		Produto p4 = new Produto(null,"Meia",3.90,100,"Meia Branca Curta - 38 ao 43");
		Produto p5 = new Produto(null,"Jaqueta",120.50,15,"Jaqueta de Couro Preta - Tamanho GG ");
		Produto p6 = new Produto(null,"Camisa",150.50,30,"Camise executiva Branca - Tamanho P");
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.insert(p1);
		produtoDAO.insert(p2);
		produtoDAO.insert(p3);
		produtoDAO.insert(p4);
		produtoDAO.insert(p5);
		produtoDAO.insert(p6);
		
		
		
	}
	
	
	

}
