package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import calculadora.Calculadora;
import util.SairAction;
import util.SobreAction;


public class Aplicacao {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacao window = new Aplicacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplicacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(450,100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic('A');		
		
		
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('j');
		
		
		
		JMenuItem itemCalculadora = new JMenuItem();
		itemCalculadora.setText("Calculadora");
		itemCalculadora.setMnemonic('C');
		itemCalculadora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Calculadora window = new Calculadora();
				window.frame.setVisible(true);				
				
			}
			
		});
		
		JMenuItem itemSair = new JMenuItem(new SairAction());
		itemSair.setText("Sair");
		itemSair.setMnemonic('S');
		
		JMenuItem itemSobre = new JMenuItem(new SobreAction());
		itemSobre.setText("Sobre");
		
		
		
		arquivo.add(itemCalculadora);
		arquivo.add(itemSair);
		ajuda.add(itemSobre);
		
		menu.add(arquivo);		
		menu.add(ajuda);
		
		
		
		
		frame.setJMenuBar(menu);
		frame.setVisible(true);
		
		
	}
}
