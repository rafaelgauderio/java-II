package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import model.Cliente;
import model.dao.ClienteDao;
import model.dao.DaoFactory;

public class AplicacaoConsole {
	
	public static void main (String [] args) throws ParseException {
		
		ClienteDao clienteDao = DaoFactory.criarClienteDao();
		
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		java.sql.Date date = new java.sql.Date(sdf.parse("15/12/1995").getDate());
		
				
			
		System.out.println("\nTESTANDO O PROCURAR POR CODIGO DO CLIENTE");
		Cliente cliente = clienteDao.searchByCod(3);
		System.out.println(cliente);
		
		System.out.println("\nTESTANDO SEARCHALLCLIENTS");
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = clienteDao.searchAllClients();
		for(Cliente objeto : lista) {
			System.out.println(objeto);
			
		}
		
		System.out.println("\nTESTANDO INSERT");
		Cliente clienteNovo = new Cliente(null,"Mariana De Luca ","Rua Sertorio 35, Apto: 25","F",date,3800.50);
		clienteDao.insert(clienteNovo);
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo.getCodCliente() +"\n" );
		
		System.out.println("\nTESTANDO UPDATE");
		Cliente clienteUpdate = clienteDao.searchByCod(5);
		clienteUpdate.setNome("Juliana da Silva");
		clienteUpdate.setEndereco("Rua nova lima 50");
		clienteUpdate.setSexo("F");
		java.sql.Date dateUpdate = new java.sql.Date(sdf.parse("17/08/1995").getDate());
		clienteUpdate.setDataNascimento(dateUpdate);
		clienteDao.update(clienteUpdate);
		
		
		System.out.println("\nTESTANDO DELETE");
		System.out.println("Excluindo id = 15" );
		clienteDao.deleteByCod(15);
		System.out.println("Excluindo um id que não tem no database");
		clienteDao.deleteByCod(356);
		
			
		
		
		
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
