package logic;

public class Station {
	
	private String name;
	private int number;

	public Station(String name, int number) {
		this.name = name;
		if (number > 0) {
			this.number = number;
		}else {
			this.number = 0;
		}
	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(int number) {
		this.number = (number < 0) ? 0:number;
	}
	public String getName() {
		return name;
	}
	public int getNumber() {
		return number;
	}

}
