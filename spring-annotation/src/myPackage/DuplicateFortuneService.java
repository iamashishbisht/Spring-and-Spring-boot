package myPackage;

import org.springframework.stereotype.Component;

@Component
public class DuplicateFortuneService implements fortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Duplicate Fortune Service";
	}

}
