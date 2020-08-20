package myPackage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myControllerPath")
public class MyController {
	

	
	@RequestMapping("/myForm2")
	public String myForm2(Model theModel) {
		
		Student theStudent = new Student();
		
		theModel.addAttribute("theStudent",theStudent);
		return "myForm2";
	}

	@RequestMapping("/processFormV3")
	public String processFormV3(@ModelAttribute("theStudent") Student theStudent) {
		
		return "processFormV3";
	}
}
