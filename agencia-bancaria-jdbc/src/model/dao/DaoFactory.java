package model.dao;

import database.DB;
import model.dao.implement.ClienteDaoJDBC;

public class DaoFactory {
	
	public static ClienteDao criarClienteDao() {
		
		return new ClienteDaoJDBC(DB.getConnection());
		
	}
}
