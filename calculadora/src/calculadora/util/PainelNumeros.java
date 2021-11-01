package calculadora.util;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelNumeros  extends JPanel implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTexto;
	
	
	public PainelNumeros(JTextField txtTexto) {
		this.txtTexto=txtTexto;
		
		
		setLayout(new GridLayout(4,3));
		
		JButton botao1 = new JButton("1");
		add(botao1);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	

}
