package MyPackage.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyRestController {
	
	@RequestMapping("/hello")
	public String SayHello()
	{
		return "hello man";
		
	}


}
