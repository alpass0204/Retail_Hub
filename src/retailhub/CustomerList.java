package retailhub;

import java.util.ArrayList;
import java.util.Iterator;

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

	public void createCustomer(int customerId, String name, String email,
								  String phone, String gender, int age, int loyaltyPoints) {
		Iterator<Customer> iterator = customers.iterator();
		boolean foundAndAdded = false; // Adding a flag
		while (iterator.hasNext()) {
			Customer c = iterator.next();
			if(c.getCustomerId() == customerId) {
				System.out.println("Customer " + customerId + " already exists.");
				break;
			}
		}
		if(!foundAndAdded) {
			Customer c = new Customer(customerId, name, email, phone, gender, age, loyaltyPoints);
			customers.add(c);
		}
	}

	public Customer getCustomerById(int customerId) {
		for (Customer c : customers) {

			if (c.getCustomerId() == (customerId)) {
				return c;
			}

		}
		System.out.println("Customer not found");
		return null;
	}

	public void removeCustomer(int customerId) {
		Customer c = getCustomerById(customerId);
		if (c != null) {
			customers.remove(c);
			System.out.println("The customer with ID " + c.getCustomerId() + " has been removed!");
		} else {
			System.out.println("No such VAT exists. Please try again.");
		}

	}

	public boolean updateCustomer(int customerId, String name, String email, String phone, String gender, int age, int loyaltyPoints) {
		for (Customer c : customers) {
			if (c.getCustomerId() == (customerId)) {
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
		for (Customer c : customers) {
			c.printCustomer();
		}
	}
}
	




