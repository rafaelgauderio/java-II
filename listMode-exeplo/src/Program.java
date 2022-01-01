import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Program {
	
	public static void main (String [] args) {
		
		List lista = new ArrayList<>();
		Produto [] vetorProduto = new Produto[lista.size()];       
	    lista.toArray(vetorProduto);                                           
	    
	    DefaultListModel modelo_nome= new DefaultListModel();
	    DefaultListModel modelo_preco= new DefaultListModel();
	    
	    lista.add(new Produto("chinelo",500.50));
	    lista.add(new Produto("Tenis",700.20));

		JList jListNomes = new JList();
		JList jListPrecos = new JList();		
	    
	    
	    
	       for (int i=0; i<vetorProduto.length; i++){
	       modelo_nome.addElement(vetorProduto[i].getNome());
	       jListNomes.setModel(modelo_nome);
	       modelo_preco.addElement(vetorProduto[i].getPreco());
	       jListPrecos.setModel(modelo_preco);
	        
	    }
	     
	       
	       
		
	}

}
