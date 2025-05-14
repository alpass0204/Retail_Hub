package retailhub;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage a list of Customer
 * Operations: add, search, update, remove, print
 */

public class CustomerList {

	// FIELDS

	private final ArrayList<Customer> customers; //List of all customer

	private static final SecurityLayer viewCustomer = SecurityLayer.layer1;
	private static final SecurityLayer manageCustomer = SecurityLayer.layer2; // CRUD


	/**
	 * Constructor initializing the list of customers
	 */
	public CustomerList() {
		this.customers = new ArrayList<Customer>();
	}

	/**
	 * Returns the list of customers
	 */

	public ArrayList<Customer> getAllCustomers(User performingUser) throws SecurityException{
		// check for invalid user type
		if (performingUser.equals(null)){
			throw new SecurityException("Performing user can't be NULL.");
		}
		// check for permisions
		if(!performingUser.getSecurityLevel().hasRequiredLevel(viewCustomer)){
			throw new SecurityException("You "+performingUser+" Forbidden.");
		}
		return new ArrayList<>(customers); // returns a copy
	}

	/**
	 * Adds a new customer to the list
	 */
	public void addCustomerToList(User performingUser, Customer c) throws SecurityException {
		// check for invalid user type
		if(performingUser == null){
			throw new SecurityException("Performing user can't be NULL.");
		}
		if(c == null){
			throw new SecurityException("Customer cant be NULL.");
		}
		if (!performingUser.getSecurityLevel().hasRequiredLevel(manageCustomer)) {
			throw new SecurityException("You do not have the required permission to perform this operation");
		}
		customers.add(c);
		System.out.println("Customer: "+c+" has been added by "+performingUser);
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

	public Customer createCustomer(User performingUser, String name, String email, String phone, String gender, int age) throws SecurityException {
		if(performingUser == null){ // First check: If performing User = null
			throw new SecurityException("Performing user can't be NULL.");
		}
		if (!performingUser.getSecurityLevel().hasRequiredLevel(manageCustomer)) { //checks if user have the
			throw new SecurityException("Forbidden."); 				   // credentials.
		}
		if(name.trim().isEmpty() || email.trim().isEmpty() && phone.trim().isEmpty()){
			throw new SecurityException("E-mail and Phone cant be NULL");
		}
		if(phone.length() < 10 ){
			throw new IllegalArgumentException("Invalid phone number length");
		}


		boolean foundAndAdded = false; // Adding a flag if duplicate data found

		/**
		 * Check if customer already exists by email or phone
		 */
		for (Customer allreadyCustomer : customers) {
			if (allreadyCustomer.getEmail() != null && allreadyCustomer.getEmail().toLowerCase().trim().equals(email.toLowerCase().trim())) {
				System.out.println("Error. This email is being already is use : "+email+" . E-mail must be unique.");
				foundAndAdded = true; // Duplicated user found and skipped
				break;
			}
			if (allreadyCustomer.getPhone() != null && allreadyCustomer.getPhone().toLowerCase().trim().equals(phone)) {
				System.out.println("Error. This phone is being already is use : "+email+" . Phone must be unique.");
				foundAndAdded = true; // Duplicated user found and skipped
				break;
			}
		}
		/**
		 * If check passes, add new customer.
		 */
		if (!foundAndAdded) {
			Customer newCustomer = new Customer(name, email, phone, gender, age);
			customers.add(newCustomer);
			System.out.println("Customer: " + newCustomer.getName()
					+ " has been added succesfully!");
			return newCustomer;
		}
		return null;
	}

	/**
	 * Finds a customer based on email
	 *
	 * @param email of customer
	 * @return customer if found, otherwise null
	 */
	public Customer getCustomerByEmail(User performingUser, String email) throws SecurityException {

		if (!performingUser.getSecurityLevel().hasRequiredLevel(viewCustomer)) { // Layer1++ can see Customer
			throw new SecurityException("Forbidden");
		}

		if(email.trim().isEmpty() || performingUser == null ){
			throw new SecurityException("Please enter a valid email or Performing User.");
		}


		for (Customer c : customers) {

			if (c.getEmail().trim().equalsIgnoreCase(email.trim())) {
				return c;
			}

		}
		System.out.println("Customer with email "+email+" not found.");
		return null;

	}

	/**
	 * Finds a customer based on phone
	 *
	 * @param phone customer
	 * @return Customer if found , otherwise null
	 */

	public Customer getCustomerByPhone(User performingUser, String phone) throws SecurityException {

		if (!performingUser.getSecurityLevel().hasRequiredLevel(viewCustomer)) { // Layer1++ can see Customer
			throw new SecurityException("Forbidden");
		}

		if(phone.trim().isEmpty() || performingUser.equals(null)){
			throw new SecurityException("Please enter a valid phone or Performing User.");
		}


		for (Customer c : customers) {
			if (c.getPhone().trim().equalsIgnoreCase(phone.trim())) {
				return c;
			}
		}

		System.out.println("Customer with phone "+phone+" not found.");
		return null;
	}

	/**
	 * Removes a customer from the list using their email address
	 *
	 * @param customer
	 */

	public void removeCustomer(User performingUser, Customer customer) throws SecurityException {
		if (!performingUser.getSecurityLevel().hasRequiredLevel(manageCustomer)) { //credentials check
			throw new SecurityException("Forbidden");
		}

		customers.remove(customer);
		System.out.println("The customer " + customer.getName() + " has been removed!");

	}

	/**
	 * Updates the customer info using their email as q unique identifier
	 *
	 * @param name          New name
	 * @param email         used to identify the customer
	 * @param phone         New phone
	 * @param gender        New gender
	 * @param age           New age
	 * @return TRUE if customer is found and updated, FALSE otherwise
	 */
	public boolean updateCustomer(User performingUser,String emailToFindAndUpdate, String name, String email, String phone, String gender, int age) {
		if (!performingUser.getSecurityLevel().hasRequiredLevel(manageCustomer)) { // credentials check
			throw new SecurityException("Forbidden.");
		}
		Customer customerToUpdate = null;
		for (Customer c : customers) {
			if (c.getEmail().trim().equalsIgnoreCase(emailToFindAndUpdate.trim())) {
				customerToUpdate = c;
				break;
			}
		}
			if (customerToUpdate != null) {
				customerToUpdate.setName(name);
				customerToUpdate.setPhone(phone);
				customerToUpdate.setEmail(email);
				customerToUpdate.setAge(age);
				customerToUpdate.setGender(gender);
				System.out.println("Customer with email "+ emailToFindAndUpdate + " has been updated successfully.");
				return true;
			} else {

				System.out.println("This customer does not exist. Please enter a valid E-mail!");
				return false;
			}
		}



	// Prints all customers in the list

	public void printList(User performingUser) {
		if (!performingUser.getSecurityLevel().hasRequiredLevel(viewCustomer)) {
			throw new SecurityException("Forbidden.");}
			for (Customer c : customers) {
				c.printCustomer();
				System.out.println("=====================");
			}
		}
	}





