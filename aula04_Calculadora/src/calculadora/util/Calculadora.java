package calculadora.util;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Calculadora extends JFrame{	
	
	
	private static final long serialVersionUID = 1L;

	public Calculadora()  throws Exception{
		
		super("Calculadora");
		
		UIManager.setLookAndFeel(new MetalLookAndFeel());
		setSize(380,350);
		setLocation(300,200);
		
		setLayout(new BorderLayout());
		
		TextPanel painelTexto = new TextPanel();
		add(BorderLayout.NORTH, painelTexto);
		
		JPanel painelDigitos = new JPanel();
		painelDigitos.setLayout(new BorderLayout());
		
		painelDigitos.add(BorderLayout.CENTER, new PainelNumeros(painelTexto.getTextNumber()));
		painelDigitos.add(BorderLayout.EAST, new PainelOperacoes(painelTexto.getTextNumber()));
		
		add(BorderLayout.CENTER, painelDigitos);		
		
		
		
		setVisible(true);
		
		
	}
	

	
	
	
	
	
	

}
