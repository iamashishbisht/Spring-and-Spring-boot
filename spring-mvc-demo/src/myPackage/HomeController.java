package myPackage;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;

@Controller
public class HomeController {
    /*
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	*/
	@RequestMapping("/myForm")
	public String formPage() {
		return "myForm";
	}
	
	@RequestMapping("/processForm")
	public String processPage() {
		return "processForm";
	}
	
	@RequestMapping("/processFormV2")
	public String processFormV2(HttpServletRequest req, Model model) {
		String name = req.getParameter("fullName");
		
		name = name.toUpperCase();
		//System.out.println(name);
		model.addAttribute("name" , name);
		
		model.addAttribute("nickName" , name + "UUUU");
		
		return "processFormV2";
	}
}

