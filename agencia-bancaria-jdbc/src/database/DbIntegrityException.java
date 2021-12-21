package database;

public class DbIntegrityException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	
	//Ao tentar deletar um cliente que j� tenha movimenta��o vai dar um erro de integridade de banco
	//Chave estrangeira de uma tabela n�o podem referenciar uma tabela que n�o existe mais
	//exce��o personalizado criada para essa essa.
	public DbIntegrityException(String message) {
		super(message);
	}
	
	

}
