package retailhub;

import java.util.ArrayList;

/**
 * Manages a list of orders made to suppliers
 * Provides methods to add, remove, update, calculate costs
 */

public class OrderList {

	// FIELDS

	private static final SecurityLayer viewOrder = SecurityLayer.layer1;
	private static final SecurityLayer manageOrder = SecurityLayer.layer2;
	private ArrayList<Order> orderlist; // List of all orders

	// CONSTRUCTOR OrderList

	public OrderList() {
		this.orderlist = new ArrayList<>();
	}

	/**
	 * Adds a new order to the list
	 * @param order The order to be added
	 */

	public void addOrderToList(Order order) {
		orderlist.add(order);
	}

	/**
	 * Prints all orders in the list
	 * If list is empty, shows message to user
	 */

	public void printAllOrders(User performerUser) {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(viewOrder)){
			throw new IllegalArgumentException("Forbidden."); // Credentials check
		}

		if (orderlist.isEmpty()) {
			System.out.println("No orders have been made yet.");
		} else {
			for (Order order : orderlist) {
				System.out.println(order.toString());
			}
		}
	}

	//Returns the total number of orders
	public int totalOrdersCount(User performerUser) {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(viewOrder)){
			throw new IllegalArgumentException("Forbidden."); // Credentials check
		}

		return orderlist.size();
	}

	//Returns the total value of all orders

	public double totalOrderListValue(User performerUser) {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(viewOrder)){
			throw new IllegalArgumentException("Forbidden."); // Credentials check
		}

		double sum = 0;
		for (Order order : orderlist) {
			sum = sum + order.totalOrderValue();
		}
		return sum;
	}

	/**
	 * Removes an order from the list based on its ID
	 * @param orderId The ID of the order to be removed
	 */
	public void removeOrderFromList(User performerUser,int orderId) {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageOrder)){
			throw new IllegalArgumentException("Forbidden."); // Credentials check
		}
		if(orderId==0){
			throw new IllegalArgumentException("Order-ID cant be 0."); //check for invalid orderId
		}																// or 0 value.


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

	/**
	 * Updates the payment method of an order from its ID
	 * @param orderId The ID of the order
	 * @param newPaymentMethod New payment method to apply
	 */
	public void updateOrder(User performingUser,int orderId,
							Order.PaymentMethod newPaymentMethod) {
		if(!performingUser.getSecurityLevel().hasRequiredLevel(manageOrder)){
			throw new IllegalArgumentException("Forbidden.");
		}
		if(orderId == 0){
			throw new IllegalArgumentException("Order-ID cant be 0.");
		}

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

	//total expenses for products coming in
	public double getTotalPurchaseCost(User performerUser) {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageOrder)){
			throw new IllegalArgumentException("Forbidden.");
		}

		double total = 0;
		for (Order order : orderlist) {
			total += order.totalOrderValue();
		}
		return total;
	}
}
