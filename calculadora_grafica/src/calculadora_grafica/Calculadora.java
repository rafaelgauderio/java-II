package calculadora_grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField tfNum1;
	private JTextField tfResult;
	private JTextField tfNum2;
	private JLabel lblOperacao;
	
	JRadioButton rbSoma = new JRadioButton("Soma");
	JRadioButton rbSub = new JRadioButton("Subtra\u00E7\u00E3o");
	JRadioButton rbMult = new JRadioButton("Multiplica\u00E7\u00E3o");
	JRadioButton rbDiv = new JRadioButton("Divis\u00E3o");
	
	private final ButtonGroup buttonGroup = new ButtonGroup();	

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
		setBounds(450,200, 417, 494);
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
		tfResult.setBounds(155, 374, 104, 34);
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

		lblOperacao = new JLabel("Operacao");
		lblOperacao.setBounds(34, 170, 93, 23);
		lblOperacao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(lblOperacao);

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
				
				if(mc.getNum2()==0) {
					tfResult.setText("NaD");
				}
				else {
					tfResult.setText(String.valueOf(mc.div()).format("%.3f", mc.div()));		}
												



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

		JLabel label = new JLabel("Resultado");
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label.setBounds(34, 381, 93, 23);
		contentPane.add(label);

		JComboBox cbOperacao = new JComboBox();
		cbOperacao.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

				mc.setNum1(Double.parseDouble(tfNum1.getText()));
				mc.setNum2(Double.parseDouble(tfNum2.getText()));	

				if(cbOperacao.getSelectedItem().equals("Soma")) {
					tfResult.setText(String.format("%.2f",mc.soma()));

				}
				else if(cbOperacao.getSelectedItem().equals("Subtração")) {
					tfResult.setText(String.format("%.2f",mc.sub()));


				}

				else if(cbOperacao.getSelectedItem().equals("Multiplicação")) {
					tfResult.setText(String.format("%.2f",mc.mult()));


				}

				else if(cbOperacao.getSelectedItem().equals("Divisão")) {
					
					if(mc.getNum2()==0) {
						tfResult.setText("NaD");
					}
					else {
						tfResult.setText(String.valueOf(mc.div()).format("%.3f", mc.div()));						
					}
					

				} 

				else {

					JOptionPane.showMessageDialog(null,"Selecione uma operação");
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		cbOperacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione...", "Soma", "Subtra\u00E7\u00E3o", "Multiplica\u00E7\u00E3o", "Divis\u00E3o"}));
		cbOperacao.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		cbOperacao.setBounds(137, 170, 208, 22);
		contentPane.add(cbOperacao);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mc.setNum1(Double.parseDouble(tfNum1.getText()));
				mc.setNum2(Double.parseDouble(tfNum2.getText()));
				
				if( rbSoma.isSelected()) {
					
					tfResult.setText(String.valueOf(mc.soma()));					
				} else if (rbSub.isSelected()) {
					tfResult.setText(String.valueOf(mc.sub()));
				} else if (rbMult.isSelected()) {
					tfResult.setText(String.valueOf(mc.mult()));
				} else if (rbDiv.isSelected()) {					
					if(mc.getNum2()==0) {
						tfResult.setText("NaD");
					}
					else {
						tfResult.setText(String.valueOf(mc.div()).format("%.3f", mc.div()));					
					}					
					
				}
				

				/*
				if(cbOperacao.getSelectedIndex()==1) {
					tfResult.setText(String.valueOf(mc.soma()));

				}
				else if(cbOperacao.getSelectedIndex()==2) {
					tfResult.setText(String.valueOf(mc.sub()));

				}

				else if(cbOperacao.getSelectedIndex()==3) {
					tfResult.setText(String.valueOf(mc.mult()));

				}

				else if(cbOperacao.getSelectedIndex()==4) {
					tfResult.setText(String.valueOf(mc.div()));

				} 
				 

				if(cbOperacao.getSelectedItem().equals("Soma")) {
					tfResult.setText(String.valueOf(mc.soma()));

				}
				else if(cbOperacao.getSelectedItem().equals("Subtração")) {
					tfResult.setText(String.valueOf(mc.sub()));

				}

				else if(cbOperacao.getSelectedItem().equals("Multiplicação")) {
					tfResult.setText(String.valueOf(mc.mult()));

				}

				else if(cbOperacao.getSelectedItem().equals("Divisão")) {
					tfResult.setText(String.valueOf(mc.div()));

				} 

				else {

					JOptionPane.showMessageDialog(null,"Selecione uma operação");
				}
				*/

			}
		});
		btnCalcular.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnCalcular.setBounds(155, 340, 117, 23);
		contentPane.add(btnCalcular);
		
		
		rbSoma.setSelected(true);
		buttonGroup.add(rbSoma);
		rbSoma.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		rbSoma.setBounds(34, 217, 93, 23);
		contentPane.add(rbSoma);
		
		
		buttonGroup.add(rbSub);
		rbSub.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		rbSub.setBounds(34, 243, 104, 23);
		contentPane.add(rbSub);
		
		
		buttonGroup.add(rbMult);
		rbMult.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		rbMult.setBounds(34, 269, 117, 23);
		contentPane.add(rbMult);		
		
		buttonGroup.add(rbDiv);
		rbDiv.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		rbDiv.setBounds(34, 295, 93, 23);
		contentPane.add(rbDiv);
	}
}
