package retailhub;

import java.util.ArrayList;

public class OrderList {
	private ArrayList<Order> orderlist;
	
	//Constructor
	public OrderList() {
		this.orderlist = new ArrayList<>();
	}
	
	public void addOrder(Order order) {
		orderlist.add(order);
	}
	
	public void printAllOrders() {
        if (orderlist.isEmpty()) {
            System.out.println("No sales have been made yet.");
        } 
        else {
            for (Order order : orderlist) {
                System.out.println(order.toString());
            }
        }
    }
}
