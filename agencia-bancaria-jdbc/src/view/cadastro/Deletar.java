package view.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Deletar extends JFrame {
	
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
					Deletar window = new Deletar();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Deletar() {
		initialize();
	}
	
	
	public void initialize() {
		
		frame = new JFrame();
		frame.setTitle("Exclus\u00E3o de Cliente");
		//setDefaultCloseOperation(JFrame.EXIT_ON;_CLOSE);
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
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});		
		
		
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(31, 88, 179, 41);
		contentPane.add(btnCancelar);
		
		textFieldCodigoCliente = new JTextField();
		textFieldCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCodigoCliente.setColumns(10);
		textFieldCodigoCliente.setBounds(210, 39, 197, 20);
		contentPane.add(textFieldCodigoCliente);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExcluir.setBounds(432, 32, 123, 41);
		contentPane.add(btnExcluir);
	}
}
