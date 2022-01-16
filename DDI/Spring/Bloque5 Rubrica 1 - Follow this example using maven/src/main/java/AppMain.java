import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	private static ApplicationContext getAppContext() {

		return new ClassPathXmlApplicationContext("spring-beans.xml");
	}

	public static void main(String[] args) {

		ApplicationContext context = getAppContext();

		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.printMessage();

		GoodByeWorld goodByeWorld = context.getBean(GoodByeWorld.class);
		goodByeWorld.printMessage();

	}
}
