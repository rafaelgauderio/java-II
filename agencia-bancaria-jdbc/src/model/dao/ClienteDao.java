package model.dao;

import java.util.List;

import model.Cliente;

public interface ClienteDao {
	
	void insert(Cliente cliente);
	void update(Cliente cliente);
	void deleteById(Integer id);
	Cliente searchById(Integer id);
	List<Cliente> searchAllClients();	
		
	
	

}
