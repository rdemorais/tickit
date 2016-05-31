package br.com.manatus.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

import br.com.akula.api.config.AkulaPropertyFile;

public class AkulaPersistenceUnitPostProcessor implements PersistenceUnitPostProcessor{

	@Autowired
	private AkulaPropertyFile akulaPropertyFile;
	
	@Override
	public void postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo pui) {
		pui.getProperties().setProperty("hibernate.connection.url", akulaPropertyFile.getProperty("hibernate.connection.url"));
		pui.getProperties().setProperty("hibernate.connection.username", akulaPropertyFile.getProperty("hibernate.connection.username"));
		pui.getProperties().setProperty("hibernate.connection.password", akulaPropertyFile.getProperty("hibernate.connection.password"));
	}
}