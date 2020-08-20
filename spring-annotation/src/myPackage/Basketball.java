package myPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Basketball implements Coach {

	@Autowired
	@Qualifier("myFortuneService")
	private fortuneService thisFortune;
	
	@Value("${myEmail}")
	private String emailAddress;
    
	@Value("${myTeam}")
	private String team;
    
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String instruction() {
		// TODO Auto-generated method stub
		return "Throw basketball for 30 mins today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return thisFortune.getFortune();
	}

}
