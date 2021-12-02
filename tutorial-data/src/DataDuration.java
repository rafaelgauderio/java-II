import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DataDuration {

	public static void main(String[] args) {
		
		
		System.out.println("Duration - armazena tempo");
		
		Duration ofDays = Duration.ofDays(5);
		System.out.println(ofDays);
		
		Duration ofHour = Duration.ofHours(10);
		System.out.println(ofHour);
		
		Duration ofMinutes = Duration.ofMinutes(700);
		System.out.println(ofMinutes);
		
		Duration ofSeconds = Duration.ofSeconds(60);
		System.out.println(ofSeconds);
		
		Duration NanoSeconds = Duration.ofNanos(5000L);
		System.out.println(NanoSeconds);
		
		LocalTime agora = LocalTime.now();
		LocalTime lt = LocalTime.of(20, 5);				
		Duration entreHoras = Duration.between(lt, agora);
		System.out.println("\n"+agora);
		System.out.println(lt);
		System.out.println(entreHoras);		
		System.out.println(entreHoras.plusHours(20));
		System.out.println(entreHoras.minusHours(2));
		
		LocalDate dataNascimento = LocalDate.of(2008,12,17);
		LocalDate hoje = LocalDate.now();
		Period idade = Period.between(dataNascimento, hoje);		
		System.out.println("Idade: " + idade);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Data Nascimento: " + dataNascimento.format(formato));
		System.out.println("Hoje: " + hoje.format(formato));
		System.out.println(idade.getYears()+ " anos");	
		
		

	}

}
