package view.relatorio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.dao.ClienteDao;
import model.dao.DaoFactory;

public class RelatorioGeral extends JFrame {

	
	
	private static final long serialVersionUID = 1L;
	public JFrame frame;
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
					RelatorioGeral window = new RelatorioGeral();
					window.frame.setVisible(true);
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
		initialize();
	}
	
	public void  initialize() {
		frame = new JFrame();
		frame.setTitle("Relat\u00F3rio Geral de Clientes");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 750, 550);
		panelClientes	= new JPanel();
		panelClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panelClientes);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(521, 311, 112, 41);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		panelClientes.setLayout(null);
		
		JTabbedPane tabbedPaneClientes = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneClientes.setBounds(43, 36, 780, 350);
		panelClientes.add(tabbedPaneClientes);
		btnFechar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelClientes.add(btnFechar);
		
		textAreaClientes = new JTextArea();
		textAreaClientes.setBounds(91,94,635,350);
		tabbedPaneClientes.addTab("Cadastro Clientes\r\n", null, textAreaClientes, null);
		
		
		panelClientes = new JPanel();
		tabbedPaneClientes.addTab("Cadastro de Clientes", null, panelClientes, null);
		panelClientes.setLayout(new GridLayout(0, 1, 0, 0));
		

		//JScrollPane scrollPaneClientes = new JScrollPane();
		//scrollPaneClientes.setBounds(91, 94, 535, 250);
		
		JScrollPane scrollPaneClientes= new JScrollPane(textAreaClientes,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneClientes.setBounds(50, 50, 535, 550);		
		panelClientes.add(scrollPaneClientes);
		
		
		
		ClienteDao clienteDao = DaoFactory.criarClienteDao();
		List<Cliente> listaDeClientes = new ArrayList<>();
		listaDeClientes = clienteDao.searchAllClients();		
		//DefaultListModel model = new DefaultListModel();
		//JList<Cliente> jListaDeCLientes = new JList();
		//jListaDeCLientes.setModel(model);
		//scrollPaneClientes.setViewportView(jListaDeCLientes);
		StringBuilder stringCliente = new StringBuilder();
		for(Cliente objeto : listaDeClientes) {
			stringCliente.append(objeto);
		}
		textAreaClientes.setText(stringCliente.toString());
		
	
		/*
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
		
		*/
		
	}
	
	
		
	
	
}
