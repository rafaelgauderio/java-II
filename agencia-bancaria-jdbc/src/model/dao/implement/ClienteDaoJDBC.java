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

	@SuppressWarnings("deprecation")
	@Override
	public void update(Cliente cliente) {

		PreparedStatement st = null;
		try {

			st = conectar.prepareStatement("UPDATE cliente "
					+ "SET nome= ?, endereco=?, sexo=?, dataNascimento=?, saldo=? " + "WHERE codCliente = ?");

			st.setString(1, cliente.getNome());
			st.setString(2, cliente.getEndereco());
			st.setString(3, cliente.getSexo());
			st.setDate(4, new java.sql.Date(cliente.getDataNascimento().getDate()));
			st.setDouble(5, cliente.getSaldo());
			st.setInt(6, cliente.getCodCliente());

			st.executeUpdate();
			System.out.println("Dados do Cliente ATUALIZADOS COM SUCESSO!");

		} catch (SQLException erro) {

			throw new DbException(erro.getMessage());

		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteByCod(Integer codCliente) {

		PreparedStatement st = null;

		try {
			st = conectar.prepareStatement("DELETE FROM cliente " + "WHERE codCliente = ?");
			st.setInt(1, codCliente);

			int linhasDeletadas = st.executeUpdate();

			if (linhasDeletadas == 0) {

				System.out.println(
						"O código do cliente informado NÃO EXISTE. Nenhum dado foi alterado. EXCLUSÃO NÃO REALIZADA!");

			} else {
				System.out.println("Dados EXCLUIDOS com sucesso");
			}

		} catch (SQLException erro) {
			throw new DbException(erro.getMessage());

		} finally {
			DB.closeStatement(st);
		}

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
			Cliente cliente = new Cliente();
			if (rs.next()) {

				cliente.setCodCliente(rs.getInt("codCliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setDataNascimento(rs.getDate("DataNascimento"));
				cliente.setSaldo(rs.getDouble("saldo"));
				return cliente;

			} else {
				System.out.println("Códido do cliente não encontrado.");

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

	@Override
	public void updateDeposito(Integer codCliente, double valor) {

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;

		try {

			st1 = conectar.prepareStatement(

					"SELECT codCliente, saldo " + "FROM cliente " + "WHERE cliente.codCliente = ?");

			st1.setInt(1, codCliente);
			rs = st1.executeQuery();
			Cliente cliente = new Cliente();

			if (rs.next() && valor >= 0) {

				cliente.setCodCliente(rs.getInt("codCliente"));
				cliente.setSaldo(rs.getDouble("saldo"));

				st2 = conectar.prepareStatement("UPDATE cliente " + "SET saldo=? " + "WHERE codCliente = ?");

				st2.setDouble(1, (cliente.getSaldo() + valor));
				st2.setInt(2, cliente.getCodCliente());
				st2.executeUpdate();
				System.out.println("DEPOSITO realizado COM SUCESSO!");

			} else {
				System.out.println("Códido do cliente não encontrado. Ou valor informado de depósito inválido!");

			}

		}

		catch (SQLException erro) {

			throw new DbException(erro.getMessage());

		} finally {
			DB.closeStatement(st1);
			DB.closeStatement(st2);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public void updateSaque(Integer codCliente, double valor) {

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		ResultSet rs = null;

		try {

			st1 = conectar.prepareStatement(

					"SELECT codCliente, saldo " + "FROM cliente " + "WHERE cliente.codCliente = ?");

			st1.setInt(1, codCliente);
			rs = st1.executeQuery();
			Cliente cliente = new Cliente();

			if (rs.next() && valor >= 0 && valor <= rs.getDouble("saldo")) {

				cliente.setCodCliente(rs.getInt("codCliente"));
				cliente.setSaldo(rs.getDouble("saldo"));

				st2 = conectar.prepareStatement("UPDATE cliente " + "SET saldo=? " + "WHERE codCliente = ?");

				st2.setDouble(1, (cliente.getSaldo() - valor));
				st2.setInt(2, cliente.getCodCliente());
				st2.executeUpdate();
				System.out.println("SAQUE realizado COM SUCESSO!");

			} else {
				System.out.println(
						"Códido do cliente não encontrado. Ou valor informado para Saque inválido ou maior que saldo do correntista!");

			}

		}

		catch (SQLException erro) {

			throw new DbException(erro.getMessage());

		} finally {
			DB.closeStatement(st1);
			DB.closeStatement(st2);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public void updateTransferencia(Integer codCliente, Integer codClienteFavorecido, double valor) {

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		PreparedStatement st4 = null;

		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {

			st1 = conectar.prepareStatement(

					"SELECT codCliente, saldo " + "FROM cliente " + "WHERE cliente.codCliente =?");

			st1.setInt(1, codClienteFavorecido);
			rs1 = st1.executeQuery();
			Cliente clienteFavorecido = new Cliente();

			st2 = conectar.prepareStatement(

					"SELECT codCliente, saldo " + "FROM cliente " + "WHERE cliente.codCliente =?");

			st2.setInt(1, codCliente);
			rs2 = st2.executeQuery();
			Cliente clienteDeposita = new Cliente();

			if (rs1.next() && valor >= 0 && rs2.next() && valor <= rs2.getDouble("saldo")) {

				clienteFavorecido.setCodCliente(rs1.getInt("codCliente"));
				clienteFavorecido.setSaldo(rs1.getDouble("saldo"));

				st3 = conectar.prepareStatement("UPDATE cliente " + "SET saldo=? " + "WHERE codCliente = ?");

				st3.setDouble(1, (clienteFavorecido.getSaldo() + valor));
				st3.setInt(2, clienteFavorecido.getCodCliente());
				st3.executeUpdate();

				clienteDeposita.setCodCliente(rs2.getInt("codCliente"));
				clienteDeposita.setSaldo(rs2.getDouble("saldo"));

				st4 = conectar.prepareStatement("UPDATE cliente " + "SET saldo=? " + "WHERE codCliente = ?");

				st4.setDouble(1, (clienteDeposita.getSaldo() - valor));
				st4.setInt(2, clienteDeposita.getCodCliente());
				st4.executeUpdate();
				System.out.println("TRANSFERÊNCIA realizada COM SUCESSO!");
				

			} else {
				System.out.println(
						"Códido do cliente não encontrado. Ou valor informado para Saque inválido ou maior que saldo do correntista!");

			}

		}

		catch (SQLException erro) {

			throw new DbException(erro.getMessage());

		} finally {
			DB.closeStatement(st1);
			DB.closeStatement(st2);
			DB.closeStatement(st3);
			DB.closeStatement(st4);
			DB.closeResultSet(rs1);
			DB.closeResultSet(rs2);
		}

	}

}
