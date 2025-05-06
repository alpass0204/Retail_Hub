package retailhub;
//import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sales {
	private int salesId;
	private LocalDate date = LocalDate.now();
	private LocalTime time = LocalTime.now();
	private double totalamount;
	private ArrayList<SaleItem> items; //the list of sold products per sale
	private PaymentMethod paymentMethod;
	private Customer customer;
	private double discountApplied = 0.0;
	
	public enum PaymentMethod {
		CASH,
		CREDIT_CARD,
		DEBIT_CARD,
		TRANSFER,
		MOBILE_PAY
	}
	
	public Sales(int salesId, ArrayList<SaleItem> items, PaymentMethod paymentMethod, Customer customer) {
		
		this.salesId = salesId;
		this.items = new ArrayList<SaleItem>(items);
		this.paymentMethod = paymentMethod;
		this.customer = customer;
		sumTotal();
		//loyalty points
		if (customer != null) {
			customer.redeemAllPoints(); //redeem to receive the discount
			customer.addPoints(((int) totalamount) / 5); // add point to customer
			customer.printLoyaltyPoints(); // print customer's points
		}
	}

	public int getSalesId() {
		return salesId;
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

	//add sold product and call method sumtotal in order to add the amount in the totalamount
	public void addItem(SaleItem i) {	
		items.add(i);
		sumTotal();
		i.getProduct().decreaseStock(i.getQuantity()); //decrease stock when we make a sale
		i.getProduct().notificationForLowStock();
	}
	
	//remove product only when this products exists
	public void removeItem(SaleItem item) {  //The if statement ensures that sumTotal() is only called if the  SaleItem was actually removed from the items collection.
	    if (items.remove(item)) {
	        sumTotal();
	    }
	}
	
	public String receipt() {
	    // At first we have the header
	    String receipt = 
	          "=== RECEIPT ===\n"
	        + "Sale ID: " + salesId + "\n"
	        + "Date   : " + date + "\n"
			+ "Time   : " + time + "\n"
	        + "Items  : " + items;
	    
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
	               "idSale='" + salesId + '\'' +
	               ", date=" + date +	               
	               ", products=" + items +
	               ", paymentMethod='" + paymentMethod + '\'' +
	               ", total=" + totalamount +
	               '}';
	}
	// The returnItem method
	public void returnItem(SaleItem item) {
		if (items.contains(item)) {
			items.remove(item); // Remove the item from the sale
			totalamount -= item.getLineTotal(); // Subtract the item's price from the total
			item.getProduct().increaseStock(item.getQuantity()); // Return the product to stock
			System.out.println("Product returned: " + item.getProduct().getName());
		} else {
			System.out.println("Item not found in this sale.");
		}
	}



}