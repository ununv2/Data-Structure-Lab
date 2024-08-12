package logic;

public class OrderItem {
	private Item item;
	private int itemAmount;
	
	public OrderItem(Item item, int itemAmount) {
		this.item = item;
		if(itemAmount < 0) {
			this.itemAmount = 0;
		}else {
			this.itemAmount = itemAmount;
		}
		
	}
	
	public void increaseItemAmount(int amount) {
		if (amount >= 0) {
			this.itemAmount += amount;
		}
	}
	
	public int calculateTotalPrice() {
		return item.getPricePerPiece()*itemAmount;
	}
	
	public void setItemAmount(int itemAmount) {
		if(itemAmount <= 0) {
			this.itemAmount = 0;
		}else {
			this.itemAmount = itemAmount;
		}
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getItemAmount() {
		return itemAmount;
	}
	
	public Item getItem() {
		return item;
	}
	
	
}
