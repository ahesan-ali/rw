package org.rw.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

	@Test
	public void doubleQuote() {
		assertEquals("\"abc\"", StringUtils.doubleQuote("abc"));
		assertNotEquals("abc", StringUtils.doubleQuote("abc"));
		
		assertEquals("\"\"", StringUtils.doubleQuote(""));
		assertEquals(null, StringUtils.doubleQuote(null));
		assertEquals("\"a'b'c\"", StringUtils.doubleQuote("a'b'c"));
		
		assertEquals("\"a\"bc\"", StringUtils.doubleQuote("a\"bc"));
	}
	
}
