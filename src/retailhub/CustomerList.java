package retailhub;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage a list of Customer
 * Operations: add, search, update, remove, print
 */

public class CustomerList {

	private ArrayList<Customer> customers; //List of all customer

	/**
	 * Constructor initializing the list of customers
	 */

	public CustomerList() {
		this.customers = new ArrayList<Customer>();
	}

	/**
	 * Returns the list of customers
	 */

	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}

	/**
	 * Adds a new customer to the list
	 */
	public void addCustomerToList(User performingUser, Customer c) throws SecurityException {
		if (!performingUser.getSecurityLevel().getLayer().equals(SecurityLayer.layer1)) {
			throw new SecurityException("You do not have the required permission to perform this operation");
		}
		customers.add(c);
	}

	/**
	 * Creates a new customer and adds them to the list if email or phone is unique
	 *
	 * @param name   Customer name
	 * @param email  Customer email
	 * @param phone  Customer phone
	 * @param gender Customer gender
	 * @param age    Customer age
	 */

	public void createCustomer(User performingUser, String name, String email, String phone, String gender, int age) throws SecurityException {
		if (!performingUser.getSecurityLevel().getLayer().equals(SecurityLayer.layer1)) {
			throw new SecurityException("You do not have the required permission to perform this operation");
		}
		boolean foundAndAdded = false; // Adding a flag if duplicate found
		/**
		 * Check if customer already exists by email or phone
		 */
		for (Customer allreadyCustomer : customers) {
			if (allreadyCustomer.getEmail() != null && allreadyCustomer.getEmail().toLowerCase().trim().equals(email.toLowerCase().trim())) {
				foundAndAdded = true; // Duplicated user found and skipped
				break;
			}
			if (allreadyCustomer.getPhone() != null && allreadyCustomer.getPhone().toLowerCase().trim().equals(phone)) {
				foundAndAdded = true; // Duplicated user found and skipped
				break;
			}
		}
		/**
		 * If no duplicate, add new customer
		 */

		if (!foundAndAdded) {
			Customer newCustomer = new Customer(name, email, phone, gender, age);
			customers.add(newCustomer);
			System.out.println("Customer: " + newCustomer.getName() + " has been added succesfully!");
		}

	}

	/**
	 * Finds a customer based on email
	 *
	 * @param email Customer email
	 * @return customer if found, otherwise null
	 */

	public Customer getCustomerByEmail(User performingUser, String email) throws SecurityException {
		if (!performingUser.getSecurityLevel().getLayer().equals(SecurityLayer.layer1)) {
			throw new SecurityException("You do not have the required permission to perform this operation");
		}
		for (Customer c : customers) {

			if (c.getEmail() == email) {
				return c;
			}

		}
		System.out.println("Customer not found");
		return null;

	}

	/**
	 * Finds a customer based on phone
	 *
	 * @param phone customer
	 * @return Customer if found , otherwise null
	 */

	public Customer getCustomerByPhone(User performingUser, String phone) throws SecurityException {
		if (!performingUser.getSecurityLevel().getLayer().equals(SecurityLayer.layer1)) {
			throw new SecurityException("You do not have the required permission to perform this operation");
		}
		for (Customer c : customers) {

			if (c.getPhone().trim().equals(phone)) {
				return c;
			}

		}
		System.out.println("Customer not found");
		return null;
	}

	/**
	 * Removes a customer from the list using their email address
	 *
	 * @param email of the customer to remove
	 */

	public void removeCustomer(User performingUser, String email) throws SecurityException {
		if (!performingUser.getSecurityLevel().getLayer().equals(SecurityLayer.layer1)) {
			throw new SecurityException("You do not have the required permission to perform this operation");
		}
		Customer c = getCustomerByEmail(performingUser, email);
		if (c != null) {
			customers.remove(c);
			System.out.println("The customer with Email " + getCustomerByEmail(performingUser, email) + " has been removed!");
		} else {
			System.out.println("No such Email exists. Please try again.");
		}

	}

	/**
	 * Updates the customer info using their email as q unique identifier
	 *
	 * @param name          New name
	 * @param email         used to identify the customer
	 * @param phone         New phone
	 * @param gender        New gender
	 * @param age           New age
	 * @param loyaltyPoints New loyalty points
	 * @return TRUE if customer is found and updated, FALSE otherwise
	 */

	public boolean updateCustomer(User performingUser, String name, String email, String phone, String gender, int age, int loyaltyPoints) {
		if (!performingUser.getSecurityLevel().getLayer().equals(SecurityLayer.layer1)) {
			throw new SecurityException("You do not have the required permission to perform this operation");}
			for (Customer c : customers) {
				if (getCustomerByEmail(performingUser, email.toLowerCase()).equals(email.toLowerCase())) {
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


	// Prints all customers in the list

	public void printList(User performingUser) {
		if (!performingUser.getSecurityLevel().getLayer().equals(SecurityLayer.layer1)) {
			throw new SecurityException("You do not have the required permission to perform this operation");}
			for (Customer c : customers) {
				c.printCustomer();
			}
		}
	}





