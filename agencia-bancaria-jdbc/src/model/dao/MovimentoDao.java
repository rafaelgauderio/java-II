package model.dao;

public interface MovimentoDao {
	
	void insertDepositoMovimento(Integer codCliente, Integer codOperacao,  double valor);
	void insertSaqueMovimento(Integer codCliente, Integer codOperacao,  double valor);
	void insertTranfereciaMovimento(Integer codCliente, Integer codClienteFavorecido, Integer codOperacao,  double valor);
	

}
