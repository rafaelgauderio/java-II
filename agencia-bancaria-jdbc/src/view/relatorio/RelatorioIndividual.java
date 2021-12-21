package view.relatorio;

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
import javax.swing.JTextArea;

public class RelatorioIndividual extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCodigoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioIndividual frame = new RelatorioIndividual();
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
	public RelatorioIndividual() {
		setTitle("Relat\u00F3rio Individual de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("C\u00F3d. Cliente:");
		lblNome.setBounds(81, 32, 110, 35);
		lblNome.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNome.setBackground(Color.BLACK);
		contentPane.add(lblNome);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFechar.setBounds(376, 292, 179, 41);
		contentPane.add(btnFechar);
		
		textFieldCodigoCliente = new JTextField();
		textFieldCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCodigoCliente.setColumns(10);
		textFieldCodigoCliente.setBounds(210, 39, 197, 20);
		contentPane.add(textFieldCodigoCliente);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(432, 32, 123, 41);
		contentPane.add(btnBuscar);
		
		JTextArea textAreaRelIndividual = new JTextArea();
		textAreaRelIndividual.setBounds(81, 78, 474, 203);
		contentPane.add(textAreaRelIndividual);
	}
}
