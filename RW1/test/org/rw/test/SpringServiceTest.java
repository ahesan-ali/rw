package org.rw.test;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(defaultRollback = true)
@Transactional
public class SpringServiceTest extends SpringTest {

	
	@Test
	public void init() {}
	
	
}
