

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




public class Calculadora {

	private JFrame frame;
	private JLabel label;
	private JList<String> lista;
	private int resultado =0;
	private boolean limpar = true;
	private String operacao = null;
	private String lista1 = "";
	private TextArea area;
	
	
	private JButton botaoCE;
	private JButton botao0;
	private JButton botao1;
	private JButton botao2;
	private JButton botao3;
	private JButton botao4;
	private JButton botao5;
	private JButton botao6;
	private JButton botao7;
	private JButton botao8;
	private JButton botao9;	
	private JButton botaoMenos;	
	private JButton botaoMais;	
	private JButton botaoDiv;	
	private JButton botaoMult;
	private JButton botaoIgual;
	private JTextArea textArea;
	private DefaultListModel model;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if("Metal".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}					


					Calculadora window = new Calculadora();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Calculadora() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout (10,10));

		label = new JLabel();
		label.setFont(new Font("Arial Black", Font.PLAIN, 16));
		label.setBackground(Color.white);
		label.setOpaque(true);
		label.setText("0");
		label.setHorizontalAlignment(JTextField.RIGHT);		
		frame.getContentPane().add(label, BorderLayout.NORTH);


		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BorderLayout());
		frame.getContentPane().add(painelBotoes,BorderLayout.CENTER);		
		painelBotoes.setLayout(new GridLayout(4,4,4,4));



		botao7 = new JButton("7");
		botao7.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);
			}


		});
		painelBotoes.add(botao7);


		botao8 = new JButton("8");
		botao8.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				tecladoNumerico(e);
			}


		});
		painelBotoes.add(botao8);

		botao9 = new JButton("9");
		botao9.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);
			}


		});
		painelBotoes.add(botao9);

		botaoDiv = new JButton("/");
		botaoDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaResultado(label.getText(), "/");

			}
		});
		painelBotoes.add(botaoDiv);


		botao4= new JButton("4");
		botao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);

			}
		});
		painelBotoes.add(botao4);

		botao5= new JButton("5");
		botao5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);

			}
		});
		painelBotoes.add(botao5);

		botao6= new JButton("6");
		botao6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);

			}
		});
		painelBotoes.add(botao6);

		botaoMult= new JButton("*");
		botaoMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaResultado(label.getText(), "*");

			}
		});
		painelBotoes.add(botaoMult);


		botao1= new JButton("1");
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);

			}
		});
		painelBotoes.add(botao1);


		botao2= new JButton("2");
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);

			}
		});
		painelBotoes.add(botao2);


		botao3= new JButton("3");
		botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);

			}
		});
		painelBotoes.add(botao3);


		botaoMenos= new JButton("-");
		botaoMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaResultado(label.getText(), "-");

			}
		});
		painelBotoes.add(botaoMenos);


		botao0= new JButton("0");
		botao0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tecladoNumerico(e);

			}
		});
		painelBotoes.add(botao0);

		botaoCE= new JButton("CE");
		botaoCE.setForeground(Color.RED);
		botaoCE.setBorderPainted(false);		
		botaoCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				Calculadora.this.resultado=0;
				Calculadora.this.operacao=null;
				visor("0");

			}
		});
		painelBotoes.add(botaoCE);


		botaoIgual= new JButton("=");
		botaoIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaResultado(label.getText(),"=");
				model.addElement(lista1);
				
				/*
				lista.setModel(new AbstractListModel() {			
					
					String[] values = new String[] {lista1};
					public int getSize() {
						return values.length;
					}
					
					public Object getElementAt(int index) {
						return values[index];
				
					}
				});
				
				*/				
				
				//DefaultListModel model = (DefaultListModel) lista.getModel();
				
			}
		});
		
		/*
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );

		for (int i = 0; i < customers.length; i++ ){
		  model.addElement( customers[i].getName() );
		}
		*/
		
		
		painelBotoes.add(botaoIgual);

		botaoMais= new JButton("+");
		botaoMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaResultado(label.getText(), "+");

			}
		});
		painelBotoes.add(botaoMais);

		
		lista = new JList<String>();		
		
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));		
		lista.setVisibleRowCount(4);
	
		model = new DefaultListModel<>();
		lista.setModel(model);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(lista);
		
		/*
		textArea = new JTextArea();  
		area = new TextArea();
		area.setSize(50,50);
		area.setVisible(true);
		area.append(lista1);
		*/	
		
		
		
		frame.getContentPane().add(scroll, BorderLayout.SOUTH);		
		
		
		lista.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {	
				
						
				
								
			}
		});
		

	}
	
	
	
	
	
	private String contaInicial(String operacao, int numero1, int numero2) {
		String conta= "";
		return conta = numero1 + " " + operacao + " " + numero2;
		
	}

	private void calculaResultado(String numero, String operacao) {

		
		String conta = "";

		if(this.limpar == true) {
			this.operacao = operacao;
			return;
		}
			
		if (numero.equals("NaN") || numero ==null || numero=="") {
			botaoCE.doClick();
		}		


		if(this.operacao !=null) {

			int temp = Integer.parseInt(numero);

			if (this.operacao=="+") {
				conta= contaInicial("+", resultado,temp);
				this.resultado  += temp;
				conta = conta +  " = " + resultado; 

			} else if (this.operacao=="-") {
				conta= contaInicial("-", resultado,temp);				
				this.resultado -= temp;
				conta = conta +  " = " + resultado; 
				
			} else if (this.operacao=="*") {
				conta= contaInicial("*", resultado,temp);
				this.resultado *= temp;
				conta = conta +  " = " + resultado; 
				
			} else if (this.operacao=="/") {
				if(temp !=0) {
					conta= contaInicial("/", resultado,temp);
					this.resultado /= temp;
					conta = conta +  " = " + resultado; 
				} else {
					this.label.setText("NaN");
					this.resultado = 0;
					this.limpar = true;
					return;
				}


			}


		} else {
			this.resultado = Integer.parseInt(numero);
		}

		label.setText(resultado + "");
		this.limpar = true;
		this.operacao = operacao;
		
		
		
		if (!conta.equals("")) {
			System.out.println(conta);
			
		}
		
		this.lista1=conta;	
		
	
	}


	private void visor(String numero) {

		if(!this.limpar) {
			label.setText(label.getText() + numero);
		}else {
			label.setText(numero);
			this.limpar=false;
		}

	}

	private void tecladoNumerico(ActionEvent e) {
		
		if(label.getText().equals("NaN")) {
			botaoCE.doClick();
		}		

		JButton botao = (JButton) e.getSource();
		String tecla = botao.getText();

		if (tecla=="0") {
			visor("0");			
		}
		else if (tecla=="1") {
			visor("1");
		}

		else if (tecla=="2") {
			visor("2");
		}
		else if (tecla=="3") {
			visor("3");
		}
		else if (tecla=="4") {
			visor("4");
		}
		else if (tecla=="5") {
			visor("5");

		}else if (tecla=="6") {
			visor("6");

		}
		else if (tecla=="7") {
			visor("7");
		}
		else if (tecla=="8") {
			visor("8");
		}
		else if (tecla=="9") {
			visor("9");

		}



	}





}
