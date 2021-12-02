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
import model.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

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
	private JPanel panelDepCadastros;
	private JPanel panelBotoes;
	private boolean isEditar;
	private ArrayList<Departamento> listaDepartamentos;

	private boolean isEditarFunc;
	private JTable tableFuncionarios;
	private JButton botaoNovoFunc;
	private JButton botaoEditarFunc;
	private JButton botaoExcluirFunc;
	private JButton botaoSalvarFunc;
	private JButton botaoCancelarFunc;
	private JTextField tfFuncMat;
	private JTextField tfFuncNome;
	private JPanel panelFuncionarios;
	private JPanel panelFuncCadastros;
	private JPanel panelBotoesFunc;
	private ArrayList<Funcionario> listaFuncionarios;
	private JComboBox<Object> cbFuncDep;
	private JLabel labelNome;
	private JFormattedTextField ftfDataNascimento;
	private JFormattedTextField ftfCPF;
	private JFormattedTextField ftfCelular;
	private String cpfSemMascara;
	private String celularSemMascara;
	

	/**
	 * * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Metal".equals(info.getName())) {
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
		mostraOcultaPanelFuncCadastro();

		listaDepartamentos = new ArrayList<Departamento>();
		listaFuncionarios = new ArrayList<Funcionario>();

		isEditar = false;
		isEditarFunc = false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastro = new JFrame();
		frmTelaCadastro.setTitle("Tela Cadastro");
		frmTelaCadastro.setBounds(100, 100, 537, 452);
		frmTelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmTelaCadastro.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panelDepartamentos = new JPanel();
		tabbedPane.addTab("Departamentos", null, panelDepartamentos, null);
		GridBagLayout gbl_panelDepartamentos = new GridBagLayout();
		gbl_panelDepartamentos.columnWidths = new int[] { 0, 0 };
		gbl_panelDepartamentos.rowHeights = new int[] { 0, 0, 100, 0 };
		gbl_panelDepartamentos.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelDepartamentos.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panelDepartamentos.setLayout(gbl_panelDepartamentos);

		JScrollPane scrollPaneDep = new JScrollPane();
		GridBagConstraints gbc_scrollPaneDep = new GridBagConstraints();
		gbc_scrollPaneDep.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneDep.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneDep.gridx = 0;
		gbc_scrollPaneDep.gridy = 0;
		panelDepartamentos.add(scrollPaneDep, gbc_scrollPaneDep);

		tableDepartamentos = new JTable();
		tableDepartamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				selectionaLinhaTabelaDepartamentos();

			}
		});
		tableDepartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDepartamentos
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3d. Dep.", "Nome" }));
		tableDepartamentos.getColumnModel().getColumn(0).setMaxWidth(75);
		scrollPaneDep.setViewportView(tableDepartamentos);

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
				isEditar = true; // só puxa os dados de edição se flag estiver true, se vier pelo botao novo,
									// fica em branco
				mostraOcultaPanelDepCadastro();
			}
		});

		panelBotoes.add(botaoEditar);

		botaoExcluir = new JButton("excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableDepartamentos.getSelectedRow() > -1) {
					((DefaultTableModel) tableDepartamentos.getModel()).removeRow(tableDepartamentos.getSelectedRow());
					botaoEditar.setEnabled(false);
					botaoExcluir.setEnabled(false);
				}

			}
		});
		panelBotoes.add(botaoExcluir);

		panelDepCadastros = new JPanel();
		panelDepCadastros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados Departamento",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDepCadastros.setLayout(null);
		GridBagConstraints gbc_panelDepCadastros = new GridBagConstraints();
		gbc_panelDepCadastros.fill = GridBagConstraints.BOTH;
		gbc_panelDepCadastros.gridx = 0;
		gbc_panelDepCadastros.gridy = 2;
		panelDepartamentos.add(panelDepCadastros, gbc_panelDepCadastros);

		JLabel lblCodigo = new JLabel("C\u00F3d. Dep:");
		lblCodigo.setBounds(25, 23, 67, 14);
		panelDepCadastros.add(lblCodigo);

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
				isEditar = false;

			}
		});
		botaoSalvar.setBounds(122, 96, 107, 35);
		panelDepCadastros.add(botaoSalvar);

		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostraOcultaPanelDepCadastro();
				isEditar = false;

			}
		});
		botaoCancelar.setBounds(239, 96, 105, 35);
		panelDepCadastros.add(botaoCancelar);

		labelNome = new JLabel("Nome:");
		labelNome.setBounds(25, 55, 49, 14);
		panelDepCadastros.add(labelNome);

		panelFuncionarios = new JPanel();
		tabbedPane.addTab("Funcionarios", null, panelFuncionarios, null);
		GridBagLayout gbl_panelFuncionarios = new GridBagLayout();
		gbl_panelFuncionarios.columnWidths = new int[] { 100, 0 };
		gbl_panelFuncionarios.rowHeights = new int[] { 80, 0, 130 };
		gbl_panelFuncionarios.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelFuncionarios.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		panelFuncionarios.setLayout(gbl_panelFuncionarios);

		JScrollPane scrollPaneFunc = new JScrollPane();
		GridBagConstraints gbc_scrollPaneFunc = new GridBagConstraints();
		gbc_scrollPaneFunc.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneFunc.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneFunc.gridx = 0;
		gbc_scrollPaneFunc.gridy = 0;
		panelFuncionarios.add(scrollPaneFunc, gbc_scrollPaneFunc);

		tableFuncionarios = new JTable();
		tableFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				selectionaLinhaTabelaFuncionarios();

			}
		});
		tableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFuncionarios.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Matr\u00EDcula", "Nome", "CPF", "Celular", "Data de Dascimento", "Departamento" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, String.class, Object.class, String.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableFuncionarios.getColumnModel().getColumn(0).setMaxWidth(95);
		tableFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(122);
		scrollPaneFunc.setViewportView(tableFuncionarios);

		panelBotoesFunc = new JPanel();
		GridBagConstraints gbc_panelBotoesFunc = new GridBagConstraints();
		gbc_panelBotoesFunc.insets = new Insets(0, 0, 5, 0);
		gbc_panelBotoesFunc.fill = GridBagConstraints.BOTH;
		gbc_panelBotoesFunc.gridx = 0;
		gbc_panelBotoesFunc.gridy = 1;
		panelFuncionarios.add(panelBotoesFunc, gbc_panelBotoesFunc);

		botaoNovoFunc = new JButton("Novo");
		botaoNovoFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostraOcultaPanelFuncCadastro();
			}
		});
		panelBotoesFunc.add(botaoNovoFunc);

		botaoEditarFunc = new JButton("Editar");
		botaoEditarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isEditarFunc = true;
				mostraOcultaPanelFuncCadastro();
			}
		});

		panelBotoesFunc.add(botaoEditarFunc);

		botaoExcluirFunc = new JButton("excluir");
		botaoExcluirFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableFuncionarios.getSelectedRow() > -1) {
					((DefaultTableModel) tableFuncionarios.getModel()).removeRow(tableFuncionarios.getSelectedRow());
					botaoEditarFunc.setEnabled(false);
					botaoExcluirFunc.setEnabled(false);
				}

			}
		});
		panelBotoesFunc.add(botaoExcluirFunc);

		panelFuncCadastros = new JPanel();
		panelFuncCadastros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Dados Funcionários",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFuncCadastros.setLayout(null);
		GridBagConstraints gbc_panelFuncCadastros = new GridBagConstraints();
		gbc_panelFuncCadastros.fill = GridBagConstraints.BOTH;
		gbc_panelFuncCadastros.gridx = 0;
		gbc_panelFuncCadastros.gridy = 2;
		panelFuncionarios.add(panelFuncCadastros, gbc_panelFuncCadastros);

		JLabel lblNewLabel_2 = new JLabel("Matr\u00EDcula:");
		lblNewLabel_2.setBounds(25, 23, 67, 14);
		panelFuncCadastros.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(25, 55, 49, 14);
		panelFuncCadastros.add(lblNewLabel_3);

		tfFuncMat = new JTextField();
		tfFuncMat.setBounds(102, 20, 96, 20);
		panelFuncCadastros.add(tfFuncMat);
		tfFuncMat.setColumns(10);

		tfFuncNome = new JTextField();
		tfFuncNome.setBounds(102, 52, 222, 20);
		panelFuncCadastros.add(tfFuncNome);
		tfFuncNome.setColumns(10);

		botaoSalvarFunc = new JButton("Salvar");
		botaoSalvarFunc.setFont(new Font("Tahoma", Font.BOLD, 11));
		botaoSalvarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alimentaListaFuncionario();
				alimentaTabelaFuncionario();
				mostraOcultaPanelFuncCadastro();
				isEditarFunc = false;

			}
		});
		botaoSalvarFunc.setBounds(111, 202, 107, 35);
		panelFuncCadastros.add(botaoSalvarFunc);

		botaoCancelarFunc = new JButton("Cancelar");
		botaoCancelarFunc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		botaoCancelarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostraOcultaPanelFuncCadastro();
				isEditarFunc = false;

			}
		});
		botaoCancelarFunc.setBounds(228, 202, 105, 35);
		panelFuncCadastros.add(botaoCancelarFunc);

		JLabel label = new JLabel("Departamento:");
		label.setBounds(318, 131, 87, 14);
		panelFuncCadastros.add(label);

		cbFuncDep = new JComboBox();
		cbFuncDep.setBounds(315, 156, 178, 22);
		panelFuncCadastros.add(cbFuncDep);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(25, 80, 48, 20);
		panelFuncCadastros.add(lblCPF);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(25, 122, 48, 14);
		panelFuncCadastros.add(lblCelular);

		JLabel lblDatanascimento = new JLabel("Data de Nascimento:");
		lblDatanascimento.setBounds(25, 160, 107, 14);
		panelFuncCadastros.add(lblDatanascimento);

		ftfCPF = new JFormattedTextField();
		ftfCPF.setBounds(102, 83, 120, 20);
		try {
			ftfCPF.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}

		panelFuncCadastros.add(ftfCPF);

		ftfCelular = new JFormattedTextField();
		ftfCelular.setBounds(101, 119, 121, 20);
		try {
			ftfCelular.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		panelFuncCadastros.add(ftfCelular);

		ftfDataNascimento = new JFormattedTextField();
		ftfDataNascimento.setBounds(142, 157, 139, 20);
		try {
			ftfDataNascimento.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
		} catch (java.text.ParseException e1) {
			e1.printStackTrace();
		}
		panelFuncCadastros.add(ftfDataNascimento);

	}

	private void mostraOcultaPanelFuncCadastro() {

		panelFuncCadastros.setVisible(!panelFuncCadastros.isVisible());
		botaoNovoFunc.setEnabled(!panelFuncCadastros.isVisible());

		botaoEditarFunc.setEnabled(false);
		botaoExcluirFunc.setEnabled(false);

		if (!isEditarFunc == true) {
			tfFuncMat.setText("");
			tfFuncNome.setText("");
			ftfCPF.setText("");
			ftfCelular.setText("");
			ftfDataNascimento.setText("");
			botaoSalvarFunc.setText("SALVAR");
		} else {

			int linha = tableFuncionarios.getSelectedRow();
			Funcionario func = listaFuncionarios.get(linha);
			tfFuncMat.setText(func.getMatricula() + "");
			tfFuncNome.setText(func.getNome());
			ftfCelular.setText(func.getCelular());
			ftfCPF.setText(func.getCPF());
			ftfDataNascimento.setText(func.getDataNascimento().toString());
			botaoSalvarFunc.setText("ATUALIZAR");
		}

	}

	private void alimentaListaFuncionario() {

		if (isEditarFunc == true) {
			updateFuncionario();
		} else {
			try {
				salvaFuncionario();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		}

	}
	
	private void retiraMascaraCPF() {
		
		cpfSemMascara=(ftfCPF.getText().replace(".","").replace("-",""));
				
		
	}
	
	private void retiraMascaraCelular() {
		
		
		celularSemMascara=(ftfCelular.getText().replace("-","").replace(")","").replace("(",""));		
		
		
	}

	private void salvaFuncionario() throws ParseException {
		
		int indice = cbFuncDep.getSelectedIndex();
		
		retiraMascaraCelular();
		retiraMascaraCPF();
				

		if (indice==0 ) {
			JOptionPane.showMessageDialog(null, "Tu deves selecionar um departamento!".toUpperCase());
			
		}		
	
		

		else if (cpfSemMascara.length() != 11 ||cpfSemMascara.isEmpty() || cpfSemMascara.isBlank()) {
			
			JOptionPane.showMessageDialog(null, "CPF deve conter 11 digitos");
			
		}
		
		else if (celularSemMascara.length()!= 11 || celularSemMascara.isEmpty() || celularSemMascara.isBlank()) {
			
			JOptionPane.showMessageDialog(null, "O número de celular deve conter 11 digitos");
			
		}
		
		else if(ftfDataNascimento.getText().isEmpty() || ftfDataNascimento.getText().isBlank()) {
			
			JOptionPane.showMessageDialog(null, "Preencha o campo data de nascimento");
		}


		else { //(indice!=0 && cpfSemMascara.length()==11 && celularSemMascara.length()==11)
			
			int matricula = Integer.parseInt(tfFuncMat.getText());
			String nome = tfFuncNome.getText();
			String cpf = ftfCPF.getText();
			String celular = ftfCelular.getText();

			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
			String dataNascimento = ftfDataNascimento.getText();
			Calendar dataNascimentoCalendar = Calendar.getInstance();
			try {
				dataNascimentoCalendar.setTime(dataFormatada.parse(dataNascimento));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			Funcionario func = new Funcionario(matricula, nome, null, cpf, celular, dataNascimentoCalendar);
			func.setDepartamento(listaDepartamentos.get(indice - 1));
			listaDepartamentos.get(indice - 1).adicionaFuncionario(func);
			listaFuncionarios.add(func);
			
		}
		

	}

	private void updateFuncionario() {

		int indice = cbFuncDep.getSelectedIndex();

		if (indice == 0) {
			JOptionPane.showMessageDialog(null, "Tu deves selecionar um departamento!".toUpperCase());
		} else {
			int matricula = Integer.parseInt(tfFuncMat.getText());
			String nome = tfFuncNome.getText();
			String cpf = ftfCPF.getText();
			String celular = ftfCelular.getText();
			String dataNascimento = ftfDataNascimento.getText();
			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");			
			Calendar dataNascimentoCalendar = Calendar.getInstance();
			try {
				dataNascimentoCalendar.setTime(dataFormatada.parse(dataNascimento));
			} catch (ParseException e) {

				e.printStackTrace();
			}
			Funcionario func = new Funcionario(matricula, nome, null, cpf, celular, dataNascimentoCalendar);
			func.setDepartamento(listaDepartamentos.get(indice - 1));
			int linha = tableFuncionarios.getSelectedRow();
			listaFuncionarios.set(linha, func);
		}

	}

	private void alimentaTabelaFuncionario() {

		if (listaFuncionarios.isEmpty()) {
			return;
		}

		else {
			int linha = listaFuncionarios.size() - 1;
			if (isEditarFunc == true) {
				linha = tableFuncionarios.getSelectedRow();
			}

			DefaultTableModel tableModel = (DefaultTableModel) tableFuncionarios.getModel();

			Object[] arrayObj = { listaFuncionarios.get(linha).getMatricula(), listaFuncionarios.get(linha).getNome(),
					listaFuncionarios.get(linha).getCPF(), listaFuncionarios.get(linha).getCelular(),
					listaFuncionarios.get(linha).getDataNascimento().getTime(),
					listaFuncionarios.get(linha).getDepartamento().getNome(), };
			if (isEditarFunc == true) {
				tableModel.setValueAt(arrayObj[0], linha, 0);
				tableModel.setValueAt(arrayObj[1], linha, 1);
				tableModel.setValueAt(arrayObj[2], linha, 2);
				tableModel.setValueAt(arrayObj[3], linha, 3);
				tableModel.setValueAt(arrayObj[4], linha, 4);
				tableModel.setValueAt(arrayObj[5], linha, 5);

			} else {
				tableModel.addRow(arrayObj);

			}

		}

	}

	private void selectionaLinhaTabelaFuncionarios() {

		if (tableFuncionarios.getSelectedRow() > -1) {
			botaoEditarFunc.setEnabled(true);
			botaoExcluirFunc.setEnabled(true);

		} else {
			botaoEditarFunc.setEnabled(false);
			botaoExcluirFunc.setEnabled(false);

		}

	}

	private void alimentaCbFuncDep() {

		cbFuncDep.removeAllItems();
		cbFuncDep.addItem("Selecione Departamento...");
		for (int i = 0; i < listaDepartamentos.size(); i++) {
			cbFuncDep.addItem(listaDepartamentos.get(i).getNome());
		}

	}

	private void mostraOcultaPanelDepCadastro() {

		panelDepCadastros.setVisible(!panelDepCadastros.isVisible());
		botaoNovo.setEnabled(!panelDepCadastros.isVisible());

		botaoEditar.setEnabled(false);
		botaoExcluir.setEnabled(false);

		if (!isEditar == true) {
			tfDepCod.setText("");
			tfDepNome.setText("");
			botaoSalvar.setText("SALVAR");
		} else {

			int linha = tableDepartamentos.getSelectedRow();
			Departamento dep = listaDepartamentos.get(linha);
			tfDepCod.setText(dep.getCodigo() + "");
			tfDepNome.setText(dep.getNome());
			botaoSalvar.setText("ATUALIZAR");
		}

	}

	private void alimentaListaDepartamento() {

		if (isEditar == true) {
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
		int linha = tableDepartamentos.getSelectedRow(); // seleciona a linha altera os valor e adiciona novamente na
															// lista
		listaDepartamentos.set(linha, dep);

	}

	private void alimentaTabelaDepartamento() {

		if (listaDepartamentos.isEmpty()) {
			return;
		}

		else {
			int linha = listaDepartamentos.size() - 1; // pegar o ultimo elemento da lista
			if (isEditar == true) {
				linha = tableDepartamentos.getSelectedRow();
			}

			DefaultTableModel tableModel = (DefaultTableModel) tableDepartamentos.getModel();

			Object[] arrayObj = { listaDepartamentos.get(linha).getCodigo(), listaDepartamentos.get(linha).getNome() }; // array
																														// de
																														// Objetos
			if (isEditar == true) {
				tableModel.setValueAt(arrayObj[0], linha, 0); // codigo departamento;
				tableModel.setValueAt(arrayObj[1], linha, 1); // nome departamento;

			} else {
				tableModel.addRow(arrayObj);

			}

		}
		alimentaCbFuncDep();

	}

	private void selectionaLinhaTabelaDepartamentos() {

		// habilitar os botoes editar e excluri apens se houver uma linha selecionada
		if (tableDepartamentos.getSelectedRow() > -1) {
			botaoEditar.setEnabled(true);
			botaoExcluir.setEnabled(true);

		} else {
			botaoEditar.setEnabled(false);
			botaoExcluir.setEnabled(false);

		}

	}

}