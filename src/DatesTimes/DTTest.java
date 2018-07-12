package DatesTimes;
import java.time.*;

public class DTTest {

	public static void main(String[] args) {
		
		LocalTime lt = LocalTime.now();
		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime zdt = ZonedDateTime.now();
		
		System.out.println(lt + "\n" +ld + "\n" +ldt + "\n" +zdt + "\n");
		
		LocalDate ld1 = LocalDate.of(2018, 8, 12);
		LocalDate ld2 = LocalDate.of(2018, Month.AUGUST, 12);
		
		System.out.println(Month.JANUARY.getValue());
		
		LocalTime lt1 = LocalTime.of(10, 12);
		LocalTime lt2 = LocalTime.of(10, 12, 25);
		LocalTime lt3 = LocalTime.of(10, 12, 25, 253);
		
		LocalDateTime ldt1 = LocalDateTime.of(2018, 11, 23, 11, 35);
		LocalDateTime ldt2 = LocalDateTime.of(2018, 11, 23, 11, 35, 59);
		LocalDateTime ldt3 = LocalDateTime.of(2018, 11, 23, 11, 35, 59, 426);
		LocalDateTime ldt4 = LocalDateTime.of(ld1, lt1);
		
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2018, 11, 23, 11, 35, 59, 426, zoneId);
		ZonedDateTime zonedDateTime2 = ZonedDateTime.of(ld2, lt2, zoneId);
		ZonedDateTime zonedDateTime3 = ZonedDateTime.of(ldt4, zoneId);
		
		ZoneId.getAvailableZoneIds().stream().filter(s->s.contains("Euro")).sorted().forEach(System.out::println);
		

	}

}
