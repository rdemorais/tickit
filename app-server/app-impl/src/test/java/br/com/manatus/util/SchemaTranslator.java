package br.com.manatus.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.engine.jdbc.internal.Formatter;

import br.com.akula.impl.model.GrupoImpl;
import br.com.akula.impl.model.PaginaImpl;
import br.com.akula.impl.model.PermissaoGrupoUsuarioImpl;
import br.com.akula.impl.model.PermissaoImpl;
import br.com.akula.impl.model.UsuarioGrupoImpl;
import br.com.akula.impl.model.UsuarioImpl;

public class SchemaTranslator {
	private Configuration config = null;

	public SchemaTranslator() {
		config = new Configuration();
	}

	public SchemaTranslator setDialect(String dialect) {
		config.setProperty(AvailableSettings.DIALECT, dialect);
		return this;
	}

	/**
	 * Method determines classes which will be used for DDL generation. 
	 * @param annotatedClasses - entities annotated with Hibernate annotations.
	 */
	@SuppressWarnings("rawtypes")
	public SchemaTranslator addAnnotatedClasses(Class[] annotatedClasses) {
		for (Class clazz : annotatedClasses)
			config.addAnnotatedClass(clazz);
		return this;
	}

	/**
	 * Method performs translation of entities in table schemas.
	 * It generates 'CREATE' and 'DELETE' scripts for the Hibernate entities.
	 * Current implementation involves usage of {@link #write(FileOutputStream, String[], Formatter)} method.
	 * @param outputStream - stream will be used for *.sql file creation.
	 * @throws IOException
	 */
	public SchemaTranslator translate(FileOutputStream outputStream) throws IOException {
		Dialect requiredDialect = Dialect.getDialect(config.getProperties());
		String[] query = null;

		query = config.generateDropSchemaScript(requiredDialect);
		write(outputStream, query, FormatStyle.DDL.getFormatter());

		query = config.generateSchemaCreationScript(requiredDialect);
		write(outputStream, query, FormatStyle.DDL.getFormatter());

		return this;
	}

	/**
	 * Method writes line by line DDL scripts in the output stream.
	 * Also each line logs in the console.
	 * @throws IOException
	 */
	private void write(FileOutputStream outputStream, String[] lines, Formatter formatter) 
			throws IOException {
		String tempStr = null;

		for (String line : lines) {
			tempStr = formatter.format(line)+";";
			outputStream.write(tempStr.getBytes());
		}
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		SchemaTranslator translator = new SchemaTranslator();
		
		Class[] entiClassesMA = {
				UsuarioImpl.class, 
				GrupoImpl.class, 
				PaginaImpl.class, 
				PermissaoGrupoUsuarioImpl.class, 
				PermissaoImpl.class,
				UsuarioGrupoImpl.class};

		translator.setDialect("org.hibernate.dialect.PostgreSQLDialect")
		.addAnnotatedClasses(entiClassesMA)
		.translate(new FileOutputStream(new File("/Users/rafaeldemorais/git/tickit/app-server/app-impl/src/main/resources/sql/ddl.sql")));
	}

}