package view.relatorio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
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

public class RelatorioGeralTable extends JFrame {

	
	
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JPanel panelClientes;
	private JTable tableClientes;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioGeralTable window = new RelatorioGeralTable();
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
	
	public RelatorioGeralTable() {
		initialize();
	}
	
	public void  initialize() {
		frame = new JFrame();
		frame.setTitle("Relat\u00F3rio Geral de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 750, 550);
		panelClientes	= new JPanel();
		panelClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panelClientes);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(521, 411, 112, 41);
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
		
	
		panelClientes = new JPanel();
		tabbedPaneClientes.addTab("Cadastro de Clientes", null, panelClientes, null);
		panelClientes.setLayout(new GridLayout(0, 1, 0, 0));
		

		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(91, 94, 535, 250);
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
		tableClientes.getColumnModel().getColumn(1).setPreferredWidth(76);
		tableClientes.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableClientes.getColumnModel().getColumn(2).setMinWidth(120);
		tableClientes.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableClientes.getColumnModel().getColumn(3).setMaxWidth(40);
		scrollPaneClientes.setViewportView(tableClientes);
		
		ClienteDao clienteDao = DaoFactory.criarClienteDao();
		List<Cliente> listaDeClientes = new ArrayList<>();
		listaDeClientes = clienteDao.searchAllClients();
		
		/*
		for (Cliente apelido : listaDeClientes) {
			System.out.println(apelido);
		}
		*/
		
		DefaultTableModel tableModel = (DefaultTableModel) tableClientes.getModel();

		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");		
			
	
		for(int i=0; i<listaDeClientes.size(); i++) {
			
			Object[] arrayObj = {listaDeClientes.get(i).getCodCliente(), listaDeClientes.get(i).getNome(),
					listaDeClientes.get(i).getEndereco(), listaDeClientes.get(i).getSexo(), dataFormatada.format(listaDeClientes.get(i).getDataNascimento().getTime()),
					listaDeClientes.get(i).getSaldo()
					};
			/*
			tableModel.setValueAt(arrayObj[0], i, 0);
			tableModel.setValueAt(arrayObj[1], i, 1);
			tableModel.setValueAt(arrayObj[2], i, 2);
			tableModel.setValueAt(arrayObj[3], i, 3);
			tableModel.setValueAt(arrayObj[4], i, 4);
			tableModel.setValueAt(arrayObj[5], i, 5);
			*/
			
			tableModel.addRow(arrayObj);
					

		}		
		
		
	}
	
	
		
	
	
}
