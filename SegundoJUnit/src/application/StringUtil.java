package application;

import org.junit.After;
import org.junit.Before;

public class StringUtil {
	
	
	@Before
	public void before() {
		System.out.println("Iniciando o teste");
	}
	
	@After
	public void after() {
		System.out.println("Finalizado todos os testes!");
	}
	
	
	public static boolean isEmpty  (String string){
		
		if (string == null) {
			return true;
		}
		
		//trim() remove os espaços em brancos
		string = string.trim();
		return string.length() == 0;
						
	}
	
	public static String reverse(String string) {
		if (string == null) {
			return string;
		}
		StringBuilder sb = new StringBuilder(string);
		sb.reverse();

		return sb.toString();
	}	
	
	
	

}
