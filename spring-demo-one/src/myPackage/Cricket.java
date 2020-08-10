package myPackage;

public class Cricket implements Coach{
    
	private myFortuneService thisFortune;
    
	private String emailAddress;
    private String team;
    
    
    public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		this.team = team;
	}

    
	public String instruction(){
		
		return "Bat for 1 hour in nets";
	}
	


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Cricket :"+ thisFortune.getFortune();
	}

	//using setter

	public void setThisFortune(myFortuneService thisFortune) {
		this.thisFortune = thisFortune;
	}
}
