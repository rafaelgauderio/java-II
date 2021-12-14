package mavemJdbcDao.view;

import mavemJdbcDao.controller.ProdutoDAO;

public class ProgramDelete {
	
	public static void main(String [] args) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		produtoDAO.delete(2);
		produtoDAO.delete(3);
		
	}

}
