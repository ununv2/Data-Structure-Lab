package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		orderItemList = new ArrayList<>();
		orderNumber = totalOrderCount;
		totalOrderCount += 1;
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem
		for(OrderItem orderItem : orderItemList) {
			if(orderItem.getItem().getName() == item.getName()) {
				if(amount>=0) {
					orderItem.setItemAmount(orderItem.getItemAmount()+amount);
					return orderItem;
				}else {
					return orderItem;
				}
				
			}
		}
		OrderItem newOrderItem = new OrderItem(item,amount);
		orderItemList.add(newOrderItem);
		return newOrderItem;
	
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int totalPrice = 0;
		for(OrderItem orderItem : orderItemList) {
			totalPrice += orderItem.calculateTotalPrice();
		}
		return totalPrice;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
