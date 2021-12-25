package view.relatorio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RelatorioIndividual extends JFrame {

	
	private static final long serialVersionUID = 1L;	
	public JFrame frame;
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
		initialize();
	}
	
	public void initialize() {
		
		frame = new JFrame();		
		frame.setTitle("Relat\u00F3rio Individual de Cliente");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("C\u00F3d. Cliente:");
		lblNome.setBounds(81, 32, 110, 35);
		lblNome.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNome.setBackground(Color.BLACK);
		contentPane.add(lblNome);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
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
