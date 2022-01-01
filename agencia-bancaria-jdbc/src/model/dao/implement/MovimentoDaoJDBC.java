package model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.DB;
import database.DbException;
import model.Movimento;
import model.dao.MovimentoDao;

public class MovimentoDaoJDBC implements MovimentoDao{
	
	private Connection conectar;
	public JFrame frame = new JFrame();

	public MovimentoDaoJDBC(Connection conn) {
		this.conectar = conn;
	}
	
	@Override
	public void insertDepositoMovimento(Integer codCliente, Integer codOperacao,
			double valor) {

		//DateFormat dataFormata = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//Calendar cal = Calendar.getInstance();
		
		
		PreparedStatement st = null;
		try {
			
			
			st = conectar.prepareStatement("INSERT INTO movimentacoes (cod_cliente, cod_cliente_favorecido, cod_operacao, valor, data_hora_movimento) "
					+ "VALUES "+"(?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);

			st.setInt(1, codCliente);
			st.setNull(2,Types.INTEGER);
			st.setInt(3, codOperacao);
			st.setDouble(4, valor);
			st.setTimestamp(5, new java.sql.Timestamp(java.util.Calendar.getInstance().getTimeInMillis()));

			int LinhasInseridas = st.executeUpdate();
			Movimento movimento = new Movimento();
			if (LinhasInseridas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					movimento.setCodCliente(id);
					frame.setBounds(100, 100, 600, 400);
					JOptionPane.showMessageDialog(frame, "Deposito inserido na Tabela Movimentações do Cliente", "DEPOSITO", //
							JOptionPane.INFORMATION_MESSAGE);					

				}
				DB.closeResultSet(rs);
			} else {
				frame.setBounds(100, 100, 600, 400);
				JOptionPane.showMessageDialog(frame, "Não foi alterada a base de dados de movimentação do cliente", "DEPOSITO", //
						JOptionPane.ERROR_MESSAGE);

				throw new DbException("Erro. Nenhuma linha for inserida");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void insertSaqueMovimento(Integer codCliente, Integer codOperacao,
			double valor) {
		
		
	}

	@Override
	public void insertTranfereciaMovimento(Integer codCliente, Integer codClienteFavorecido, Integer codOperacao,
			double valor) {
		
		
	}
	

}
