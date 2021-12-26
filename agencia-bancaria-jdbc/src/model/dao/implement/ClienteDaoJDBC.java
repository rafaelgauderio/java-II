package model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import database.DbException;
import model.Cliente;
import model.dao.ClienteDao;

public class ClienteDaoJDBC implements ClienteDao {

	private Connection conectar;

	public ClienteDaoJDBC(Connection conn) {
		this.conectar = conn;
	}

	@Override
	public void insert(Cliente cliente) {
		PreparedStatement st = null;
		try {
			st = conectar.prepareStatement("INSERT INTO cliente " + "(nome, endereco, sexo, dataNascimento, saldo) "
					+ "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getEndereco());
			st.setString(3, cliente.getSexo());
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
			} else {
				throw new DbException("Erro. Nenhum linha for inserida");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByCod(Integer codCliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente searchByCod(Integer codCliente) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conectar.prepareStatement(

					"SELECT codCliente, nome, endereco, sexo, DataNascimento, saldo " + "FROM cliente "
							+ "WHERE cliente.codCliente = ?");

			st.setInt(1, codCliente);
			rs = st.executeQuery();
			if (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setCodCliente(rs.getInt("codCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setDataNascimento(rs.getDate("DataNascimento"));
				cliente.setSaldo(rs.getDouble("saldo"));
				return cliente;

			}
			return null;
		} catch (SQLException erro) {
			throw new DbException(erro.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Cliente> searchAllClients() {
		

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conectar.prepareStatement(

					"SELECT codCliente, nome, endereco, sexo, DataNascimento, saldo " + "FROM cliente "
							+ "ORDER BY codCliente");
			
			rs = st.executeQuery();
			List<Cliente> lista = new ArrayList<Cliente>();
			
			
			while (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setCodCliente(rs.getInt("codCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setDataNascimento(rs.getDate("DataNascimento"));
				cliente.setSaldo(rs.getDouble("saldo"));
				
				lista.add(cliente);

			}
			
			return lista;
			
		} catch (SQLException erro) {
			throw new DbException(erro.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}	
		
		
		
	}

}
