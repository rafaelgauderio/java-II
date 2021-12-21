package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import util.SairAction;
import util.SobreAction;
import view.cadastro.Novo;



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
		frame.setBounds(450,100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic('A');
		
		JMenuItem itemSair = new JMenuItem(new SairAction());
		itemSair.setText("Sair");
		itemSair.setMnemonic('S');	
		
		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setMnemonic('C');
		
		JMenu cliente = new JMenu();
		cliente.setText("Cliente");
		cadastro.add(cliente);		
		
		JMenuItem novo = new JMenuItem();
		novo.setText("Novo");
		novo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Novo frame = new Novo();
				frame.setVisible(true);				
				
			}
			
		});
		
		JMenuItem atualizar = new JMenuItem();
		atualizar.setText("Atualizar");			
		JMenuItem deletar = new JMenuItem();
		deletar.setText("Deletar");
		cliente.add(novo);
		cliente.add(atualizar);
		cliente.add(deletar);	
		
		
		JMenu operacoes = new JMenu("Operações");
		operacoes.setMnemonic('O');
		
		JMenuItem deposito = new JMenuItem("Depósito");
		JMenuItem saque = new JMenuItem("Saque");
		JMenuItem transferencia = new JMenuItem("Transferência");
		
		operacoes.add(deposito);
		operacoes.add(saque);
		operacoes.add(transferencia);		
		
		
		JMenu relatorio = new JMenu("Relatório");
		relatorio.setMnemonic('R');
		
		JMenuItem relatorioUmCliente = new JMenuItem("Um cliente");
		JMenuItem relatorioTodosClientes = new JMenuItem("Todos os clientes");
		
		relatorio.add(relatorioUmCliente);
		relatorio.add(relatorioTodosClientes);		
		
		
		JMenu ajuda = new JMenu("Ajuda");				
		
		JMenuItem itemSobre = new JMenuItem(new SobreAction());
		itemSobre.setText("Sobre");		
		
		arquivo.add(itemSair);
		
		ajuda.add(itemSobre);
		
		menu.add(arquivo);
		menu.add(cadastro);				
		menu.add(operacoes);
		menu.add(relatorio);
		menu.add(ajuda);		
		
		
		frame.setJMenuBar(menu);
		frame.setVisible(true);
		
		
	}
}
