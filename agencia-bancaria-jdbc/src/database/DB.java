package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	


	private static Connection conectar = null;

	public static Connection getConnection() {
		if (conectar == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conectar = DriverManager.getConnection(url, props);
			}

			catch (SQLException error) {
				throw new DbException(error.getMessage());

			}
		}
		return conectar;

	}

	public static void closeConnection() {
		if (conectar != null) {
			try {
				conectar.close();
			}

			catch (SQLException error) {
				throw new DbException(error.getMessage());

			}
		}

	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}

		catch (IOException error) {
			throw new DbException(error.getMessage());
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException erro) {
				throw new DbException(erro.getMessage());
			}
		}

	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException erro) {
				throw new DbException(erro.getMessage());
			}
		}

	}


}
