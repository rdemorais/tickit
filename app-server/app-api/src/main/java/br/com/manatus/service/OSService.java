package br.com.manatus.service;

import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.OSDTO;

public interface OSService {
	public void manterOS(OSDTO dto) throws AkulaRuntimeException;
}