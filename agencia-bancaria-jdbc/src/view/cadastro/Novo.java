package view.cadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.dao.ClienteDao;
import model.dao.DaoFactory;

public class Novo extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldEndereco;
	private JTextField textFieldSaldo;
	private JButton btnSalvar = new JButton("Salvar");
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Novo window = new Novo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Novo() {
		initialize();
	}
	
	
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Novo Cliente\r\n");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(143, 27, 117, 35);
		lblNome.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNome.setBackground(Color.BLACK);
		contentPane.add(lblNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(33, 78, 180, 35);
		lblDataDeNascimento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDataDeNascimento.setBackground(Color.BLACK);
		contentPane.add(lblDataDeNascimento);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(210, 132, 117, 22);
		comboBox.setEditable(true);
		contentPane.add(comboBox);
		comboBox.addItem("--SELECIONE--");
		comboBox.addItem("M");
		comboBox.addItem("F");
		comboBox.setSelectedItem("--SELECIONE--");
		//System.out.println(comboBox.getSelectedItem());
		//String sexo = String.valueOf(comboBox.getSelectedItem());
		//System.out.println(sexo);
		
		
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(143, 124, 88, 35);
		lblSexo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSexo.setBackground(Color.BLACK);
		contentPane.add(lblSexo);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(125, 170, 88, 35);
		lblEndereo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEndereo.setBackground(Color.BLACK);
		contentPane.add(lblEndereo);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSaldo.setBackground(Color.BLACK);
		lblSaldo.setBounds(337, 211, 88, 35);
		contentPane.add(lblSaldo);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNome.setBounds(210, 34, 180, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(210, 87, 366, 20);
		contentPane.add(textFieldDataNascimento);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(210, 177, 366, 20);
		contentPane.add(textFieldEndereco);
		
		textFieldSaldo = new JTextField();
		textFieldSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSaldo.setColumns(10);
		textFieldSaldo.setBounds(408, 218, 168, 20);
		contentPane.add(textFieldSaldo);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldNome.getText().isEmpty() || textFieldEndereco.getText().isEmpty() || 
						String.valueOf(comboBox.getSelectedItem()).isEmpty()	||	comboBox.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Apenas o campo Saldo é de preenchimento opcional. Favor preencher todos os demais campos".toUpperCase());	
				}
				
				else {
					ClienteDao clienteDao = DaoFactory.criarClienteDao();
					
					String nome = textFieldNome.getText();
					String sexo = String.valueOf(comboBox.getSelectedItem());
					String endereco = textFieldEndereco.getText();
					
					Double saldo = 0.0;
					if(textFieldSaldo.getText().isEmpty()) {
						saldo=0.0;
						
					} else {
						saldo = Double.parseDouble(textFieldSaldo.getText());
					}									
					
					
					
					SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");				
					//SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");			
					java.sql.Date dataNascimento = null;
					try {
						dataNascimento = new java.sql.Date(formatoData.parse(textFieldDataNascimento.getText()).getTime());
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
					
					Cliente clienteNovo = new Cliente(null,nome,endereco,sexo,dataNascimento,saldo);
					clienteDao.insert(clienteNovo);
				}
				
								
				
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalvar.setBounds(125, 262, 179, 41);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(337, 262, 179, 41);
		contentPane.add(btnCancelar);
	}
}
