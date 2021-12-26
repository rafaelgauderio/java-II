package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;

import database.DB;
import model.Cliente;
import model.dao.ClienteDao;
import model.dao.DaoFactory;

public class AplicacaoConsole {
	
	public static void main (String [] args) throws ParseException {
		
		ClienteDao clienteDao = DaoFactory.criarClienteDao();
		
		
		System.out.println("TESTANDO INSERT");
		Cliente clienteNovo = new Cliente(null,"Jaime da Rocha","Rua Nova 35","M",new Date(),2500.50);
		clienteDao.insert(clienteNovo);
		System.out.println("CLIENTE INSERIDO COM SUCESSO. Codigo do cliente novo: " + clienteNovo.getCodCliente() );
		
		
		
				
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		

		try {
			co = DB.getConnection();
			st = co.createStatement();
			rs = st.executeQuery("SELECT * FROM Cliente");
			
			while (rs.next()) {

				System.out.println(rs.getInt("cod_cliente") + ", " + rs.getString("nome") + ", " + rs.getString("endereco") + ", "
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
