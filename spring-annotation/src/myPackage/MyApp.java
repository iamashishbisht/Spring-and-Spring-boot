package myPackage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configXml.xml");
    
    //Cricket c = context.getBean("cricket", Cricket.class);
    Basketball c = context.getBean("basketball", Basketball.class);
    
	System.out.println(c.instruction());
	System.out.println(c.getDailyFortune());
	
	System.out.println(c.getEmailAddress());
	System.out.println(c.getTeam());
	
	context.close();
    
    

	}

}
