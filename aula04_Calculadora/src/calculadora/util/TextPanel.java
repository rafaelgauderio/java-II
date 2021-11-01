package calculadora.util;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel{	
	
	

	private static final long serialVersionUID = 1L;
	private JTextField textNumber;
	
	public TextPanel() {
		setLayout(new FlowLayout());	
		
		
		textNumber = new JTextField(35);
		textNumber.setHorizontalAlignment(JTextField.RIGHT);
		textNumber.setEnabled(false); // para o usu�rio n�o digitar na caixa de texto
		add(textNumber);
		
	}

	public JTextField getTextNumber() {
		return textNumber;
	}
	
	/* setar os valores atrav�s do teclado
	public void setTextNumber(JTextField textNumber) {
		this.textNumber = textNumber;
	}
	*/
	
	
	

}
