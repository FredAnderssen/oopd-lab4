package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;



public class TimeZoneTranslatorTest {
	
	
	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShiftTimeZone() {

		DateTime _datetime = new DateTime(2016, 1, 1, 6, 0, 0);
		
		_datetime = TimeZoneTranslator.shiftTimeZone(_datetime, 1, -8);
		
		Assert.assertEquals(new String("2015-12-31 21:00:00"), _datetime.toString());
		
		System.out.println();
		System.out.println();
		System.out.println("Above Line should be: 2015-12-31 21:00:00");
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShiftEventTimeZone() {
		DateTime startDate = new DateTime(1965, 0, 0, 8, 0, 0);
		DateTime endDate = new DateTime(1965, 0, 0, 20, 0, 0);
		Person person = new Person("Fredde");
		Place place = new Place("Gothenburg", 122.232, 574.594, 57.434);
		
		Event event = new Event("test", startDate, endDate, new HashSet<>(Arrays.asList(person)), place);
		
		event = TimeZoneTranslator.shiftEventTimeZone(event, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_EASTERN);
		
		Assert.assertEquals(new String("1965-00-00 02:00:00"), event.getStartDate().toString());
		Assert.assertEquals(new String("1965-00-00 14:00:00"), event.getEndDate().toString());
		
		System.out.println(String.format("============\nOriginal event\n============\n%s", event.toString()));
		System.out.println();
		System.out.println(String.format("========================\nEvent shifted to Boston time\n========================\n%s", 
				TimeZoneTranslator.shiftEventTimeZone(event, TimeZone.CENTRAL_EUROPEAN_TIME, TimeZone.US_EASTERN).toString()));
		
		
		
	}

}
