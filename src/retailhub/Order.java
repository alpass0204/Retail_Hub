package retailhub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Order {
	private ArrayList<OrderItem> items;
	private int orderId;
	private LocalDate date = LocalDate.now();
	private LocalTime time = LocalTime.now();
	private PaymentMethod paymentMethod;
	private double total;
	private Supplier supplier;
	
	public enum PaymentMethod{
		cash,
		creditCard,
		debitCard,
		transfer,
		mobilePay
	}
	
	/*
	 * CONSTRUCTOR
	 */

	public Order(int orderId, Supplier supplier, ArrayList<OrderItem> items, PaymentMethod paymentMethod) {
		this.orderId = orderId;
		this.items = new ArrayList<OrderItem>(items);
		this.paymentMethod = paymentMethod;
		this.total = 0;
	}
	/*
	 * ypologizei kai kanei return to total****
	 */
	public double totalOrderValue() {
		double sum = 0;
		for (OrderItem i: items) {
			sum += i.getPurchaseOrderLineTotal();	
		}
		this.total = sum;
		return this.total;
	}
	
	/*
	 * VAZEI ENA PRODUCT STIN PARAGGELIA
	 */
	
	public void addOrderItem(OrderItem i) {
		items.add(i);
		i.getProduct().increaseStock(i.getQuantity());
	}
		
	/*
	 * PRINT METHOD FOR EACH ORDER
	 
	public void printOrder() {
		System.out.println("Order ID: " + orderId + "\n" + "Date: " + date + "Time: " + time + "Payment method: " + paymentMethod);
		System.out.println(items);
		System.out.println("Total: " + total);
	}
	*/

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<OrderItem> items) {
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return LocalDate.now().toString();
	}

	public String getTime() {
		return LocalTime.now().toString();
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public String toString() {
		this.total = totalOrderValue();
		this.date = LocalDate.now();
		return "Order: " + + orderId + "\n" +" Date: " + date +"\n Products: " + items.toString() +"\n Payment method: " + paymentMethod +"\n total: " + total  + "€";
	}
}
