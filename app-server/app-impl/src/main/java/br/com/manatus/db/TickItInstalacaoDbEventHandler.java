package br.com.manatus.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import br.com.akula.api.db.AkulaInstalacaoDbEvent;
import br.com.akula.api.db.InstalacaoDb;
import br.com.akula.impl.db.AbstractAkulaInstalacaoDbEventHandler;

public class TickItInstalacaoDbEventHandler extends AbstractAkulaInstalacaoDbEventHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(TickItInstalacaoDbEventHandler.class);
	
	public void onApplicationEvent(AkulaInstalacaoDbEvent event) {
		logger.debug("Instalando base de dados TickIt");
		
		InstalacaoDb instDb = (InstalacaoDb) event.getSource();
		
		Resource ddl = replaceVariable(instDb, "classpath:sql/ddl.sql");
		
		instalacaoDb.executeSQLScript(ddl);
		
		Resource insert = replaceVariable(instDb, "classpath:sql/insert.sql");
		
		instalacaoDb.executeSQLScript(insert);
	}
}