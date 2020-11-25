package MyPackage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		
		return "loginPage";
	}
	
	 @RequestMapping("/acess-denied")
	    public String acessdenied() {
	    	
	    	return "acess-denied-page";
	    }
   
    
    
    @RequestMapping("/manager")
    public String managerpage() {
    	
    	return "manager-page";
    }
    @RequestMapping("/admin")
    public String adminpage() {
    	
    	return "admin-page";
    }

}
