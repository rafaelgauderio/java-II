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
import view.cadastro.Atualizar;
import view.cadastro.Deletar;
import view.cadastro.Novo;
import view.operacoes.Deposito;
import view.operacoes.Saque;
import view.operacoes.Transferencia;
import view.relatorio.RelatorioGeralTable;
import view.relatorio.RelatorioGeralTextArea;
import view.relatorio.RelatorioIndividual;
import java.awt.Font;

public class Aplicacao {

	public JFrame frame;

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
		frame.setBounds(450, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menu = new JMenuBar();

		JMenu arquivo = new JMenu("Arquivo");
		arquivo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		arquivo.setMnemonic('A');

		JMenuItem itemSair = new JMenuItem(new SairAction());
		itemSair.setText("Sair");
		itemSair.setMnemonic('S');

		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		cadastro.setMnemonic('C');

		JMenu cliente = new JMenu();
		cliente.setText("Cliente");
		cadastro.add(cliente);

		JMenuItem novo = new JMenuItem();
		novo.setText("Novo");
		novo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

							
				Novo window = new Novo();
				window.frame.setVisible(true);

			}

		});

		JMenuItem atualizar = new JMenuItem();
		atualizar.setText("Atualizar");
		atualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Atualizar window = new Atualizar();
				window.frame.setVisible(true);	
					
				
			}
		});

		JMenuItem deletar = new JMenuItem();
		deletar.setText("Deletar");
		deletar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Deletar window = new Deletar();
				window.frame.setVisible(true);
			}
		});

		cliente.add(novo);
		cliente.add(atualizar);
		cliente.add(deletar);

		JMenu operacoes = new JMenu("Operações");
		operacoes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		operacoes.setMnemonic('O');

		JMenuItem deposito = new JMenuItem("Depósito");
		deposito.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Deposito window = new Deposito();
				window.frame.setVisible(true);
			}
		});
		
		
		
		JMenuItem saque = new JMenuItem("Saque");
		saque.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Saque window = new Saque();
				window.frame.setVisible(true);				
			}		
			
		});
		
		
		JMenuItem transferencia = new JMenuItem("Transferência");
		transferencia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Transferencia window = new Transferencia();
				window.frame.setVisible(true);				
			}
			
		});
		

		operacoes.add(deposito);
		operacoes.add(saque);
		operacoes.add(transferencia);

		JMenu relatorio = new JMenu("Relatório");
		relatorio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		relatorio.setMnemonic('R');

		JMenuItem relatorioIndividual = new JMenuItem("Um cliente");
		relatorioIndividual.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RelatorioIndividual window = new RelatorioIndividual();
				window.frame.setVisible(true);
				
			}
			
		});
		
		
		JMenuItem relatorioTodosClientes = new JMenuItem("Todos os clientes (Area de texto)");
		relatorioTodosClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RelatorioGeralTextArea window = new RelatorioGeralTextArea();
				window.frame.setVisible(true);
			}		
			
		});
		
		JMenuItem relatorioTodosClientesTable = new JMenuItem("Todos os clientes (Tabela)");
		relatorioTodosClientesTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RelatorioGeralTable window = new RelatorioGeralTable();
				window.frame.setVisible(true);
			}		
			
		});
		
		

		relatorio.add(relatorioIndividual);
		relatorio.add(relatorioTodosClientes);
		relatorio.add(relatorioTodosClientesTable);

		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setFont(new Font("Segoe UI", Font.BOLD, 15));

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
