package com.kerjox.SpringBasico;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	private static ApplicationContext beanFactoryObj;

	// This Method Is Used To Load The Spring Bean Configuration File And Return The 'BeanFactory' Object
	public static ApplicationContext getAppContext() {
		beanFactoryObj = new ClassPathXmlApplicationContext("spring-beans.xml");
		return beanFactoryObj;
	}

	// This Is The Main Method And In Here We Are Retrieving The Spring Bean via 'getBean()' Method
	public static void main(String[] args) {
		HelloWorld helloObj = getAppContext().getBean("helloWorld", HelloWorld.class);
		System.out.println(helloObj.getUsername());
	}
}
