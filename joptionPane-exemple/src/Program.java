import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {
		
		Integer botaoDialogo = JOptionPane.YES_NO_OPTION;
		Integer resultado= JOptionPane.showConfirmDialog(null, "Tem certeza deseja EXCLUIR!", "AVISO", JOptionPane.YES_NO_OPTION);

		if (resultado == JOptionPane.NO_OPTION) {
			System.out.println("Dados não alterados");
		} else if (resultado == JOptionPane.YES_OPTION) {			
			System.out.println("Entrou na opcao sim");
		} else if (resultado == JOptionPane.CLOSED_OPTION) {
			System.out.println("Fechar caixa dialogo");
		}

	}

}
