package br.com.manatus.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.manatus.dao.OSDao;
import br.com.manatus.exc.AkulaRuntimeException;
import br.com.manatus.service.dto.OSDTO;

public class OSServiceImpl implements OSService{
	
	@Autowired
	private OSDao osDao;
	
	public void manterOS(OSDTO dto) throws AkulaRuntimeException {
		
	}
}