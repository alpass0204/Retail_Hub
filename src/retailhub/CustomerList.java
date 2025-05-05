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

	/**
	 *
	 * @param name
	 * @param email
	 * @param phone
	 * @param gender
	 * @param age
	 */
	public void createCustomer(String name, String email, String phone, String gender, int age) {
		boolean foundAndAdded = false; // Adding a flag
		for(Customer allreadyCustomer : customers) {
			if(allreadyCustomer.getEmail() != null && allreadyCustomer.getEmail().toLowerCase().trim().equals(email.toLowerCase().trim())) {
				foundAndAdded = true; // Duplicated user found and skipped
				break;
			}
			if(allreadyCustomer.getPhone()!=null && allreadyCustomer.getPhone().toLowerCase().trim().equals(phone)) {
				foundAndAdded = true; // Duplicated user found and skipped
				break;
			}
		}

		if(!foundAndAdded) {
			Customer newCustomer = new Customer(name,email,phone,gender, age);
			customers.add(newCustomer);
			System.out.println("Customer: "+newCustomer.getName()+" has been added succesfully!" );
		}

	}

	public Customer getCustomerByEmail(String email) {
		for (Customer c : customers) {

			if (c.getEmail() == email) {
				return c;
			}

		}
		System.out.println("Customer not found");
		return null;
	}
	public Customer getCustomerByPhone(String phone) {
		for (Customer c : customers) {

			if (c.getPhone().trim().equals(phone)) {
				return c;
			}

		}
		System.out.println("Customer not found");
		return null;
	}

	public void removeCustomer(String email) {
		Customer c = getCustomerByEmail(email);
		if (c != null) {
			customers.remove(c);
			System.out.println("The customer with Email " + getCustomerByEmail(email) + " has been removed!");
		} else {
			System.out.println("No such Email exists. Please try again.");
		}
	}

	public boolean updateCustomer(String name, String email, String phone, String gender, int age, int loyaltyPoints) {
		for (Customer c : customers) {
			if (getCustomerByEmail(email.toLowerCase()).equals(email.toLowerCase())) {
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