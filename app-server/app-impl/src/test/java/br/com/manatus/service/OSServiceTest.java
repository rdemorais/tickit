package br.com.manatus.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.OSDto;

@ContextConfiguration("/META-INF/tickitTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OSServiceTest {
	
	@Autowired
	private OSService osService;
	
	@Test
	public void testManterOS() throws AkulaRuntimeException{
		OSDto osDto = new OSDto();
		
		osDto.setDataAgendamento("02/01/1984 14:40");
		osDto.setDataHoraChamado("03/02/2005 15:50");
		osDto.setDataLimiteAtendimento("04/03/2006 20:40");
		osDto.setDescricaoDemanda("descrição da solução");
		osDto.setSugestaoSolucao("sugestão da solução");
		
		osService.manterOS(osDto);
	}
}