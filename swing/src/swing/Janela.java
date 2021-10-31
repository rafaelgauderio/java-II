package swing;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Janela extends JFrame{
	
	public Janela () {
		
		setTitle("Aplicação Java");
		setSize(600,400);
		setLocation(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menu = new JMenuBar();
		
		JMenu arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic('A');
		
		
		JMenu editar = new JMenu("Editar");
		editar.setMnemonic('E');
		
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setMnemonic('j');
		
		
		JMenuItem itemNovo = new JMenuItem("Novo");
		itemNovo.setMnemonic('N');
		
		JMenuItem itemSair = new JMenuItem(new SairAction());
		itemSair.setText("Sair");
		itemSair.setMnemonic('S');		
		
		
		arquivo.add(itemNovo);
		arquivo.add(itemSair);
		
		JMenuItem itemCopiar = new JMenuItem("Copiar");
		itemCopiar.setMnemonic('C');
		editar.add(itemCopiar);
		
		
		
		menu.add(arquivo);
		menu.add(editar);
		menu.add(ajuda);
		
		
		
		
		setJMenuBar(menu);
		setVisible(true);
		
		
	}
	
	

}
