package myPackage;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class customerController {
    
	
	@InitBinder
	public void initBinder(WebDataBinder theWebDataBinder) {
		
		StringTrimmerEditor theStringTrimmerEditor = new StringTrimmerEditor(true); //true means for whoitespaces it should be null
	    theWebDataBinder.registerCustomEditor(String.class, theStringTrimmerEditor);
	}
	
	@RequestMapping("/customerForm")
	public String customerForm(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("theCustomer", theCustomer);
		
		return "customerForm" ;
	}
	
	@RequestMapping("/customerProcessForm")
	public String customerForm( @Valid @ModelAttribute("theCustomer") Customer theCustomer,
			                     BindingResult theBindingResult) {

		//System.out.println("thecustomer last name :"+ theCustomer.getFirstName().toUpperCase());
		System.out.println(theBindingResult.hasErrors());
		
		if (theBindingResult.hasErrors())
		{
			return "customerForm" ;
		}
		else {
		return "customerProcessForm" ;
		}
	}
}
