package model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import database.DB;
import database.DbException;
import model.Cliente;
import model.dao.ClienteDao;

public class ClienteDaoJDBC implements ClienteDao {
	
	
	private Connection conectar;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conectar=conn;
	}
	

	@Override
	public void insert(Cliente cliente) {
		PreparedStatement st = null;
		try {
			st = conectar.prepareStatement(
					"INSERT INTO cliente "
					+ "(nome, endereco, sexo, dataNascimento, saldo) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getEndereco());
			st.setString(3,cliente.getSexo() );
			st.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
			st.setDouble(5, cliente.getSaldo());
			
			int LinhasInseridas = st.executeUpdate();
			
			if (LinhasInseridas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					cliente.setCodCliente(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro. Nenhum linha for inserida" );
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}
		
	

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> searchAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

}
