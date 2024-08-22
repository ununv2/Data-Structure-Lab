package forStudent;




import logic.main;

public class StandUser extends Character{
	
	
	//Fill Remaining Fields here
	private int maxHp;
	private int currentHp;
		
		
	// End of filling area
	
	private boolean isGuard = false;
	private Stand stand = null;

	//Filling Constructor below
	
	public StandUser(String name, int hp, String quote, int strength, int defense) {
		super(name,quote,strength,defense);
		this.maxHp = hp < 1 ? 1 : hp;
		this.currentHp = hp < 1 ? 1 : hp;
		
	}
		
	// End of Filling Constructor area

		
	//Complete the takeDamage Method below.
	public int takeDamage(int damage) {
		int TotalDefense;
		int damageDealt;
		if(stand == null) {
			 TotalDefense = this.getDefense();
		}
		else {
			 TotalDefense = this.getDefense() + (stand.IsActive()?stand.getDefense():0);
		}
		//Fill code below
		if(!isGuard) {
			damageDealt = damage - TotalDefense;
		}else {
			damageDealt = damage - (TotalDefense*2);
		}
		damageDealt = damageDealt < 0 ? 0 : damageDealt;
		this.setCurrentHp(this.getCurrentHp()-damageDealt);
		if(this.getCurrentHp()<0) {
			this.setCurrentHp(0);
		}
		return damageDealt;
			
		//End of Fill Code area 

	}

	//Complete doDamage Methods below.
	public int doDamage(StandUser target) {
		return target.takeDamage(this.getStrength() + (stand.IsActive()?stand.getStrength():0));
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int hp) {
		if(hp < 0) {
			this.currentHp = 0;
		}
		else
			this.currentHp = hp;
	}
	
	public boolean isGuard() {
		return isGuard;
	}
	public void setGuard(boolean isGuard) {
		this.isGuard = isGuard;
	}
	
	public void setStand(Stand stand) {
		this.stand = stand;
	}
	

	public void printShowStat() {
		System.out.println("***************************");
		System.out.println(this.getName());
		System.out.println("\"" + this.getQuote()+ "\"" );
		System.out.println("HP = " + this.getMaxHp() );
		System.out.println("Strength = " + this.getStrength() );
		System.out.println("Defense  = " + this.getDefense() );
		System.out.println("***************************");
	}
	
	public StandUser selectStandUser() {
		printShowStat();
		main.kb.nextLine();
		System.out.println("Are you sure ? (Y/N) :");
		String special = main.kb.nextLine().trim().toLowerCase();
		boolean isSelected = special.equals("y") ? true : false ;
		if(isSelected)
			return this;
		else
			return null;
	}
	

	

}
	
	
	

