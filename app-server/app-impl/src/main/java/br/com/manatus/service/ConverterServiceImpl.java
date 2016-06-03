package br.com.manatus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.manatus.dao.OSDao;
import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.exc.AkulaServiceRuntimeException;
import br.com.manatus.model.CategoriaDemanda;
import br.com.manatus.model.Cliente;
import br.com.manatus.model.Funcionario;
import br.com.manatus.model.OS;
import br.com.manatus.model.TipoOS;
import br.com.manatus.service.dto.OSDto;

public class ConverterServiceImpl implements ConverterService{

	private SimpleDateFormat sdf;
	
	@Autowired
	private OSDao osDao;
	
	@Override
	public void convertOS(OS os, OSDto dto) throws AkulaRuntimeException {
		try {
			sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Cliente cliente = null;
			Funcionario tecResponsavel = null;
			Funcionario tecAgendamento = null;
			CategoriaDemanda cd = null;
			TipoOS tipoOs = null;
			
			if(dto.getCliente() != null) {
				cliente = osDao.find(Cliente.class, dto.getCliente().getId());
				
				if(cliente == null) {
					throw new AkulaServiceRuntimeException("Cliente nao localizado na base com ID: [" + dto.getCliente().getId() + "]");
				}
			}
			
			if(dto.getTecResponsavel() != null) {
				tecResponsavel = osDao.find(Funcionario.class, dto.getTecResponsavel().getId());
				
				if(tecResponsavel == null) {
					throw new AkulaServiceRuntimeException("Tecnico Responsavel nao localizado na base com ID: [" + dto.getTecResponsavel().getId() + "]");
				}
			}
			
			if(dto.getTecAgendamento() != null) {
				tecAgendamento = osDao.find(Funcionario.class, dto.getTecAgendamento().getId());
				
				if(tecAgendamento == null) {
					throw new AkulaServiceRuntimeException("Tecnico Agendamento nao localizado na base com ID: [" + dto.getTecAgendamento().getId() + "]");
				}
			}
			
			if(dto.getCategoriaDemanda() != null) {
				cd = osDao.find(CategoriaDemanda.class, dto.getCategoriaDemanda().getId());
				
				if(cd == null) {
					throw new AkulaServiceRuntimeException("Categoria da Demanda nao localizada na base com ID [" + dto.getCategoriaDemanda().getId() + "]");
				}
			}
			
			if(dto.getTipoOs() != null) {
				tipoOs = osDao.find(TipoOS.class, dto.getTipoOs().getId());
				
				if(tipoOs == null) {
					throw new AkulaServiceRuntimeException("Tipo OS nao localizada na base com ID [" + dto.getTipoOs().getId() + "]");
				}
			}
			
			os.setCliente(cliente);
			os.setTecResponsavel(tecResponsavel);
			os.setTecAgendamento(tecAgendamento);
			
			os.setCategoriaDemanda(cd);
			os.setTipoOs(tipoOs);
			
			os.setDataHoraChamado(sdf.parse(dto.getDataHoraChamado()));
			os.setDataAgendamento(sdf.parse(dto.getDataAgendamento()));
			os.setDataLimiteAtendimento(sdf.parse(dto.getDataLimiteAtendimento()));
			os.setDescricaoDemanda(dto.getDescricaoDemanda());
			os.setSugestaoSolucao(dto.getSugestaoSolucao());
			
			
		} catch (ParseException e) {
			throw new AkulaServiceRuntimeException(e.getMessage(), e);
		}
	}
}