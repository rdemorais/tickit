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
	public PessoaDto getUsuarioLogado() throws AkulaRuntimeException {
		Usuario user = oauth2SentinelaService.usuarioLogado();
		PessoaDto usuarioLogado = osDao.loadPessoa(user.getLogin());
		return usuarioLogado;
	}
	
	
	@Transactional
	public void manterOS(OSDto dto) throws AkulaRuntimeException {
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
		
		osDao.merge(os);

		sentinelaAuditoriaEventPublisher.notificar(oauth2SentinelaService.usuarioLogado(), os, evAud);
	}
	
	@Transactional
	public void manterIntervencao(IntervencaoDto dto) throws AkulaRuntimeException {
		Intervencao inter = converterService.convertIntervencao(dto);
		
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
	public List<DemandaDto> listDemanda() throws AkulaRuntimeException {
		return osDao.listDemanda();
	}
}