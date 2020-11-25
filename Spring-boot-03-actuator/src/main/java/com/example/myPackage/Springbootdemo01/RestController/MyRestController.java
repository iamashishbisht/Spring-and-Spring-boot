package com.example.myPackage.Springbootdemo01.RestController;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	
	
	@GetMapping("/")
	public String sayHello()
	{
		
		return "Hello World the time on Server is : " + LocalDateTime.now();
	}
	@GetMapping("/hi")
	public String sayHi()
	{
		
		return "Hi the World the time on Server is : " + LocalDateTime.now();
	}
	@GetMapping("/bye")
	public String sayBye()
	{
		
		return "Bye Bye at : " + LocalDateTime.now();
	}
	
}
