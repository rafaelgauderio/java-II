
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class DataPeriod {
	
	
	public static void main(String [] args) {
		
		System.out.println("Periodo e Duration servem para armazenar espaço de tempo");
		System.out.println("Periodo - valores tipos datas\n"
				+ "Duration - duranção em tempo\n");
		
		
		Period periodo = Period.of(1,10,7);
		System.out.println("FORMATO:P ANOY MESM DIAD - "+periodo);
		
		Period ofDays = Period.ofDays(5);
		Period ofMonth = Period.ofMonths(12);
		Period ofYears = Period.ofYears(3);
		Period ofWeeks = Period.ofWeeks(7);
		
		System.out.println("Dias: " +ofDays);
		System.out.println("Meses: " +ofMonth);
		System.out.println("Anos: " +ofYears);
		System.out.println("Semanas convertidas em Dias: " +ofWeeks);
		
		
		LocalDate ld1 = LocalDate.of(1995,Month.AUGUST,17);
		LocalDate ld2 = ld1.plusYears(3).plusDays(8);		
		LocalDate ld3 = ld1.minusMonths(7).minusYears(2);
		
		System.out.println("\nPeriodo entre datas");
		Period between1 = Period.between(ld1, ld2);
		Period between2 = Period.between(ld1,ld3);
		System.out.println(between1);
		System.out.println(between2);		
		
		Period between3 = between2.multipliedBy(3);
		System.out.println(between3);
		System.out.println(between3.plusDays(50));
		
		Period until = ld1.until(ld2); //calcular o periodo entre duas datas
		System.out.println("until:" + until);		
		
		Period fiveYears = Period.ofYears(5);
		LocalDate plusFive = ld1.plus(fiveYears);
		System.out.println(ld1);
		System.out.println("Somando 5 anos ao ld1: " + plusFive);	
		
	}
 
}
