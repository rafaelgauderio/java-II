package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class SobreAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.setDefaultLocale(null);
		JOptionPane.showMessageDialog(null, "Desenvolvido por Rafael De Luca\nIFRS - Canoas\nAnalise"
				+ " e Desenvolvimento de Sistemas\n2021");
		
		
	}

}
