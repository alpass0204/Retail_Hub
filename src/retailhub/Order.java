package retailhub;

import java.time.LocalDate;
import java.time.LocalTime;


public class Order {
	private ArrayList<Product> orderProducts;
	private int idOrder;
	private LocalDate date;
    private LocalTime time;
	private PaymentMethod paymentMethod;
	private double total;
	private Supplier s;
	
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
	public Order(Supplier s,String paymentMethod,double total) {
		this.idOrder = idOrder;
		this.paymentMethod = paymentMethod;
		this.total = 0;
	}
	
	public double totalOrderValue() {
		for (OrderItem i: orderProducts) {
			
		}
	}
	
	/*
	 * PRINT METHOD FOR EACH ORDER
	 */
	public void printOrder() {
		System.out.println("Order ID: " + idOrder + "\n" + "Customer: " + customer "\nDate: " + date + "Time: " + "Payment method: " + paymentMethod);
		System.out.println(orderProducts);
		System.out.println("Total: " + total);
		
	}
	
	
}
