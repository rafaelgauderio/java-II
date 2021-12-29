package model.dao;

import java.util.List;

import model.Cliente;

public interface ClienteDao {
	
	void insert(Cliente cliente);
	void update(Cliente cliente);
	void updateDeposito(Integer CodCliente, double valor);
	void updateSaque(Integer codCliente, double valor);
	void updateTransferencia(Integer codCliente, Integer codClienteFavorecido, double valor);
	void deleteByCod(Integer CodCliente);
	Cliente searchByCod(Integer codCliente);
	List<Cliente> searchAllClients();	
	
		
	
	

}
