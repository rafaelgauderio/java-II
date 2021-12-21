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

public class Saque extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSaque;
	private final JButton btnConfirmar = new JButton("Confirmar");
	private JTextField textFieldCodigoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saque frame = new Saque();
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
	public Saque() {
		setTitle("Saque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoCliente = new JLabel("C\u00F3d. Cliente:");
		lblCodigoCliente.setBounds(81, 32, 110, 35);
		lblCodigoCliente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoCliente.setBackground(Color.BLACK);
		contentPane.add(lblCodigoCliente);
		
		textFieldSaque = new JTextField();
		textFieldSaque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSaque.setBounds(210, 80, 197, 20);
		contentPane.add(textFieldSaque);
		textFieldSaque.setColumns(10);
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
		
		JLabel lblValorDoSaque = new JLabel("Valor do saque:");
		lblValorDoSaque.setFont(new Font("Verdana", Font.BOLD, 14));
		lblValorDoSaque.setBackground(Color.BLACK);
		lblValorDoSaque.setBounds(59, 73, 154, 35);
		contentPane.add(lblValorDoSaque);
		
		textFieldCodigoCliente = new JTextField();
		textFieldCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCodigoCliente.setColumns(10);
		textFieldCodigoCliente.setBounds(210, 39, 197, 20);
		contentPane.add(textFieldCodigoCliente);
	}
}