import java.awt.EventQueue;

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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Principal {

	private JFrame frame;
	private JTable tableDepartamentos;
	private JButton botaoNovo;
	private JButton botaoEditar;
	private JButton botaoExcluir;
	private JButton botaoSalvar;
	private JButton botacoCancelar;
	private JTextField tfDepCod;
	private JTextField tfDepNome;
	private JPanel panelFuncionarios;
	private JPanel panelDepCadastros;
	private JPanel panelBotoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 537, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
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
		tableDepartamentos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
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
		panelBotoes.add(botaoNovo);
		
		botaoEditar = new JButton("Editar");
		
		panelBotoes.add(botaoEditar);
		
		botaoExcluir = new JButton("excluir");
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
		botaoSalvar.setBounds(122, 83, 89, 23);
		panelDepCadastros.add(botaoSalvar);
		
		botacoCancelar = new JButton("Cancelar");
		botacoCancelar.setBounds(255, 83, 89, 23);
		panelDepCadastros.add(botacoCancelar);
		
		panelFuncionarios = new JPanel();
		tabbedPane.addTab("Funcionarios", null, panelFuncionarios, null);
	}
	
	private void mostraOcultaPanelDepCadastro() {
		
		panelDepCadastros.setVisible(!panelDepCadastros.isVisible());
		
		botaoNovo.setEnabled(!panelDepCadastros.isVisible());
		
		botaoEditar.setEnabled(false);
		botaoExcluir.setEnabled(false);	
		
		
		
	}
	
	
}
