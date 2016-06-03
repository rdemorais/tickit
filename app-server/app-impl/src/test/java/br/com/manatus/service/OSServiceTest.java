package br.com.manatus.service;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.DemandaDto;
import br.com.manatus.service.dto.IntervencaoDto;
import br.com.manatus.service.dto.OSDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

@ContextConfiguration("/META-INF/tickitTest-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder
public class OSServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(OSServiceTest.class);
	
	@Autowired
	private OSService osService;
	
	@Test
	public void testManterOS() throws AkulaRuntimeException{
		logger.debug("testManterOS");
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
	
	@Test
	public void testIncluirIntervencao() {
		logger.debug("testIncluirIntervencao");
		OSDto osDto = new OSDto();
		IntervencaoDto interDto = new IntervencaoDto();
		PessoaDto clienteOrigem = new PessoaDto();
		PessoaDto clienteDestino = new PessoaDto();
		PessoaDto tecResponsavel = new PessoaDto();
		
		osDto.setId(1L);
		clienteOrigem.setId(4L);
		clienteDestino.setId(4L);
		tecResponsavel.setId(2L);
		
		interDto.setObservacao("observação da intervenção");
		interDto.setDataHoraIntervencao("12/03/2004 14:43");
		interDto.setClienteOrigem(clienteOrigem);
		interDto.setClienteDestino(clienteDestino);
		interDto.setTecResponsavel(tecResponsavel);
		interDto.setOs(osDto);
		
		osService.manterIntervencao(interDto);
	}
	
	@Test
	public void testListClientes() {
		logger.debug("testListClientes");
		
		List<PessoaDto> clientes = osService.listClientes();
		
		for (PessoaDto pessoaDto : clientes) {
			logger.debug(pessoaDto.toString());
		}
	}
	
	@Test
	public void testListFuncionarios() {
		logger.debug("testListFuncionarios");
		
		List<PessoaDto> funcionarios = osService.listFuncionarios();
		
		for (PessoaDto pessoaDto : funcionarios) {
			logger.debug(pessoaDto.toString());
		}
	}
	
	@Test
	public void testListTipoOs() {
		logger.debug("testListTipoOs");
		
		List<TipoOSDto> tipoOss = osService.listTipoOs();
		
		for (TipoOSDto tipoOSDto : tipoOss) {
			logger.debug(tipoOSDto.toString());
		}
	}
	
	@Test
	public void testListCategoriaDemanda() {
		logger.debug("testListCategoriaDemanda");
		
		List<CategoriaDemandaDto> cds = osService.listCategoriaDemanda();
		
		for (CategoriaDemandaDto categoriaDemandaDto : cds) {
			logger.debug(categoriaDemandaDto.toString());
		}
	}
	
	@Test
	public void testListDemanda() {
		logger.debug("listDemanda");
		
		List<DemandaDto> demandas = osService.listDemanda();
		
		for (DemandaDto demandaDto : demandas) {
			logger.debug(demandaDto.toString());
		}
	}
}