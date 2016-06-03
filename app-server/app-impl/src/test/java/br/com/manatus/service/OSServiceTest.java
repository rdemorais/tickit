package br.com.manatus.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.OSDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

@ContextConfiguration("/META-INF/tickitTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OSServiceTest {
	
	@Autowired
	private OSService osService;
	
	@Test
	public void testManterOS() throws AkulaRuntimeException{
		OSDto osDto = new OSDto();
		PessoaDto cliente = new PessoaDto();
		PessoaDto fun1 = new PessoaDto();
		PessoaDto fun2 = new PessoaDto();
		CategoriaDemandaDto cd = new CategoriaDemandaDto();
		TipoOSDto tipoOs = new TipoOSDto();
		
		osDto.setDataAgendamento("02/01/1984 14:40");
		osDto.setDataHoraChamado("03/02/2005 15:50");
		osDto.setDataLimiteAtendimento("04/03/2006 20:40");
		osDto.setDescricaoDemanda("descrição da solução");
		osDto.setSugestaoSolucao("sugestão da solução");
		
		cd.setId(1L);
		tipoOs.setId(1L);
		
		cliente.setId(4L);
		fun1.setId(2L);
		fun2.setId(3L);
		
		osDto.setCliente(cliente);
		osDto.setTecAgendamento(fun1);
		osDto.setTecResponsavel(fun2);
		osDto.setCategoriaDemanda(cd);
		osDto.setTipoOs(tipoOs);
		
		osService.manterOS(osDto);
	}
}