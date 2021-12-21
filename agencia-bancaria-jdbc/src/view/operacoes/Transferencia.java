package view.operacoes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transferencia extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldValorTransf;
	private final JButton btnConfirmar = new JButton("Confirmar");
	private JTextField textFieldCodigoCliente;
	private JLabel lblCdClienteEmissor;
	private JTextField textFieldClienteReceb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transferencia frame = new Transferencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transferencia() {
		setTitle("Transfer\u00EAncias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCclienteRecebe = new JLabel("C\u00F3d. Cliente recebedor:");
		lblCclienteRecebe.setBounds(301, 34, 191, 35);
		lblCclienteRecebe.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCclienteRecebe.setBackground(Color.BLACK);
		contentPane.add(lblCclienteRecebe);
		
		textFieldValorTransf = new JTextField();
		textFieldValorTransf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldValorTransf.setBounds(201, 80, 197, 20);
		contentPane.add(textFieldValorTransf);
		textFieldValorTransf.setColumns(10);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmar.setBounds(120, 143, 179, 41);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(332, 143, 179, 41);
		contentPane.add(btnCancelar);
		
		JLabel lblValorDaTranferencia = new JLabel("Valor do transfer\u00EAncia:");
		lblValorDaTranferencia.setFont(new Font("Verdana", Font.BOLD, 14));
		lblValorDaTranferencia.setBackground(Color.BLACK);
		lblValorDaTranferencia.setBounds(10, 73, 193, 35);
		contentPane.add(lblValorDaTranferencia);
		
		textFieldCodigoCliente = new JTextField();
		textFieldCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCodigoCliente.setColumns(10);
		textFieldCodigoCliente.setBounds(201, 41, 84, 20);
		contentPane.add(textFieldCodigoCliente);
		
		lblCdClienteEmissor = new JLabel("C\u00F3d. Cliente emissor:");
		lblCdClienteEmissor.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCdClienteEmissor.setBackground(Color.BLACK);
		lblCdClienteEmissor.setBounds(20, 34, 171, 35);
		contentPane.add(lblCdClienteEmissor);
		
		textFieldClienteReceb = new JTextField();
		textFieldClienteReceb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldClienteReceb.setColumns(10);
		textFieldClienteReceb.setBounds(492, 41, 84, 20);
		contentPane.add(textFieldClienteReceb);
	}
}