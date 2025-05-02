package retailhub;

import java.util.ArrayList;

public class Sales {
	private String sales_id;
	private String date;
	private Employee employee;
	private double totalamount;
	private ArrayList<SaleItem> items;
	private PaymentMethod paymentMethod;
	
	public enum PaymentMethod{
		CASH,
		CREDIT_CARD,
		DEBIT_CARD,
		TRANSFER,
		MOBILE_PAY
		
	}
	
	public Sales(String sales_id, String date, Employee employee, ArrayList<SaleItem> items, PaymentMethod paymentMethod) {
		
		this.sales_id = sales_id;
		this.date = date;
		this.employee = employee;
		this.items = new ArrayList<SaleItem>(items);
		this.paymentMethod = paymentMethod;
		sumTotal();
	}

	public String getSales_id() {
		return sales_id;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getTotalamount() {
		return totalamount;
	}


	public ArrayList<SaleItem> getItemsSold() {
		return items;
	}

	/**public void setProductsSold(ArrayList<Product> productsSold) {
		this.productsSold = productsSold;
	}**/
	
	//method with which we access the whole list of sold products and we add each product's price to sum
	public void sumTotal() {
		double sum = 0;
		for(SaleItem i:items) {
			sum = sum + i.getLineTotal();
		}
		this.totalamount = sum;
		
	}
	
	public void addItem(SaleItem i) {	
		items.add(i);
		sumTotal();
	}
	
	//remove product only when this products exists
	public void removeItem(SaleItem item) {
	    if (items.remove(item)) {
	        sumTotal(); 
	    }
	    
	}
	
	public String receipt() {
	    // At first we have the header
	    String receipt = 
	          "=== RECEIPT ===\n"
	        + "Sale ID: " + sales_id + "\n"
	        + "Date   : " + date + "\n"
	        + "Employee   : " + employee.getName() + " " + employee.getSurname() + "\n"
	        + "Items  :\n";
	    
	    // 2) Add each product to the receipt
	    for (SaleItem i : items) {
	        receipt +=  "  - " + i.getName() + " x" + i.getQuantity() + " @ " + i.getPrice() + "\n";
	    }
	    
	    // 3) Payment method and total amount 
	    receipt += 
	          "Payment: " + paymentMethod + "\n"
	        + "-----------------\n"
	        + "TOTAL  : " + totalamount + "\n";
	    
	    return receipt;
	}
	
	public String toString() {
		return "Sale{" +
	               "idSale='" + sales_id + '\'' +
	               ", date=" + date +
	               ", employee=" + employee +
	               ", products=" + items +
	               ", paymentMethod='" + paymentMethod + '\'' +
	               ", total=" + totalamount +
	               '}';
	}
}