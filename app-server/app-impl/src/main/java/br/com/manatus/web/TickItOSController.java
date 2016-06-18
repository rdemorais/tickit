package br.com.manatus.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.manatus.service.OSService;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.DemandaDto;
import br.com.manatus.service.dto.IntervencaoDto;
import br.com.manatus.service.dto.OSDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

@Controller
@CrossOrigin(value="*", maxAge=3600)
@RequestMapping(value="/tk/api/os")
public class TickItOSController {
	
	private static final Logger logger = LoggerFactory.getLogger(TickItOSController.class);
	
	@Autowired
	private OSService osService;
	
	@RequestMapping(value="/usuario-logado", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse usuarioLogado() {
		try {
			return TickItResponse.ok(osService.getUsuarioLogado());
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/count-os", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse conuntOs() {
		try {
			Long countOs = osService.countOs();
			logger.debug("Retornando contagem de OSs: " + countOs);
			return TickItResponse.ok(countOs);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/lista-os", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse listOs(@RequestBody int pag) {
		try {
			return TickItResponse.ok(osService.listOS(pag));
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/load-os", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse loadOS(@RequestBody Long osId) {
		try {
			
			return TickItResponse.ok(osService.loadOS(osId));
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/lista-intervencoes", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse listaIntervencoes(@RequestBody Long idOs) {
		try {
			OSDto dto = new OSDto();
			dto.setId(idOs);
			return TickItResponse.ok(osService.listIntervencoes(dto));
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/manter-intervencao", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse manterIntervencao(@RequestBody IntervencaoDto dto) {
		try {
			osService.manterIntervencao(dto);
			
			return TickItResponse.ok();
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/manter", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse manterOS(@RequestBody OSDto os) {
		try {
			OSDto dto = osService.manterOS(os);
			
			return TickItResponse.ok(dto);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/lista-tipo-os", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse listTipoOS() {
		try {
			List<TipoOSDto> tiposOs = osService.listTipoOs();
			
			logger.debug("retornando tipos de OS: " + tiposOs.size());
			
			return TickItResponse.ok(tiposOs);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/lista-clientes", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse listClientes() {
		try {
			List<PessoaDto> clientes = osService.listClientes();
			
			logger.debug("retornando lista de clientes: " + clientes.size());
			
			return TickItResponse.ok(clientes);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/lista-tecnicos", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse listTecnicos() {
		try {
			List<PessoaDto> tecnicos = osService.listFuncionarios();
			
			logger.debug("retornando lista de tecnicos: " + tecnicos.size());
			
			return TickItResponse.ok(tecnicos);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/lista-categorias-demandas", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse listCategoriasDemandas() {
		try {
			List<CategoriaDemandaDto> cDemandas = osService.listCategoriaDemanda();
			
			logger.debug("retornando lista categorias de demandas: " + cDemandas.size());
			
			return TickItResponse.ok(cDemandas);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
	
	@RequestMapping(value="/lista-demandas", 
			method=RequestMethod.POST)
	@ResponseBody
	public TickItResponse listDemandas(@RequestBody DemandaDto dto) {
		try {
			List<DemandaDto> demandas = osService.listDemanda(dto);
			
			logger.debug("retornando lista de demandas: " + demandas.size());
			
			return TickItResponse.ok(demandas);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return TickItResponse.error(e.getMessage());
		}
	}
}