import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DataHoraJava {
	
	public static void main(String [] args) {
		
		
		System.out.println("Tem uma classe para cada função.");
		System.out.println("\nLocalDate\nLocalTime\nLocalDateTime\nInstant\nZonedDateTime");
		System.out.println("Não existe construtor para essas novas Classes");
		
		//LocalDate - representa uma data: 17/12/1996
		
		LocalDate ldNow = LocalDate.now();
		System.out.println("\nAgora em LocalDate Time: " + ldNow);
		LocalDate ld = LocalDate.of(1995,Month.AUGUST,17);
		System.out.println(ld);		
		System.out.println(ld.plusWeeks(3));
		System.out.println(ld.plusMonths(2).plusDays(15).minusYears(80));
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(ld.format(formato));		
		
		
		
		//LocalTime - representa uma uma hora: 12:40:00
		LocalTime ltNow = LocalTime.now();
		System.out.println("\nAgora em LocalTime Time: " + ltNow);
		LocalTime lt = LocalTime.of(15,20, 59, 1000000);
		System.out.println(lt);
		System.out.println(lt.plusHours(5));
		
		//LocalDateTime - representa data+hora: 06/12/1982 12:30:00 em qualquer lugar do mundo
		LocalDateTime ldtNow = LocalDateTime.now();
		System.out.println("\nAgora em LocalDateTime: " + ldtNow);
		LocalDateTime ldt = LocalDateTime.of(1995, Month.DECEMBER, 17, 16, 30, 59, 50000);
		System.out.println(ldt);
		
		//Instant - represente um instante na linha do tempo
		//1970-01-01T00:00:00Z - conta o tempo a partir dessa data em milissegundos sem no GMT/UTC
		//Instant não tem informação de localidade
		Instant instNow = Instant.now();
		System.out.println("\nAgora em Instant: " + instNow);
		System.out.println("Vai dar sempre a hora no GMT: 2 horas de diferença do Brasil");
		Instant i = Instant.ofEpochMilli(350000000000L);
		System.out.println("Instante de 350000000000L: "+i);
		Instant plusFiveDays = i.plus(5, ChronoUnit.DAYS); //Não tem como somar mes e ano
		System.out.println(plusFiveDays);
		
		//ZonedDateTime - É um LocalDateTime com TimeZone, a classe mais completa
		//07/12/1982 12:35:00 GMT-3 (America/Sao_Paulo)
		
		ZonedDateTime zdtNow = ZonedDateTime.now();
		System.out.println("\nAgora em ZonedDateTime: "+ zdtNow);
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("America/Sao_Paulo"));
		ZonedDateTime zdt2 = ZonedDateTime.of(ldt, ZoneId.of("America/Buenos_Aires"));
		ZoneId zone = ZoneId.of("Europe/Paris");
		ZonedDateTime zdt3 = ZonedDateTime.of(2089, 3, 31, 12, 13, 59,0, zone);
		System.out.println(zdt);
		System.out.println(zdt2);
		System.out.println(zdt3);
		
		
		System.out.println("\nCalendar");
		Calendar now = Calendar.getInstance();
	    System.out.println(now.getTimeZone());  
	    System.out.println(now.getTime());
	    

	   
	  
		
		
		
	}

}
 