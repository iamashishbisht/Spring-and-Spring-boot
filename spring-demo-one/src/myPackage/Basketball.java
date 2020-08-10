package myPackage;

public class Basketball implements Coach {

	private myFortuneService thisFortune;
	
	Basketball(){		
	}
	// using onstructor
	Basketball(myFortuneService fortune){
		thisFortune = fortune;
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
