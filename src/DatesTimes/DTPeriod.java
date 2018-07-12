package DatesTimes;

import java.time.*;

public class DTPeriod {

	public static void main(String[] args) {

		Period p1 = Period.ofYears(1);
		Period p2 = Period.ofMonths(1);
		Period p3 = Period.ofDays(1);
		
		Period p4 = Period.of(0, 1, 2);
		
		LocalDate ld = LocalDate.now();
		for (int i = 0; i < 5; i++) {
			System.out.println(ld);
			ld = ld.plus(p2).plus(p3);			
		}

		System.out.println("****");
		ld = LocalDate.now();
		for (int i = 0; i < 5; i++) {
			System.out.println(ld);
			ld = ld.plus(p4);			
		}
		System.out.println("****");
		System.out.println(p4);
		
		Duration pt1 = Duration.ofDays(1);
		Duration pt2 = Duration.ofHours(1);
		Duration pt3 = Duration.ofMinutes(1);
		

		System.out.println("****");
		Duration pt4 = Duration.ofHours(1).ofMinutes(1);
		System.out.println(pt4);//!!!!!!!!!!!!!!!!!
		System.out.println("****");
		LocalTime lt = LocalTime.now();
		for (int i = 0; i < 15; i++) {
			System.out.println(lt);
			lt = lt.plus(pt2).plus(pt3);			
		}
		
		System.out.println("****");
		System.out.println(Instant.now());

		Duration pt5 = Duration.between(LocalDateTime.of(2018,07,12,10,05), LocalDateTime.now());
		System.out.println(pt5);//PT2H55M53.537S
		
		System.out.println(ZonedDateTime.now());
		System.out.println(ZonedDateTime.now().toInstant());
		


	}

}
