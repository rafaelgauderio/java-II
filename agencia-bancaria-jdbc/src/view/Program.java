package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;



import database.DB;

public class Program {
	
	public static void main (String [] args) throws ParseException {
		
		Connection co = null;
		Statement st = null;
		ResultSet rs = null;
		

		try {
			co = DB.getConnection();
			st = co.createStatement();
			rs = st.executeQuery("SELECT * FROM Clientes");
			
			while (rs.next()) {

				System.out.println(rs.getInt("cod_cliente") + ", " + rs.getString("nome") + ", " + rs.getString("endereco") + ", "
						+ rs.getString("sexo") + ", " + rs.getDate("data_nasc") + ", " + String.format("U$ %.2f", rs.getDouble("saldo")));
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
