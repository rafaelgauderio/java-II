package view.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.dao.ClienteDao;
import model.dao.DaoFactory;

public class Atualizar extends JFrame {

	private static final long serialVersionUID = 1L;

	public JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldEndereco;
	private JTextField textFieldSaldo;
	private JTextField textFieldCodigoCliente;
	private final JButton btnSalvar = new JButton("Atualizar");
	private ClienteDao clienteDao;
	private Cliente clienteAtualizar;
	private JComboBox<String> comboBoxSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atualizar window = new Atualizar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Atualizar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Atualiza\u00E7\u00E3o de Cliente");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("C\u00F3d. Cliente:");
		lblNome.setBounds(81, 32, 110, 35);
		lblNome.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNome.setBackground(Color.BLACK);
		contentPane.add(lblNome);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(20, 116, 180, 35);
		lblDataDeNascimento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDataDeNascimento.setBackground(Color.BLACK);
		contentPane.add(lblDataDeNascimento);

		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setBounds(210, 162, 117, 22);
		comboBoxSexo.setEditable(true);
		contentPane.add(comboBoxSexo);
		comboBoxSexo.addItem("--SELECIONE--");
		comboBoxSexo.addItem("M");
		comboBoxSexo.addItem("F");
		comboBoxSexo.setSelectedItem("--SELECIONE--");

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(146, 154, 88, 35);
		lblSexo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSexo.setBackground(Color.BLACK);
		contentPane.add(lblSexo);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(112, 200, 88, 35);
		lblEndereo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEndereo.setBackground(Color.BLACK);
		contentPane.add(lblEndereo);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSaldo.setBackground(Color.BLACK);
		lblSaldo.setBounds(332, 238, 88, 35);
		contentPane.add(lblSaldo);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNome.setBounds(210, 80, 366, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(210, 123, 366, 20);
		contentPane.add(textFieldDataNascimento);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(210, 207, 366, 20);
		contentPane.add(textFieldEndereco);

		textFieldSaldo = new JTextField();
		textFieldSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSaldo.setColumns(10);
		textFieldSaldo.setBounds(408, 245, 168, 20);
		contentPane.add(textFieldSaldo);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clienteDao = DaoFactory.criarClienteDao();
				Cliente cliente = new Cliente();

				cliente.setNome(textFieldNome.getText());
				cliente.setEndereco(textFieldEndereco.getText());
				cliente.setSexo(String.valueOf(comboBoxSexo.getSelectedItem()));
				cliente.setSaldo(Double.parseDouble(textFieldSaldo.getText()));

				SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/YYYY");
				java.sql.Date dataNascimento = null;
				try {
					dataNascimento = new java.sql.Date(formatoData.parse(textFieldDataNascimento.getText()).getDate());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				cliente.setDataNascimento(dataNascimento);
				cliente.setCodCliente(Integer.parseInt(textFieldCodigoCliente.getText()));
				clienteDao.update(cliente);

				textFieldDataNascimento.setText(formatoData.format(dataNascimento));

			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(125, 290, 179, 41);
		btnSalvar.setEnabled(false);
		contentPane.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(337, 290, 179, 41);
		contentPane.add(btnCancelar);

		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		label.setBackground(Color.BLACK);
		label.setBounds(130, 70, 88, 35);
		contentPane.add(label);

		textFieldCodigoCliente = new JTextField();
		textFieldCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCodigoCliente.setColumns(10);
		textFieldCodigoCliente.setBounds(210, 39, 197, 20);
		contentPane.add(textFieldCodigoCliente);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clienteDao = DaoFactory.criarClienteDao();
				Integer codigoCliente = Integer.parseInt(textFieldCodigoCliente.getText());
				clienteAtualizar = clienteDao.searchByCod(codigoCliente);
				if (clienteAtualizar == null) {
					btnSalvar.setEnabled(false);
					textFieldNome.setText("");
					textFieldEndereco.setText("");
					textFieldDataNascimento.setText("");
					textFieldSaldo.setText("");
					comboBoxSexo.setSelectedIndex(0);

				} else {

					textFieldNome.setText(clienteAtualizar.getNome());
					textFieldEndereco.setText(clienteAtualizar.getEndereco());
					comboBoxSexo.setSelectedItem(clienteAtualizar.getSexo());
					textFieldSaldo.setText(String.valueOf(clienteAtualizar.getSaldo()));
					SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/YYYY");
					java.sql.Date dataNascimento = (Date) clienteAtualizar.getDataNascimento();
					textFieldDataNascimento.setText(formatoData.format(dataNascimento));

					btnSalvar.setEnabled(true);
				}

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(432, 32, 123, 41);
		contentPane.add(btnBuscar);
	}
}
