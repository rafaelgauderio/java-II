package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BotaoAction implements ActionListener{

	private JTextField texto;
	
	public BotaoAction(JTextField texto) {
		this.texto=texto;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nome = texto.getText();
		
		JOptionPane.showMessageDialog(null, "Login efetuado com sucesso\nFoi informado o usuário: " .concat(nome));
		
	}
	
	

}
