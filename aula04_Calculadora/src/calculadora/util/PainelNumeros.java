package calculadora.util;

import java.awt.Color;
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

		JButton botao7 = new JButton("7");
		botao7.addActionListener(this);
		add(botao7);

		JButton botao8 = new JButton("8");
		botao8.addActionListener(this);
		add(botao8);
		
		JButton botao9 = new JButton("9");
		botao8.addActionListener(this);
		add(botao9);

		JButton botao4 = new JButton("4");
		botao4.addActionListener(this);
		add(botao4);

		JButton botao5 = new JButton("5");
		botao5.addActionListener(this);
		add(botao5);

		JButton botao6 = new JButton("6");
		botao6.addActionListener(this);
		add(botao6);

		JButton botao1 = new JButton("1");
		botao1.addActionListener(this);
		add(botao1);
		
		JButton botao2 = new JButton("2");
		botao2.addActionListener(this);
		add(botao2);

		JButton botao3 = new JButton("3");
		botao3.addActionListener(this);
		add(botao3);
		
		JButton botao0 = new JButton("0");
		botao0.addActionListener(this);
		add(botao0);
		
		JButton botaoCE = new JButton("CE");
		botaoCE.addActionListener(this);
		botaoCE.setForeground(Color.red);
		add(botaoCE);

		JButton botaoEqual = new JButton("=");
		botaoEqual.addActionListener(this);
		add(botaoEqual);


		


	}


	@Override
	public void actionPerformed(ActionEvent e) {


	}



}
