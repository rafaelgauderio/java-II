package calculadora.application;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelOperacoes extends JPanel implements ActionListener{

	private JTextField txtTexto;	

	private char operacao;
	private  int valor1;
	private int valor2;	

	private JButton botaoDiv;
	private JButton botaoMult;
	private JButton botaoSub;
	private JButton botaoSoma;
	private JButton botaoCE;
	private JButton botaoEqual;

	public PainelOperacoes(JTextField txtTexto) {

		this.txtTexto = txtTexto;
	
	
	setLayout(new GridLayout(3,2));
	
	botaoSoma = new JButton("+");
	botaoSoma.addActionListener(this);
	add(botaoSoma);
	
	botaoSub = new JButton("-");
	botaoSub.addActionListener(this);
	add(botaoSub);	
	
	
	botaoMult = new JButton("*");
	botaoMult.addActionListener(this);
	add(botaoMult);
	
	botaoDiv = new JButton("/");
	botaoDiv.addActionListener(this);
	add(botaoDiv);
	
	botaoCE = new JButton("CE");
	botaoCE.addActionListener(this);
	botaoCE.setForeground(Color.red);
	add(botaoCE);
	
	botaoEqual = new JButton("=");
	botaoEqual.addActionListener(this);
	add(botaoEqual);



	}
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if (txtTexto.getText().isEmpty()) {
			return;
		}
		
		
		JButton botao =  (JButton) e.getSource();


		if (botao==botaoCE) {			
			operacao = '\u0000'; //codigo unicode para null
			txtTexto.setText("");	


		}
		else if (botao==botaoEqual) {

			valor2 = Integer.parseInt(txtTexto.getText());			
			int resultado=0;

			if (operacao == '+') {
				resultado = (valor1 + valor2);
			} else if (operacao =='-') {
				resultado = (valor1 - valor2);
			} else if (operacao =='*') {
				resultado = (valor1 * valor2);
			} else if (operacao =='/') {
				
				if (valor2==0) {
					txtTexto.setText(String.valueOf("NA"));										
					
				}
				else {					
					resultado = (valor1 / valor2);
					
				}				
				
			}

			txtTexto.setText(String.valueOf(resultado));
			operacao='\u0000';
			valor1 = resultado;
			valor2 =0;			

		}


		else {
			
			operacao = botao.getText().charAt(0);
			valor1 = Integer.parseInt(txtTexto.getText());
			txtTexto.setText("");

		}


	}


}
