
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class DataFormatar {

	public static void main(String[] args) {

		Locale.setDefault(new Locale("pt", "BR"));

		// Antigas - DateFormat e SimpleDateFormat
		LocalDateTime ldtnow = LocalDateTime.now();
		LocalDateTime data = LocalDateTime.of(1995, 12, 17, 13, 50);
		ZoneId zone = ZoneId.of("Europe/Paris");
		ZonedDateTime zdt = ZonedDateTime.of(2089, 3, 31, 12, 13, 59, 0, zone);
		LocalDate agoraData = LocalDate.now();
		LocalTime agoraTime = LocalTime.now();
		LocalDateTime agoraLocalDateTime = LocalDateTime.now();

		System.out.println(ldtnow);
		System.out.println();

		DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter isoTime = DateTimeFormatter.ISO_TIME;
		DateTimeFormatter formatterShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter formatterMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter formatterLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		DateTimeFormatter formatterFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

		String dataFormatada1 = isoDateTime.format(ldtnow);
		System.out.println(dataFormatada1);

		String dataFormatada2 = isoDate.format(ldtnow);
		System.out.println(dataFormatada2);

		String dataFormatada3 = isoTime.format(ldtnow);
		System.out.println(dataFormatada3);

		System.out.println("\nEstilos de Data");
		System.out.println(data.format(formatterShort));
		System.out.println(data.format(formatterMedium));
		System.out.println(data.format(formatterLong));
		System.out.println(zdt.format(formatterFull));

		// Definindo um formato proprio
		DateTimeFormatter formatoProprio = DateTimeFormatter.ofPattern("dd/MM/yyyy HH-mm-ss");
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH-mm-ss");
		System.out.println(data.format(formatoProprio));
		System.out.println(agoraLocalDateTime.format(formatoProprio));
		System.out.println(agoraData.format(formatoData));
		System.out.println(agoraTime.format(formatoHora));

		String dataString = formatoHora.format(data);
		System.out.println(dataString);

		// Tenho String e quero converter para Data
		TemporalAccessor parse1 = formatoProprio.parse("31/12/1980 11-50-48");
		TemporalAccessor parse2 = formatoHora.parse("07-50-12");
		LocalDateTime from = LocalDateTime.from(parse1);
		LocalTime from2 = LocalTime.from(parse2);
		
		System.out.println(parse1);
		System.out.println(from);
		System.out.println(from2);
		

	}

}
