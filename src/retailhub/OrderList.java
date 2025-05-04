package retailhub;

import java.util.ArrayList;

public class OrderList {
	private ArrayList<Order> orderlist;

	//Constructor
	public OrderList() {
		this.orderlist = new ArrayList<>();
	}

	//Νέα παραγγελία
	public void addOrderToList(Order order) {
		orderlist.add(order);
	}

	//Εκτυπώνει ολες τις παραγγελίες
	public void printAllOrders() {
		if (orderlist.isEmpty()) {
			System.out.println("No orders have been made yet.");
		} else {
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

	//Removes an order from list
	public void removeOrderFromList(int orderId) {
		Order orderToRemove = null;
		for (Order order : orderlist) {
			if (order.getOrderId() == orderId) {
				orderToRemove = order; // Found the order with the matching orderId
				break;
			}
		}

		if (orderToRemove != null) {
			orderlist.remove(orderToRemove);  // Remove the order from the list
			System.out.println("Order with ID " + orderId + " has been removed.");
		} else {
			System.out.println("No order found with ID " + orderId + ".");
		}
	}

	public void updateOrder(int orderId, Order.PaymentMethod newPaymentMethod) {
		for (Order order : orderlist) {
			if (order.getOrderId() == orderId) {
				order.getDate();
				order.getTime();
				System.out.println("New payment method: " + newPaymentMethod.toString());
				order.setPaymentMethod(newPaymentMethod);
				System.out.println("Order with ID " + orderId + " has been updated.");
				return;  // Exit the method after updating the order
			}
		}

		// If no sale is found with the given orderId
		System.out.println("No order found with ID " + orderId + ".");
	}
}
