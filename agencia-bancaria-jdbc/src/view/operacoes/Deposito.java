package view.operacoes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.dao.MovimentoDao;

public class Deposito extends JFrame {

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldDeposito;
	private final JButton btnConfirmar = new JButton("Confirmar");
	private JTextField textFieldCodigoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposito window = new Deposito();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Deposito() {
		initialize();
	}

	public void initialize() {

		frame = new JFrame();
		frame.setTitle("Dep\u00F3sito");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		JLabel lbCodigoCliente = new JLabel("C\u00F3d. Cliente:");
		lbCodigoCliente.setBounds(81, 32, 110, 35);
		lbCodigoCliente.setFont(new Font("Verdana", Font.BOLD, 14));
		lbCodigoCliente.setBackground(Color.BLACK);
		contentPane.add(lbCodigoCliente);

		textFieldDeposito = new JTextField();
		textFieldDeposito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDeposito.setBounds(210, 80, 197, 20);
		contentPane.add(textFieldDeposito);
		textFieldDeposito.setColumns(10);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldCodigoCliente.getText().isEmpty() || textFieldDeposito.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Informe o código do cliente e um valor maior que zero para depósito".toUpperCase(),"AVISO",JOptionPane.WARNING_MESSAGE);
				} else {
					Integer codigoCliente = Integer.parseInt(textFieldCodigoCliente.getText());
					Double valor = Double.parseDouble(textFieldDeposito.getText());
					ClienteDao clienteDao = DaoFactory.criarClienteDao();
					clienteDao.updateDeposito(codigoCliente, valor);				

				}

			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmar.setBounds(120, 143, 179, 41);
		contentPane.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
			}

		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(332, 143, 179, 41);
		contentPane.add(btnCancelar);

		JLabel lblValorDoDepsito = new JLabel("Valor do dep\u00F3sito:");
		lblValorDoDepsito.setFont(new Font("Verdana", Font.BOLD, 14));
		lblValorDoDepsito.setBackground(Color.BLACK);
		lblValorDoDepsito.setBounds(37, 70, 154, 35);
		contentPane.add(lblValorDoDepsito);

		textFieldCodigoCliente = new JTextField();
		textFieldCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCodigoCliente.setColumns(10);
		textFieldCodigoCliente.setBounds(210, 39, 197, 20);
		contentPane.add(textFieldCodigoCliente);
	}
}
