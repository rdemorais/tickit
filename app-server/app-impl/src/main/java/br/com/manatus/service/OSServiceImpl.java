package br.com.manatus.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.akula.api.auditoria.SentinelaAuditoriaEventPublisher;
import br.com.akula.api.model.EventoAuditoria;
import br.com.akula.api.model.Usuario;
import br.com.akula.api.service.SentinelaService;
import br.com.manatus.dao.OSDao;
import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.model.Intervencao;
import br.com.manatus.model.OS;
import br.com.manatus.model.OSImpl;
import br.com.manatus.service.dto.CategoriaDemandaDto;
import br.com.manatus.service.dto.DemandaDto;
import br.com.manatus.service.dto.IntervencaoDto;
import br.com.manatus.service.dto.OSDto;
import br.com.manatus.service.dto.PessoaDto;
import br.com.manatus.service.dto.TipoOSDto;

public class OSServiceImpl implements OSService{
	
	@Autowired
	private OSDao osDao;
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private SentinelaAuditoriaEventPublisher sentinelaAuditoriaEventPublisher;
	
	@Autowired
	private SentinelaService oauth2SentinelaService;
	
	@Transactional
	public List<OSDto> listOS() throws AkulaRuntimeException {
		return osDao.listOS();
	}
	
	@Transactional
	public PessoaDto getUsuarioLogado() throws AkulaRuntimeException {
		Usuario user = oauth2SentinelaService.usuarioLogado();
		PessoaDto usuarioLogado = osDao.loadPessoa(user.getLogin());
		return usuarioLogado;
	}
	
	public OSDto loadOS(Long id) throws AkulaRuntimeException {
		return osDao.loadOS(id);
	}
	
	@Transactional
	public OSDto manterOS(OSDto dto) throws AkulaRuntimeException {
		OS os;
		EventoAuditoria evAud;
		if(dto.getId() != null) {
			os = osDao.find(OS.class, dto.getId());
			evAud = EventoAuditoria.UPDATE;
		}else {
			os = new OSImpl();
			evAud = EventoAuditoria.INSERT;
		}
		
		converterService.convertOS(os, dto);
		
		OS osMerged = (OS) osDao.merge(os);

		sentinelaAuditoriaEventPublisher.notificar(oauth2SentinelaService.usuarioLogado(), osMerged, evAud);
		
		OSDto dtoMerged = new OSDto();
		dtoMerged.setId(osMerged.getId());
		return dtoMerged;
	}
	
	@Transactional
	public void manterIntervencao(IntervencaoDto dto) throws AkulaRuntimeException {
		Intervencao inter = converterService.convertIntervencao(dto);
		//TODO Verificar StatusOS e modificar a OS em caso de FECHADA
		osDao.merge(inter);
	}
	
	@Transactional
	public List<PessoaDto> listClientes() throws AkulaRuntimeException {
		return osDao.listClientes();
	}
	
	@Transactional
	public List<PessoaDto> listFuncionarios() throws AkulaRuntimeException {
		return osDao.listFuncionarios();
	}
	
	@Transactional
	public List<TipoOSDto> listTipoOs() throws AkulaRuntimeException {
		return osDao.listTipoOs();
	}
	
	@Transactional
	public List<CategoriaDemandaDto> listCategoriaDemanda() throws AkulaRuntimeException {
		return osDao.listCategoriaDemanda();
	}
	
	@Transactional
	public List<DemandaDto> listDemanda(DemandaDto dto) throws AkulaRuntimeException {
		return osDao.listDemanda(dto.getId());
	}
}