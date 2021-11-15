package jcombobox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Janela extends JFrame {



	private static final long serialVersionUID = 1L;

	//private JComboBox<String> comboMaterias;
	@SuppressWarnings("rawtypes")
	private JList listMaterias;
	private JButton botaoTeste;
	private JLabel labelMaterias;
	private Icon[] icones;
	private JLabel labelIcone;
	

	public Janela() {

		initWindows();
		initComponents();
		this.setVisible(true);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComponents() {


		labelMaterias = new JLabel("Materia: ");
		this.add(labelMaterias);		

		String [] materias = {"Selecione um item...","Química", "Física", "Biologia","História","Geografia"};
		/*
		comboMaterias = new JComboBox(materias);
		comboMaterias.addItem("Matemática");
		comboMaterias.addActionListener(new HandLerComboestado());
		this.add(comboMaterias);
		 */
		
		listMaterias = new JList(materias);		
		this.add(listMaterias);
		listMaterias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//selecionar apenas 1
		//listMaterias.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//selecionar range
		listMaterias.addListSelectionListener(new HandlerListMaterias());


		icones = new Icon[6];
		icones[0]= new ImageIcon("");


		icones[1] = createImageIcon("c:\\imagem\\quimica.png","Química");
		icones[2] = createImageIcon("c:\\imagem\\fisica.jpg","Física");
		icones[3] = createImageIcon("c:\\imagem\\biologia.png","Biologia");
		icones[4] = createImageIcon("c:\\imagem\\matematica.jpg","Matemática");

		/*		
		icones[1]= new ImageIcon(this.getClass().getClassLoader().getResource("quimica.png"));		
		icones[2]= new ImageIcon(this.getClass().getResource("c:\\imagem\\fisica.jpg"));
		icones[3]= new ImageIcon(this.getClass().getResource("c:\\imagem\\biologia.png"));
		icones[4]= new ImageIcon(this.getClass().getResource("c:\\imagem\\matematica.jpj"));
		 */


		labelIcone = new JLabel();
		this.add(labelIcone);

		botaoTeste = new JButton("Imprimir");
		botaoTeste.addActionListener(new HandLerBotaoTeste());
		this.add(botaoTeste);		

	}

	public void initWindows() {
		this.setBounds(100, 100, 450, 200);
		//this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Teste de JList");
		this.setLocationRelativeTo(null); //fazer aparecer no centro
		this.setLayout(new FlowLayout());		

	}
	
	private class HandlerListMaterias implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int id = listMaterias.getSelectedIndex();
			labelIcone.setIcon(icones[id]);
			
		}
		
		
		
	}
	
	
	

	private class HandLerBotaoTeste implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] objetos = listMaterias.getSelectedValues();
			for(Object apelido: objetos) {
				System.out.println(apelido);
			}
			
			/*
			JOptionPane.showMessageDialog(null,"Índice da Matéria: " + listMaterias.getSelectedIndex() + "\nMatéria: "
			+ listMaterias.getSelectedValue());
			*/

		}

	}

	/*
	private class HandLerComboestado implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			System.out.println(e.getItem());
		}

	}
	 */	

	private class HandLerComboestado implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(comboMaterias.getSelectedItem());
			int id = listMaterias.getSelectedIndex();
			labelIcone.setIcon(icones[id]);

		}

	}

	protected ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = this.getClass().getClassLoader().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
