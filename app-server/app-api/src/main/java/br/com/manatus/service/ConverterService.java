package br.com.manatus.service;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.model.OS;
import br.com.manatus.service.dto.OSDto;

public interface ConverterService {
	public void convertOS(OS os, OSDto dto) throws AkulaRuntimeException;
}