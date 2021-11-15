package jlist;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;



public class MultipleJList extends JFrame{

	private  JList originalList;
	private JList copyList;
	private String [] colorsName;
	private JFrame window;
	private Button button;


	MultipleJList() {

		window = this;
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(300,300);

		colorsName = new String[7];
		colorsName[0]= "Blue";
		colorsName[1]= "Red";
		colorsName[2]= "Yellow";
		colorsName[3]= "Cyan";
		colorsName[4]= "Orange";
		colorsName[5]= "Black";
		colorsName[6]="White";

		originalList = new JList(colorsName);
		originalList.setVisibleRowCount(7);
		originalList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.add(originalList);

		button = new Button("Copy");
		this.add(button);
		button.addActionListener(new ButtonHandler());

		copyList = new JList();
		copyList.setVisibleRowCount(7);

		this.add(copyList);

		this.setVisible(true);


	}



	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			copyList.setListData(originalList.getSelectedValues());


		}


	}


}
