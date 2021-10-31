package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario {
	
	
	public static void main(String [] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Janela de formulário");
		frame.setSize(400,200);
		frame.setLocation(400,250);
		//aplicacao termina quando fechar a janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		JPanel painel = new JPanel();
		
		JLabel label = new JLabel("Informe seu Login:");
		painel.add(label);
		
		JTextField campo = new JTextField(15);
		painel.add(campo);
		
		JButton botao = new JButton("OK");
		BotaoAction acao = new BotaoAction(campo);
		botao.addActionListener(acao);
		painel.add(botao);
		
		
		
		
		frame.add(painel);
		//deixar a janela visivel
		frame.setVisible(true);
		
		
	}
	

}
