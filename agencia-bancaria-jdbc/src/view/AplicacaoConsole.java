package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.DB;
import model.Cliente;
import model.dao.ClienteDao;
import model.dao.DaoFactory;

public class AplicacaoConsole {
	
	public static void main (String [] args) throws ParseException {
		
		ClienteDao clienteDao = DaoFactory.criarClienteDao();
		
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		java.sql.Date date = new java.sql.Date(sdf.parse("15/12/1995").getDate());
		
		
		
		System.out.println("TESTANDO INSERT");
		Cliente clienteNovo = new Cliente(null,"Mariana De Luca ","Rua Sertorio 35, Apto: 25","F",date,3800.50);
		clienteDao.insert(clienteNovo);
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo.getCodCliente() +"\n" );
		
		
		System.out.println("\nTESTANDO O PROCURAR POR CODIGO DO CLIENTE");
		Cliente cliente = clienteDao.searchByCod(3);
		System.out.println(cliente);
		
		
		
				
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
		
		
		

		
	}

}
