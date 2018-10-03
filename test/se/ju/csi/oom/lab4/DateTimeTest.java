package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testToString() {
		DateTime datetime = new DateTime(2016, 1, 1, 6, 0, 0);
		
		Assert.assertEquals(new String("2016-01-01 06:00:00"), datetime.toString());
		
		System.out.println(datetime.toString());
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDateTimeString() {
		DateTime datetime = new DateTime("2015-04-04 05:05:05");
		
		Assert.assertEquals(new String("2015-04-04 05:05:05"), datetime.toString());
		
		System.out.println(datetime.toString());		
	}

}
