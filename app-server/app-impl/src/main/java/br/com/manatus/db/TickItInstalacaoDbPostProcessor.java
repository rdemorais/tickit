package br.com.manatus.db;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.akula.api.config.AkulaPropertyFile;
import br.com.akula.api.db.InstalacaoDbService;

public class TickItInstalacaoDbPostProcessor {
	
	private static final Logger logger = LoggerFactory.getLogger(TickItInstalacaoDbPostProcessor.class);
	
	@Autowired
	private InstalacaoDbService instalacaoDbService;
	
	@Autowired
	private AkulaPropertyFile akulaPropertyFile;
	
	@PostConstruct
	public void init() {
		boolean instalarDb = Boolean.valueOf(akulaPropertyFile.getProperty("instalar.app.dev"));
		
		if(instalarDb) {
			logger.debug("chamando instalador TickIt");
			instalacaoDbService.instalarDb();
		}
	}
}