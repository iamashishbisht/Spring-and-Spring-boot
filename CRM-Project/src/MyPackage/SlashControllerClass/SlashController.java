package MyPackage.SlashControllerClass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SlashController {

	@RequestMapping("/")
	public String slash()
	{
		return "redirect:customer/list";
		
	}
}
