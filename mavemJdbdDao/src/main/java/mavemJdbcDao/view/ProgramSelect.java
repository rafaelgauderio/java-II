package mavemJdbcDao.view;

import java.util.List;
import mavemJdbcDao.controller.ProdutoDAO;
import mavemJdbcDao.model.Produto;

public class ProgramSelect {

	public static void main(String[] args) {

		ProdutoDAO produtoDAO = new ProdutoDAO();

		List<Produto> lista = produtoDAO.select();
		for (Produto produtos : lista) {
			System.out.println(produtos);

		}

	}
}
