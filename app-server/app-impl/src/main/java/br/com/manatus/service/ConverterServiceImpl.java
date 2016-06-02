package br.com.manatus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.exc.AkulaServiceRuntimeException;
import br.com.manatus.model.OS;
import br.com.manatus.service.dto.OSDto;

public class ConverterServiceImpl implements ConverterService{

	private SimpleDateFormat sdf;
	
	@Override
	public void convertOS(OS os, OSDto dto) throws AkulaRuntimeException {
		try {
			sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
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