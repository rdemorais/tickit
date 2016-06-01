package br.com.manatus.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("/META-INF/tickitTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OSServiceTest {
	
	@Autowired
	private OSService osService;
	
	@Test
	public void testManterOS() {
		osService.manterOS(null);
	}
}