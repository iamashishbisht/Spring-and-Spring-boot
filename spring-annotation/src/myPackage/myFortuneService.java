package myPackage;

import org.springframework.stereotype.Component;

@Component
public class myFortuneService implements fortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return " Your Fortune is good for this week";
	}

}
