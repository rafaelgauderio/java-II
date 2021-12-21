package database;

public class DbIntegrityException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	
	//Ao tentar deletar um cliente que já tenha movimentação vai dar um erro de integridade de banco
	//Chave estrangeira de uma tabela não podem referenciar uma tabela que não existe mais
	//exceção personalizado criada para essa essa.
	public DbIntegrityException(String message) {
		super(message);
	}
	
	

}
