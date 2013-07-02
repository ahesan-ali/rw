package org.rw.util;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

public class TimestampUtilsTest {

	@Test
	public void format() throws Exception {
		
		Date date = DateUtils.parseDateStrictly("11/02/1989", new String[] {"dd/MM/yyy"});
		assertEquals("11/02/1989", TimestampUtils.format(new Timestamp(date.getTime())));
		
		
	}
	
}
