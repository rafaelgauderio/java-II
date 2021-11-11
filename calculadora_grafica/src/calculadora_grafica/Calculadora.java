package calculadora_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.List;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum1;
	private JTextField tfResult;
	private JTextField tfNum2;
	private JLabel lblResultado;
	
	MetodosCalculo mc = new MetodosCalculo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		lblNewLabel.setBounds(34, 27, 93, 23);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(118, 29, 171, 20);
		tfNum1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(tfNum1);
		tfNum1.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 2");
		lblNmero.setBounds(34, 78, 93, 23);
		lblNmero.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(lblNmero);
		
		tfResult = new JTextField();
		tfResult.setEditable(false); //para usuário nao setar o campo resultado
		tfResult.setBounds(118, 174, 171, 20);
		tfResult.setText("Valor");
		tfResult.setHorizontalAlignment(SwingConstants.CENTER);
		tfResult.setForeground(Color.BLACK);
		tfResult.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		tfResult.setColumns(10);
		contentPane.add(tfResult);
		
		
	
		
		tfNum2 = new JTextField();
		tfNum2.setBounds(118, 79, 171, 20);
		tfNum2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		tfNum2.setColumns(10);
		contentPane.add(tfNum2);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(34, 174, 93, 23);
		lblResultado.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(lblResultado);
		
		JButton btnSub = new JButton("sub");
		btnSub.setBounds(134, 125, 79, 23);		
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mc.setNum1(Double.parseDouble(tfNum1.getText()));
				mc.setNum2(Double.parseDouble(tfNum2.getText()));				
				tfResult.setText(String.valueOf(mc.sub()));			
				
				
			}
		});		
		btnSub.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contentPane.add(btnSub);
		
		JButton btnSomar = new JButton("soma");
		btnSomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mc.setNum1(Double.parseDouble(tfNum1.getText()));
				mc.setNum2(Double.parseDouble(tfNum2.getText()));				
				tfResult.setText(String.valueOf(mc.soma()));			
				
				
				
			}
		});
		btnSomar.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnSomar.setBounds(34, 125, 87, 23);
		contentPane.add(btnSomar);
		
		JButton btnDiv = new JButton("div");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mc.setNum1(Double.parseDouble(tfNum1.getText()));
				mc.setNum2(Double.parseDouble(tfNum2.getText()));				
				tfResult.setText(String.valueOf(mc.div()));
				
				
				
			}
		});
		btnDiv.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnDiv.setBounds(312, 125, 79, 23);
		contentPane.add(btnDiv);
		
		JButton btnMul = new JButton("mul");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mc.setNum1(Double.parseDouble(tfNum1.getText()));
				mc.setNum2(Double.parseDouble(tfNum2.getText()));				
				tfResult.setText(String.valueOf(mc.mult()));
				
				
			}
		});
		btnMul.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnMul.setBounds(223, 125, 79, 23);
		contentPane.add(btnMul);
	}
}
