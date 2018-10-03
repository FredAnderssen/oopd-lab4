package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;



public class TimeZoneTranslatorTest {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {

		DateTime _datetime = new DateTime(2016, 1, 1, 6, 0, 0);
		
		
		System.out.println();
		System.out.println(TimeZoneTranslator.shiftTimeZone(_datetime, 1, -8).toString());
		System.out.println("AboveLine should be: 2015-12-31 21:00:00");
		
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime startDate = new DateTime(1965, 0, 0, -12, 0, 0);
		DateTime endDate = new DateTime(1965, 0, 0, 20, 0, 0);
		Person person = new Person("Fredde");
		Place place = new Place("Gothenburg", 122.232, 574.594, 57.434);
		
		Event event = new Event("test", startDate, endDate, new HashSet<>(Arrays.asList(person)), place);
		
		System.out.println(String.format("============\nOriginal event\n============\n%s", event.toString()));
		System.out.println();
		System.out.println(String.format("========================\nEvent shifted to Boston time\n========================\n%s", 
				TimeZoneTranslator.shiftEventTimeZone(event, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_EASTERN).toString()));
	}

}
