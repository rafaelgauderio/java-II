package mavemJdbcDao.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mavemJdbcDao.model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String DATABASE_URL = "jdbc:mysql://localhost/mavemjpa?useSSL=false&amp";
			String usuario = "root";
			String senha = "hygie123*";
			this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);

		} catch (ClassNotFoundException | SQLException excecao) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, excecao);
		}

	}

	public List<Produto> select() {
		String sql = "SELECT * FROM produto";
		List<Produto> retorno = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Produto produto = new Produto();
				produto.setId(resultado.getInt("id"));
				produto.setNome(resultado.getString("nome"));
				produto.setPreco(resultado.getDouble("preco"));
				produto.setQtdEstoque(resultado.getInt("quantidadeEstoque"));
				produto.setDescricao(resultado.getString("descricao"));
				retorno.add(produto);

			}

		} catch (SQLException excecao) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, excecao);
		}
		return retorno;
	}

	public void update(Produto produto) {

		String sql = "UPDATE produto SET nome=?, preco=?, quantidadeEstoque=?, descricao=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQtdEstoque());
			stmt.setString(4, produto.getDescricao());
			stmt.setInt(5, produto.getId());
			stmt.execute();
			System.out.println("PRODUTO DE ID="+ produto.getId() + " ALTERADO COM SUCESSO");

		} catch (SQLException exception) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, exception);

		}

	}

	public void insert(Produto produto) {

		String sql = "INSERT INTO produto(nome, preco, quantidadeEstoque, descricao) VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQtdEstoque());
			stmt.setString(4, produto.getDescricao());
			stmt.execute();
			System.out.println("PRODUTO INSERIDO COM SUCESSO");

		} catch (SQLException exception) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, exception);

		}
	}

	public void delete(Integer id) {

		String sql = "DELETE FROM produto WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			System.out.println("PRODUTO DE ID="+ id + " EXCLUÍDO COM SUCESSO");

		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);

		}
	}
}
