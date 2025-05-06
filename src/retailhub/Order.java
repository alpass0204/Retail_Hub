package retailhub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Represents an order placed to a supplier
 * Includes products, payment method, total cost, data, time, ID
 */

public class Order {

	// FIELDS

	private ArrayList<OrderItem> items; // List of items included in the order
	private int orderId; // Unique order ID
	private LocalDate date = LocalDate.now(); // Order Date
	private LocalTime time = LocalTime.now(); // Order Time
	private PaymentMethod paymentMethod; // Payment method used for the order
	private double total; // Total cost of the order
	private Supplier supplier; // Supplier to whom the order is made

	//ENUM gives available payment methods for orders

	public enum PaymentMethod{
		cash,
		creditCard,
		debitCard,
		transfer,
		mobilePay
	}

	// CONSTRUCTOR

	/**
	 * CONSTRUCTOR FOR ORDER
	 * @param orderId Unique ID for the order
	 * @param supplier Supplier associated with the order
	 * @param items List of order items
	 * @param paymentMethod Method of payment
	 */

	public Order(int orderId, Supplier supplier, ArrayList<OrderItem> items, PaymentMethod paymentMethod) {
		this.orderId = orderId;
		this.items = new ArrayList<OrderItem>(items);
		this.paymentMethod = paymentMethod;
		this.total = 0; // Calculated with totalOrderValue
	}

	// METHODS


	/**
	 * Calculates total value of the order based on all items
	 * @return Total order cost
	 */

	public double totalOrderValue() {
		double sum = 0;
		for (OrderItem i: items) {
			sum += i.getPurchaseOrderLineTotal(); // unit price * quantity
		}
		this.total = sum;
		return this.total;
	}

	/**
	 * Adds an item to order and updates stock accordingly
	 * @param i OrderItem to add
	 */
	
	public void addOrderItem(OrderItem i) {
		items.add(i);
		i.getProduct().increaseStock(i.getQuantity()); // Update product stock when receiving items
	}
		
	/*
	 * PRINT METHOD FOR EACH ORDER
	 
	public void printOrder() {
		System.out.println("Order ID: " + orderId + "\n" + "Date: " + date + "Time: " + time + "Payment method: " + paymentMethod);
		System.out.println(items);
		System.out.println("Total: " + total);
	}
	*/

	//METHODS FOR ITEMS

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}

	//METHOS FOR ORDERID

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	//METHODS FOR DATE & TIME

	public String getDate() {
		return LocalDate.now().toString();
	}

	public String getTime() {
		return LocalTime.now().toString();
	}

	//METHOS FOR PAYMENT METHOD

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	//METHODS FOR TOTAL

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	//METHODS FOR SUPPLIER

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	// RETURNS string representation of the order

	public String toString() {
		this.total = totalOrderValue(); // Makes sure total is updated
		this.date = LocalDate.now();
		return "Order: " + + orderId + "\n" +" Date: " + date +"\n Products: " + items.toString() +"\n Payment method: " + paymentMethod +"\n total: " + total  + "€";
	}
}
