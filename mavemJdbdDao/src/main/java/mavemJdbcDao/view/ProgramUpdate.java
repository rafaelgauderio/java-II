package mavemJdbcDao.view;

import mavemJdbcDao.controller.ProdutoDAO;
import mavemJdbcDao.model.Produto;

public class ProgramUpdate {

	public static void main(String[] args) {

		Produto p1 = new Produto(1,"Gravata", 90.50, 20, "Gravata rosa com bolinhas - tamanho M");
		Produto p2 = new Produto(2, "Cal�a", 50.90, 35, "Cal�a Laranja - tamanho 38");	
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.update(p1);
		produtoDAO.update(p2);		
	
		

	}

}
