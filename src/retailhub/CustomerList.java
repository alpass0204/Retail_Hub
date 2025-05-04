package retailhub;

import java.util.ArrayList;

public class CustomerList {
	
	private ArrayList<Customer> customers;
	
	public CustomerList() {
		this.customers = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}
	
	public void addCustomerToList(Customer c) {
		customers.add(c);
	}
	
	public boolean createCustomer(String customerId, String name, String email, String phone, String gender, int age, int loyaltyPoints) {
		if(getCustomerById(customerId) != null) {
			 System.out.println("A customer with this ID already exists.");
		     return false;
		}
		
		Customer c = new Customer(customerId,name,email,phone,gender,age,0);
		customers.add(c);
		return true;
	}
	
	public Customer getCustomerById(String customerId) {
		for(Customer c:customers) {
			if(c.getCustomerId().equals(customerId)) {
				return c;
			}
			
		}
		System.out.println("Customer not found");
		return null;
	}
	
	public void removeCustomer(String customerId) {
		Customer c = getCustomerById(customerId);
		if(c!= null) {
			customers.remove(c);
			System.out.println("The customer with ID "+c.getCustomerId()+" has been removed!");
		}
		else {
	    	System.out.println("No such VAT exists. Please try again.");
	    }
		
	}
	
	public boolean updateCustomer(String customerId, String name, String email, String phone, String gender,int age, int loyaltyPoints) {
	    for (Customer c : customers) {
	        if (c.getCustomerId().equals(customerId)) {
	            c.setName(name);
	            c.setPhone(phone); 
	            c.setEmail(email);
	            c.setAge(age);
	            c.setLoyaltyPoints(loyaltyPoints);    
	            return true;
	        }
	    }
	    System.out.println("This customer does not exist. Please enter a valid ID!");
	    return false;
	}
	
	public void printList() {
		for(Customer c: customers) {
			c.printCustomer();
		}
	}
	
	



}
=======
package retailhub;

import java.util.ArrayList;

