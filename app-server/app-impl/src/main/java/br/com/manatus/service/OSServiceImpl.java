package br.com.manatus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.akula.api.auditoria.SentinelaAuditoriaEventPublisher;
import br.com.akula.api.model.EventoAuditoria;
import br.com.akula.api.service.SentinelaService;
import br.com.manatus.dao.OSDao;
import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.model.OS;
import br.com.manatus.model.OSImpl;
import br.com.manatus.service.dto.OSDto;

public class OSServiceImpl implements OSService{
	
	@Autowired
	private OSDao osDao;
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private SentinelaAuditoriaEventPublisher sentinelaAuditoriaEventPublisher;
	
	@Autowired
	private SentinelaService sentinelaService;
	
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
		
		switch (evAud) {
		case INSERT:
			osDao.create(os);
			break;
		case UPDATE:
			osDao.merge(os);
		default:
			break;
		}
		
		//sentinelaAuditoriaEventPublisher.notificar(sentinelaService.usuarioLogado(), os, evAud);
	}
}