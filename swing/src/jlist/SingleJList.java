package jlist;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;

public class SingleJList extends JFrame{

	private JFrame window;
	private String [] colorsName;
	private Color[] colors;
	private JList list;

	SingleJList() {
		
		window = this;
		getContentPane().setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350,350);
		this.setLocationRelativeTo(null);
		
		colorsName = new String [5];
		colorsName[0]= "Blue";
		colorsName[1]= "Red";
		colorsName[2]= "Yellow";
		colorsName[3]= "Cyan";
		colorsName[4]= "Orange";
		
		
		colors = new Color[5];
		colors[0]= Color.BLUE;
		colors[1]= Color.RED;
		colors[2]= Color.YELLOW;
		colors[3]= Color.CYAN;
		colors[4]= Color.ORANGE;
		
		list = new JList(colorsName);
		list.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		list.setVisibleRowCount(6);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);
		
		list.addListSelectionListener(new ListHandler());
		
		this.setVisible(true);




	}






	private class ListHandler implements ListSelectionListener {


		public void valueChanged(ListSelectionEvent e) {

			window.getContentPane().setBackground(colors[list.getSelectedIndex()]);

		}

	}


}




