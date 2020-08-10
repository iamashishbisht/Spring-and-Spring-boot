package myPackage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Myapp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configXml.xml");

		Cricket c = context.getBean("config", Cricket.class);
		
		System.out.println(c.instruction());
		System.out.println(c.getDailyFortune());
		
		System.out.println(c.getEmailAddress());
		System.out.println(c.getTeam());
		
		context.close();
		
	}

}
