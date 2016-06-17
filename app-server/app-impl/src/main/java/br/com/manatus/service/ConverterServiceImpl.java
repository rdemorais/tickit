package br.com.manatus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.manatus.dao.OSDao;
import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.exc.AkulaServiceRuntimeException;
import br.com.manatus.model.CategoriaDemanda;
import br.com.manatus.model.Cliente;
import br.com.manatus.model.Demanda;
import br.com.manatus.model.Funcionario;
import br.com.manatus.model.Intervencao;
import br.com.manatus.model.IntervencaoImpl;
import br.com.manatus.model.OS;
import br.com.manatus.model.TipoOS;
import br.com.manatus.service.dto.IntervencaoDto;
import br.com.manatus.service.dto.OSDto;

public class ConverterServiceImpl implements ConverterService{
	
	//2016-06-08T01:18:15.824Z
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
	@Autowired
	private OSDao osDao;
	
	@Override
	public void convertOS(OS os, OSDto dto) throws AkulaRuntimeException {
		try {
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
	
	public Intervencao convertIntervencao(IntervencaoDto dto) throws AkulaRuntimeException {
		try {
			Intervencao inter = null;
			Demanda demanda = null;
			Funcionario tecAgendamento = null;
			Cliente clienteOrigem = null;
			Cliente clienteDestino = null;
			OS os = null;
			
			if(dto.getId() != null) {
				inter = osDao.find(Intervencao.class, dto.getId());
			}else {
				inter = new IntervencaoImpl();
			}
			
			if(dto.getDemanda() != null) {
				demanda = osDao.find(Demanda.class, dto.getDemanda().getId());
				
				if(demanda == null) {
					throw new AkulaServiceRuntimeException("Demanda nao encontrada na base com ID: [" + dto.getDemanda().getId() + "]");
				}
			}
			
			if(dto.getTecAgendamento() != null) {
				tecAgendamento = osDao.find(Funcionario.class, dto.getTecAgendamento().getId());
				
				if(tecAgendamento == null) {
					throw new AkulaServiceRuntimeException("Tecnico Agendamento nao encontrado na base com ID: [" + dto.getTecAgendamento().getId() + "]");
				}
			}
			
			if(dto.getClienteOrigem() != null) {
				clienteOrigem = osDao.find(Cliente.class, dto.getClienteOrigem().getId());
				
				if(clienteOrigem == null) {
					throw new AkulaServiceRuntimeException("Cliente de origem nao encontrado na base com ID: [" + dto.getClienteOrigem().getId() + "]");
				}
			}
			
			if(dto.getClienteDestino() != null) {
				clienteDestino = osDao.find(Cliente.class, dto.getClienteDestino().getId());
				
				if(clienteDestino == null) {
					throw new AkulaServiceRuntimeException("Cliente de destino nao encontrado na base com ID: [" + dto.getClienteDestino().getId() + "]");
				}
			}
			
			if(dto.getOs() != null) {
				os = osDao.find(OS.class, dto.getOs().getId());
				
				if(os == null) {
					throw new AkulaServiceRuntimeException("OS obrigatoria nao encontrada com ID: [" + dto.getOs().getId() + "]");
				}
			}
			
			inter.setObservacao(dto.getObservacao());
			inter.setDataHoraIntervencao(sdf.parse(dto.getDataHoraIntervencao()));
			if(dto.getDataHoraFimIntervencao() != null) {
				inter.setDataHoraFimIntervencao(sdf.parse(dto.getDataHoraFimIntervencao()));
			}
			inter.setOs(os);
			inter.setTecAgendamento(tecAgendamento);
			inter.setClienteOrigem(clienteOrigem);
			inter.setClienteDestino(clienteDestino);
			inter.setDemanda(demanda);
			
			return inter;
		} catch (ParseException e) {
			throw new AkulaServiceRuntimeException(e.getMessage());
		}
	}
}