import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	private static ApplicationContext getAppContext() {

		return new ClassPathXmlApplicationContext("spring-beans.xml");
	}

	public static void main(String[] args) {

		Department deptObj = getAppContext().getBean("department", Department.class);
		deptObj.showResult();
	}
}
