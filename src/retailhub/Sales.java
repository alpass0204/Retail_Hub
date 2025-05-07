package retailhub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Shows a sale transaction, with items sold, customer, total amount, payment method
 */

public class Sales {

	// FIELDS

	private int salesId; // Unique salesID
	private LocalDate date = LocalDate.now(); // Date of sale
	private LocalTime time = LocalTime.now(); // Time of sale
	private double totalamount; // Total amount of sale
	private ArrayList<SaleItem> items; //the list of sold products per sale
	private PaymentMethod paymentMethod; // Method of payment used
	private Customer customer; // customer who made the purchase
	//private double discountApplied = 0.0;
	private static final SecurityLayer manageSales = SecurityLayer.layer2;



	public enum PaymentMethod {
		CASH,
		CREDIT_CARD,
		DEBIT_CARD,
		TRANSFER,
		MOBILE_PAY
	}

	/**
	 * CONSTRUCTOR FOR CREATING A SALE TRANSACTION
	 * @param salesId Unique ID of the sale
	 * @param items List of sale items
	 * @param paymentMethod Payment method
	 * @param customer Customer making the purchase
	 */

	public Sales(int salesId, ArrayList<SaleItem> items, PaymentMethod paymentMethod, Customer customer) {

		// validation check

		if(salesId==0){ // Checks if salesId is a valid data entry.
			throw new IllegalArgumentException("Invalid SALES-ID");
		}
		if(paymentMethod.equals(null)){ // payment method check
			throw new IllegalArgumentException("Payment Method can't be null");
		}
		if(customer.equals(null)){
			throw new IllegalArgumentException("Customer cant be null.");
		}

		//loyalty points

		if (customer != null) {
			double discount = customer.redeemAllPoints(); //redeem to receive the discount from points
			customer.addPoints(((int) totalamount) / 5); // add point to customer (1 per 5 euro)			customer.printLoyaltyPoints(); // print customer's points
			this.totalamount -= discount; // apply discount to total
		}

		this.salesId = salesId;
		this.items = new ArrayList<SaleItem>(items);
		this.paymentMethod = paymentMethod;
		this.customer = customer;
		sumTotal(); //Calculate total before discounts

	}


	//GETTERS

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

	//SETTERS

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

	public void addItem(User performerUser,SaleItem i)throws SecurityException {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSales)){
			throw new SecurityException("Forbidden."); // credentials check
		}
		if(i.equals(null)){
			throw new SecurityException("Item cant be null."); // check of items validation
		}
		items.add(i);
		sumTotal();
		i.getProduct().decreaseStock(i.getQuantity()); //decrease stock when we make a sale
		i.getProduct().notificationForLowStock();
	}

	/**
	 * Removes an item from the sale if it exists, updates total
	 * @param item The SaleItem to remove
	 */
	public void removeItem(User performerUser,SaleItem item) {  //The if statement ensures t
																// hat sumTotal() is only called if the  SaleItem was actually removed
															   //from the item's collection.
	    if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSales)){
			throw new SecurityException("Forbidden."); // credentials check
		}
		if(item.equals(null)){
			throw new SecurityException("Item cant be null."); // check of items validation
		}

		if (items.remove(item)) {
	        sumTotal();
	    }
	}
	
	public String receipt(User performerUser) {

		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSales)){
			throw new SecurityException("Forbidden"); // credentials check
		}

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


	/**
	 * Sales Summary
	 * @return
	 */
	public String saleSummary() {
		return "Sale{" +
	               "idSale='" + salesId + '\'' +
	               ", date=" + date +	               
	               ", products=" + items +
	               ", paymentMethod='" + paymentMethod + '\'' +
	               ", total=" + totalamount +
	               '}';
	}

	/**
	 * Removes SalesItem from a single Sale.
	 * @param performerUser
	 * @param item
	 * @throws SecurityException
	 */
	public void returnItem(User performerUser,SaleItem item)throws SecurityException {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSales)){
			throw new SecurityException("Forbidden."); // credentials check
		}

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