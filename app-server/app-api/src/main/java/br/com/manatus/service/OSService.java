package br.com.manatus.service;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.OSDto;

public interface OSService {
	public void manterOS(OSDto dto) throws AkulaRuntimeException;
}