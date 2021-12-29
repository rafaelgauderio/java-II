package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.dao.ClienteDao;
import model.dao.DaoFactory;

public class AplicacaoConsole {
	
	public static void main (String [] args) throws ParseException {
		
		ClienteDao clienteDao = DaoFactory.criarClienteDao();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		java.sql.Date date = new java.sql.Date(sdf.parse("05/12/1995").getTime());
		java.sql.Date date2 = new java.sql.Date(sdf.parse("08/01/1987").getTime());
		
		System.out.println("\nTESTANDO INSERT");
		Cliente clienteNovo = new Cliente(null,"Mariana De Luca ","Rua Sertorio 35, Apto: 25","F",date,3800.50);
		Cliente clienteNovo2 = new Cliente(null,"Rafael De Luca ","Rua Brasil 28","M",date,3500.50);
		Cliente clienteNovo3 = new Cliente(null,"Claudia de Lima ","Rua Alberto Torres 98, Apto: 30","F",date2,800.50);
		Cliente clienteNovo4 = new Cliente(null,"Larrisa Nova ","Rua Alvarenga 35, Apto: 13","F",date2,4500.50);
		Cliente clienteNovo5 = new Cliente(null,"Tomas de Aquinho ","Rua Lucio 20, Apto: 25","M",date2,2700);
		clienteDao.insert(clienteNovo);
		clienteDao.insert(clienteNovo2);
		clienteDao.insert(clienteNovo3);
		clienteDao.insert(clienteNovo4);
		clienteDao.insert(clienteNovo5);		
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo.getCodCliente());
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo2.getCodCliente());
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo3.getCodCliente());
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo4.getCodCliente());
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo5.getCodCliente());
		
			
		System.out.println("\nTESTANDO O PROCURAR POR CODIGO DO CLIENTE");
		Cliente cliente = clienteDao.searchByCod(3);
		System.out.println(cliente);
		
		System.out.println("\nTESTANDO SEARCHALLCLIENTS");
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = clienteDao.searchAllClients();
		for(Cliente objeto : lista) {
			System.out.println(objeto);
			
		}	
		
		
		System.out.println("\nTESTANDO UPDATE");
		Cliente clienteUpdate = clienteDao.searchByCod(4);
		clienteUpdate.setNome("Juliana da Silva");
		clienteUpdate.setEndereco("Rua nova lima 50");
		clienteUpdate.setSexo("F");
		java.sql.Date dateUpdate = new java.sql.Date(sdf.parse("17/08/1995").getDate());
		clienteUpdate.setDataNascimento(dateUpdate);
		clienteDao.update(clienteUpdate);
		
		
		System.out.println("\nTESTANDO DELETE");
		System.out.println("Excluindo id = 15" );
		clienteDao.deleteByCod(2);
		System.out.println("Excluindo um id que não tem no database");
		clienteDao.deleteByCod(356);
		
		System.out.println("\nTESTANDO DEPOSITO");
		clienteDao.updateDeposito(1,5000);
		clienteDao.updateDeposito(2,4000);
		clienteDao.updateDeposito(4,6000.50);
		
		
		
		System.out.println("\nTESTANDO SAQUE");
		clienteDao.updateSaque(1,25000);
		clienteDao.updateSaque(2,3000);
		clienteDao.updateSaque(3,-800);
		clienteDao.updateSaque(700,2500);		
		
		
		System.out.println("\nTESTANDO TRANSFERÊNCIA");
		clienteDao.updateTransferencia(61, 62, 49);
		clienteDao.updateTransferencia(500, 62, 600);
		clienteDao.updateTransferencia(61, 62, -800);
		
		
		/*
		//testando conexão
				
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		

		try {
			co = DB.getConnection();
			st = co.createStatement();
			rs = st.executeQuery("SELECT * FROM Cliente");
			
			System.out.println();
			
			
			while (rs.next()) {

				System.out.println(rs.getInt("codCliente") + ", " + rs.getString("nome") + ", " + rs.getString("endereco") + ", "
						+ rs.getString("sexo") + ", " + rs.getDate("dataNascimento") + ", " + String.format("U$ %.2f", rs.getDouble("saldo")));
			}

			System.out.println();
			
			
			
		} catch (SQLException error) {
			error.printStackTrace();

		}

		finally {
			DB.closeStatement(st);			
			DB.closeConnection();

		}
		
		
		*/

		
	}

}
