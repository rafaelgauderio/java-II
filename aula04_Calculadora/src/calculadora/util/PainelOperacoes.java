package calculadora.util;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelOperacoes extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTexto;	
	
	private JButton botaoDiv;
	private JButton botaoMult;
	private JButton botaoSub;
	private JButton botaoSoma;
	
	
	
	
	public PainelOperacoes(JTextField txtTexto) {
		this.txtTexto=txtTexto;
		
		
		setLayout(new GridLayout(4,1));
		
		botaoDiv = new JButton("/");
		botaoDiv.addActionListener(this);
		add(botaoDiv);
		
		botaoMult = new JButton("*");
		botaoMult.addActionListener(this);
		add(botaoMult);
		
		botaoSub = new JButton("-");
		botaoSub.addActionListener(this);
		add(botaoSub);
		
		botaoSoma = new JButton("+");
		botaoSoma.addActionListener(this);
		add(botaoSoma);
		
		
				
		
		
		
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
