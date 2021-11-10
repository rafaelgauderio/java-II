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
		setBounds(100, 100, 375, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 27, 93, 23);
		contentPane.add(lblNewLabel);
		
		tfNum1 = new JTextField();
		tfNum1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		tfNum1.setBounds(118, 29, 171, 20);
		contentPane.add(tfNum1);
		tfNum1.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 2");
		lblNmero.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNmero.setBounds(34, 78, 93, 23);
		contentPane.add(lblNmero);
		
		tfResult = new JTextField();
		tfResult.setText("Valor");
		tfResult.setHorizontalAlignment(SwingConstants.CENTER);
		tfResult.setForeground(Color.BLACK);
		tfResult.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		tfResult.setColumns(10);
		tfResult.setBounds(118, 174, 171, 20);
		contentPane.add(tfResult);
		
		
		
		JButton botaoCalc = new JButton("Somar");
		botaoCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1,num2,result;
				
				num1 = Double.parseDouble(tfNum1.getText());
				num2 = Double.parseDouble(tfNum2.getText());
				result = num1+num2;
				tfResult.setText(String.valueOf(result));
				
				
				
			}
		});
		
		
		botaoCalc.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		botaoCalc.setBounds(120, 122, 103, 23);
		contentPane.add(botaoCalc);
		
	
		
		tfNum2 = new JTextField();
		tfNum2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		tfNum2.setColumns(10);
		tfNum2.setBounds(118, 79, 171, 20);
		contentPane.add(tfNum2);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblResultado.setBounds(34, 174, 93, 23);
		contentPane.add(lblResultado);
	}
}
