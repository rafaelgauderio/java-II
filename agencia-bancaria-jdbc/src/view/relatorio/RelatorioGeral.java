package view.relatorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;

public class RelatorioGeral extends JFrame {

	private JPanel panelClientes;
	private JTable tableClientes;
	private JTextArea textAreaClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioGeral frame = new RelatorioGeral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RelatorioGeral() {
		setTitle("Relat\u00F3rio Geral de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		panelClientes	= new JPanel();
		panelClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelClientes);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(521, 311, 112, 41);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelClientes.setLayout(null);
		
		JTabbedPane tabbedPaneClientes = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneClientes.setBounds(43, 36, 650, 250);
		panelClientes.add(tabbedPaneClientes);
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelClientes.add(btnFechar);
		
		textAreaClientes = new JTextArea();
		tabbedPaneClientes.addTab("Cadastro Clientes\r\n", null, textAreaClientes, null);
		
		
		panelClientes = new JPanel();
		tabbedPaneClientes.addTab("Cadastro de Clientes", null, panelClientes, null);
		panelClientes.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPaneClientes = new JScrollPane();
		panelClientes.add(scrollPaneClientes);

		tableClientes = new JTable();
		tableClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				

			}
		});
		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3d", "Nome", "Endere\u00E7o", "Sexo", "Data Nascimento", "Saldo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableClientes.getColumnModel().getColumn(0).setMaxWidth(80);
		tableClientes.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableClientes.getColumnModel().getColumn(2).setMinWidth(120);
		tableClientes.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableClientes.getColumnModel().getColumn(3).setMaxWidth(40);
		scrollPaneClientes.setViewportView(tableClientes);
		
		
		
	}
	
	
		
	
	
}
