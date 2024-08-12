package logic;

public class Item {
	private String name;
	private int pricePerPiece;
	
	public Item(String name, int pricePerPiece) {
		this.name = name;
		if(pricePerPiece <= 0){
			this.pricePerPiece = 1;
		}else {
			this.pricePerPiece = pricePerPiece;
		}	
	}
	
	public void setPricePerPiece(int pricePerPiece) {
		if(pricePerPiece <= 0){
			this.pricePerPiece = 1;
		}else {
			this.pricePerPiece = pricePerPiece;
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPricePerPiece() {
		return pricePerPiece;
	}
	
	public String getName() {
		return name;
	}
	

}
