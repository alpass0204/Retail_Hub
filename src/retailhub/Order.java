package retailhub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Order {
	private ArrayList<OrderItem> items;
	private int idOrder;
	private LocalDate date;
    private LocalTime time;
	private PaymentMethod paymentMethod;
	private double total;
	private Supplier supplier;
	
	public enum PaymentMethod{
		cash,
		creditCard,
		debitCard,
		trasfer,
		mobilePay
	}
	
	/*
	 * CONSTRUCTOR
	 */

	public Order(int idOrder, Supplier supplier, ArrayList<OrderItem> items, PaymentMethod paymentMethod) {
		this.idOrder = idOrder;
		this.items = new ArrayList<OrderItem>(items);
		this.paymentMethod = paymentMethod;
		this.total = 0;
	}
	/*
	 * ypologizei kai kanei return to total****
	 */
	public double totalOrderValue() {
		for (OrderItem i: items) {
			this.total += i.getPurchaseOrderLineTotal();	
		}
		return this.total;
	}
	
	/*
	 * VAZEI ENA PRODUCT STIN PARAGGELIA
	 */
	
	public void addOrderItem(OrderItem i) {
		items.add(i);
	}
		
	/*
	 * PRINT METHOD FOR EACH ORDER
	 
	public void printOrder() {
		System.out.println("Order ID: " + idOrder + "\n" + "Date: " + date + "Time: " + time + "Payment method: " + paymentMethod);
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

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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
		return "Order{" +
	               "idOrder='" + idOrder + '\'' +
	               ", date=" + date +	               
	               ", products=" + items.toString() +
	               ", paymentMethod='" + paymentMethod + '\'' +
	               ", total=" + total +
	               '}';
	}
	
	/*
	 * --------PREPEI NA GINEI ENIMEROSI TOU STOCK MESA STIN ORDER----------
	 */
}
