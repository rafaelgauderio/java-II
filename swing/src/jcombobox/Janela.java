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
import javax.swing.JOptionPane;

public class Janela extends JFrame {


	private JComboBox comboMaterias;
	private JButton botaoTeste;
	private JLabel labelEstados;
	private Icon[] icones;
	private JLabel labelIcone;

	public Janela() {

		initWindows();
		initComponents();
		this.setVisible(true);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComponents() {


		labelEstados = new JLabel("Materia: ");
		this.add(labelEstados);		

		String [] materias = {"Selecione um item...","Química", "Física", "Biologia"};
		comboMaterias = new JComboBox(materias);
		comboMaterias.addItem("Matemática");
		comboMaterias.addActionListener(new HandLerComboestado());
		this.add(comboMaterias);


		icones = new Icon[5];
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
		this.setTitle("Teste de JComboBox");
		this.setLocationRelativeTo(null); //fazer aparecer no centro
		this.setLayout(new FlowLayout());		

	}

	private class HandLerBotaoTeste implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Matéria: " + comboMaterias.getSelectedItem() +"\nÍndice da matéria: " + comboMaterias.getSelectedIndex());

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
			int id = comboMaterias.getSelectedIndex();
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
