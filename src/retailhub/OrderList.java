package retailhub;

import java.util.ArrayList;

public class OrderList {
	private ArrayList<Order> orderlist;
	
	//Constructor
	public OrderList() {
		this.orderlist = new ArrayList<>();
	}
	
	//Νέα παραγγελία
	public void addOrder(Order order) {
		orderlist.add(order);
	}
	
	//Εκτυπώνει ολες τις παραγγελίες
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
	
	//Returns the total number of orders
	public int totalOrdersCount() {
		return orderlist.size();
	}
	
	//Calculating total order value
	public double totalOrderListValue() {
		double sum = 0;
		for (Order order : orderlist) {
			sum = sum + order.totalOrderValue();
		}
		return sum;
	}
}
