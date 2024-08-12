package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		switch(this.type) {
		//Student 30 Baht
		case 0:
			priceperstation = 30;
			break;
		//Adult 30 Baht
		case 1:
			priceperstation = 30;
			break;
		//Elder 25 Baht
		case 2:
			priceperstation = 25;
			break;
		
		}
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		if(type >=0 && type <= 2) {
			this.type = type;
		}else {
			this.type = 1;
		}
	}
	
	public void setStation(Station start,Station end) {
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		//getStationDistance
		int distance = getStationDistance(start,end);
		double totalprice;
		getPricePerStation();
		if(isStationValid(start,end)) {
			//Student 30 Baht, 20% Discount if 4+ Stations
			switch(type) {
			case 0:
				totalprice = distance*priceperstation;
				if (distance>4) {
					totalprice = totalprice/100*80;
					return totalprice;
				}
				
				return totalprice;
				
			//Adult 30 Baht
			case 1:
				totalprice = distance*priceperstation;
				return totalprice;
			//Elder 25 Baht, 40% Discount, cannot 6+ stations
			case 2:
				totalprice = (distance*priceperstation)/100*60;
				return totalprice;
			
			default:
				return -1;
			}
		}
		return -1;
	}
	
	public String getDescription() {
		String typename;
		
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			typename = "Adult";
			break;
		case 2:
			typename = "Elderly";
			break;
		default:
			typename = "Invalid";
		}
		//TYPE ticket, from A to B
		if (isStationValid(start,end)) {
			return typename+" Ticket, from "+start.getName()+" to "+end.getName();
		}
		return "Invalid Ticket, from "+start.getName()+" to "+end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
