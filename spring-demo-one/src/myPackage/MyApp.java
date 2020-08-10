package myPackage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Coach c = new Basketball();
		//System.out.println(c.instruction());

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configXml.xml");
		
		//Coach c = context.getBean("config", Cricket.class);
		Cricket c = context.getBean("config", Cricket.class);
		
		System.out.println(c.instruction());
		System.out.println(c.getDailyFortune());
		
		/*
		 * System.out.println(c.getEmailAddress()); 
		 * System.out.println(c.getTeam());
		 */
		
		context.close();
		
	}

}
