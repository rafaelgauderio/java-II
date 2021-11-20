package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.Departamento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Principal {

	private JFrame frmTelaCadastro;
	private JTable tableDepartamentos;
	private JButton botaoNovo;
	private JButton botaoEditar;
	private JButton botaoExcluir;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JTextField tfDepCod;
	private JTextField tfDepNome;
	private JPanel panelFuncionarios;
	private JPanel panelDepCadastros;
	private JPanel panelBotoes;
	
	private boolean isEditar;

	private ArrayList<Departamento> listaDepartamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if("Metal".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					Principal window = new Principal();
					window.frmTelaCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		mostraOcultaPanelDepCadastro(); // painel do meio começa não visivel até clicar no botao novo

		listaDepartamentos = new ArrayList<Departamento>();
		isEditar = false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastro = new JFrame();
		frmTelaCadastro.setTitle("Tela Cadastro");
		frmTelaCadastro.setBounds(100, 100, 537, 450);
		frmTelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmTelaCadastro.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panelDepartamentos = new JPanel();
		tabbedPane.addTab("Departamentos", null, panelDepartamentos, null);
		GridBagLayout gbl_panelDepartamentos = new GridBagLayout();
		gbl_panelDepartamentos.columnWidths = new int[]{0, 0};
		gbl_panelDepartamentos.rowHeights = new int[] {0, 0, 100, 0};
		gbl_panelDepartamentos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelDepartamentos.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelDepartamentos.setLayout(gbl_panelDepartamentos);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelDepartamentos.add(scrollPane, gbc_scrollPane);

		tableDepartamentos = new JTable();
		tableDepartamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				selectionaLinhaTabelaDepartamentos();

			}
		});
		tableDepartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDepartamentos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3d. Dep.", "Nome"
				}
				));
		tableDepartamentos.getColumnModel().getColumn(0).setMaxWidth(75);
		scrollPane.setViewportView(tableDepartamentos);

		panelBotoes = new JPanel();
		GridBagConstraints gbc_panelBotoes = new GridBagConstraints();
		gbc_panelBotoes.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotoes.fill = GridBagConstraints.BOTH;
		gbc_panelBotoes.gridx = 0;
		gbc_panelBotoes.gridy = 1;
		panelDepartamentos.add(panelBotoes, gbc_panelBotoes);

		botaoNovo = new JButton("Novo");
		botaoNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mostraOcultaPanelDepCadastro();
			}
		});
		panelBotoes.add(botaoNovo);

		botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isEditar = true; //só puxa os dados de edição se flag estiver true, se vier pelo botao novo, fica em branco
				mostraOcultaPanelDepCadastro();
			}
		});

		panelBotoes.add(botaoEditar);

		botaoExcluir = new JButton("excluir");
		botaoExcluir.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableDepartamentos.getSelectedRow()> -1) {
					 ((DefaultTableModel) tableDepartamentos.getModel()).removeRow(tableDepartamentos.getSelectedRow());
					botaoEditar.setEnabled(false);
					botaoExcluir.setEnabled(false);
				}
				
			}
		});
		panelBotoes.add(botaoExcluir);

		panelDepCadastros = new JPanel();
		panelDepCadastros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados Departamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDepCadastros.setLayout(null);
		GridBagConstraints gbc_panelDepCadastros = new GridBagConstraints();
		gbc_panelDepCadastros.fill = GridBagConstraints.BOTH;
		gbc_panelDepCadastros.gridx = 0;
		gbc_panelDepCadastros.gridy = 2;
		panelDepartamentos.add(panelDepCadastros, gbc_panelDepCadastros);

		JLabel lblNewLabel = new JLabel("C\u00F3d. Dep:");
		lblNewLabel.setBounds(25, 23, 67, 14);
		panelDepCadastros.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(25, 55, 49, 14);
		panelDepCadastros.add(lblNewLabel_1);

		tfDepCod = new JTextField();
		tfDepCod.setBounds(122, 20, 96, 20);
		panelDepCadastros.add(tfDepCod);
		tfDepCod.setColumns(10);

		tfDepNome = new JTextField();
		tfDepNome.setBounds(122, 52, 222, 20);
		panelDepCadastros.add(tfDepNome);
		tfDepNome.setColumns(10);

		botaoSalvar = new JButton("Salvar");
		botaoSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alimentaListaDepartamento();
				alimentaTabelaDepartamento();				
				mostraOcultaPanelDepCadastro();
				isEditar=false;

			}
		});
		botaoSalvar.setBounds(122, 83, 107, 35);
		panelDepCadastros.add(botaoSalvar);

		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostraOcultaPanelDepCadastro();
				isEditar=false;

			}
		});		
		botaoCancelar.setBounds(239, 83, 105, 35);
		panelDepCadastros.add(botaoCancelar);

		panelFuncionarios = new JPanel();
		tabbedPane.addTab("Funcionarios", null, panelFuncionarios, null);
	}

	private void mostraOcultaPanelDepCadastro() {

		panelDepCadastros.setVisible(!panelDepCadastros.isVisible()); //deixar visible se estiver invisível		
		botaoNovo.setEnabled(!panelDepCadastros.isVisible()); // habilitar se estiver inabilitado

		botaoEditar.setEnabled(false); // só habilitar na hora que selecionar uma linha
		botaoExcluir.setEnabled(false);// só habilitar na hora que selecionar uma linha
		
		//só habilitar para editar se uma linha estiver selecionada, e puxa os dados da linha que delecionou.
		if(!isEditar==true) {
			tfDepCod.setText("");
			tfDepNome.setText("");
			botaoSalvar.setText("SALVAR"); //se não vem do editar os campos estavao em branco e label - salvar 
		} else {
			//encontar a linha, puxar ela do arraylista e setar os novos codigos e nome
			int linha = tableDepartamentos.getSelectedRow();
			Departamento dep = listaDepartamentos.get(linha);
			tfDepCod.setText(dep.getCodigo()+"");
			tfDepNome.setText(dep.getNome());
			botaoSalvar.setText("ATUALIZAR"); //se puxao os dados e está dando um update
		}	
		
		
	}

	private void alimentaListaDepartamento() {

	
		if(isEditar==true) {
			updateDepartamento();
		} else {
			salvaDepartamento();
		}
		
	}
	
	private void salvaDepartamento() {
		int codigo = Integer.parseInt(tfDepCod.getText());
		String nome = tfDepNome.getText();
		Departamento dep = new Departamento(codigo, nome);
		listaDepartamentos.add(dep);
		
	}
	
	private void updateDepartamento() {
		int codigo = Integer.parseInt(tfDepCod.getText());
		String nome = tfDepNome.getText();
		Departamento dep = new Departamento(codigo, nome);
		int linha = tableDepartamentos.getSelectedRow(); //seleciona a linha altera os valor e adiciona novamente na lista
		listaDepartamentos.set(linha, dep);
		
		
	}

	private void alimentaTabelaDepartamento() {

		if(listaDepartamentos.isEmpty()) {
			return;	
		}
		
		else {
			int linha = listaDepartamentos.size() - 1 ; // pegar o ultimo elemento da lista
			if (isEditar==true) {
				linha = tableDepartamentos.getSelectedRow();
			}

			DefaultTableModel tableModel = (DefaultTableModel)tableDepartamentos.getModel();

			Object[] arrayObj = {listaDepartamentos.get(linha).getCodigo(), 
					listaDepartamentos.get(linha).getNome()}; //array de Objetos
			if (isEditar==true) {
				tableModel.setValueAt(arrayObj[0], linha, 0); // codigo departamento;
				tableModel.setValueAt(arrayObj[1],linha, 1); // nome departamento;
				
			} else {
				tableModel.addRow(arrayObj);		

			}

			
		}

	}
	
	private void selectionaLinhaTabelaDepartamentos() {
		
		//habilitar os botoes editar e excluri apens se houver uma linha selecionada
		if(tableDepartamentos.getSelectedRow() > -1) { 
			botaoEditar.setEnabled(true);
			botaoExcluir.setEnabled(true);
					
		} else {
			botaoEditar.setEnabled(false);
			botaoExcluir.setEnabled(false);
			
		}

	}

}


