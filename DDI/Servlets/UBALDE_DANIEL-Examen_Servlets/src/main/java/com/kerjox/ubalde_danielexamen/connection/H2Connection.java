package com.kerjox.ubalde_danielexamen.connection;

public class H2Connection extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getUser() {
		return "sa";
	}

	@Override
	public String getPass() {
		return "";
	}

	@Override
	public String getUrl() {
		return "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:/scripts/init.sql'";
	}
}
