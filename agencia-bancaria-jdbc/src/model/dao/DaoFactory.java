package model.dao;

import database.DB;
import model.dao.implement.ClienteDaoJDBC;
import model.dao.implement.MovimentoDaoJDBC;

public class DaoFactory {
	
	public static ClienteDao criarClienteDao() {
		
		return new ClienteDaoJDBC(DB.getConnection());
		
	}
	
	public static MovimentoDao criarMovimentoDao() {
		return new MovimentoDaoJDBC(DB.getConnection());
	}
	
}
