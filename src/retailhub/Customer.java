package retailhub;

import java.util.ArrayList;

/**
 * Represents a customer in the System
 * Each customer has a unique id, personal info , loyalty points
 */
public class Customer {

	// FIELDS

	private static int id = 1; // Customers Int which for every customer adds 1
	private int customerId; // The variable that stores the static id
	private String name;  // Customers name
	private String email; // Customers email
	private String phone; // Customers phone
	private String gender; // Customers gender
	private int age; // Customers age
	private int loyaltyPoints; // The variable that stores the loyalty points
	private ArrayList<Sales> salesOfCustomer;


	// CONSTRUCTORS

	/**
	 *  First Constructor that gets the follow parameters to create a new Instance of Customer with 4 parameters:
	 * @param name // Of Customer
	 * @param email // Of Customer
	 * @param phone // Of Customer
	 * @param gender // Of Customer
	 * @param age // Of Customer
	 */
	public Customer(String name, String email, String phone, String gender, int age) {
		this.customerId = id++;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.loyaltyPoints = 0;
	}

	/**
	 * Second Constructor that creates a new instance of Customer with 1 parameter:
	 * @param name
	 */
	public Customer(String name) {
		this.customerId = id++;
		this.name = name;
		this.loyaltyPoints = 0;
/*		this.email = "n/a" etc
 * 		
 */
	}
	
	//Constructor which loyalty points are given by the user
	public Customer (String name, String email, String phone, String gender, int age, int loyaltyPoints) {
		this.customerId = id++;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.loyaltyPoints = 0;
		
	}

	// GETTERS AND SETTERS
	//---------------------------------------------

	// METHODS FOR CUSTOMER ID

	public int getCustomerId() {
        return customerId;
    }
	
	public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

	// METHODS FOR NAME

	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }

	// METHODS FOR EMAIL
	
	public String getEmail() {
        return email;
    }
	
	public void setEmail(String email) {
        this.email = email;
    }

	//METHODS FOR PHONE
	
	public String getPhone() {
        return phone;
    }
	
	public void setPhone(String phone) {
        this.phone = phone;
    }

	//METHODS FOR GENDER
	
	public String getGender() {
        return gender;
    }
	
	public void setGender(String gender) {
        this.gender = gender;
    }

	//METHODS FOR AGE
	
	public int getAge() {
        return age;
    }
	
	public void setAge(int age) {
        this.age = age;
    }

	//METHODS FOR LOYALTY POINTS
	
	public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

	/**
	 * Initializing loyaltyPoints with int
	 * @param newLoyaltyPoints
	 */
	public void setLoyaltyPoints(int newLoyaltyPoints) {
        this.loyaltyPoints = newLoyaltyPoints;
    }
	
	//Prints all customer information
	  public void printCustomer() {
		  System.out.print("Customer's ID: " + customerId+ "\n");
		  System.out.print("Customer's name: " + name+ "\n");
		//Checks for null or bad written fields in a Customer instance
		  if (email != null && !email.isEmpty()) {
			  System.out.print("Customer's email: " + email+ "\n");
		  }
		  if (phone != null && !phone.isEmpty()) {
			  System.out.print("Customer's phone: " + phone+ "\n");
		  }
		  if (gender != null && !gender.isEmpty()) {
			  System.out.print("Gender: " + gender+ "\n");
		  }
		  if (age != 0) {
			  System.out.print("Age: " + age+ "\n");
		  }
		  System.out.println("Loyalty points: " + loyaltyPoints+ "\n");
	  }

	/**
	 * add loyalty points to the customer
	 * @param newPoints
	 */
	public void addPoints(int newPoints) {
		  this.loyaltyPoints += newPoints;
		  System.out.println("Add: " + newPoints + " to customer's loyalty profile.");
		  System.out.println("Loyalty points: " + loyaltyPoints);
	  }

	/**
	 * Redeems loyalty points and provides discount
	 * For every 100 points, customer gets 5 euro discount
	 */
	  public double redeemAllPoints() {
		  int redeemableSets = this.loyaltyPoints / 100; // for every 100point that customer has
		  if (redeemableSets > 0) {
			  int pointsToRemove = redeemableSets * 100;
			  double discount = redeemableSets * 5.0;
			  this.loyaltyPoints -= pointsToRemove;
			  System.out.println("Customer redeem points: " + pointsToRemove + " real discount: " + discount + "€.");
			  return discount;
		  }
		  else {
			  System.out.println("Δεν υπάρχουν αρκετοί πόντοι για έκπτωση. Απαιτούνται 100.");
			  return 0.0;
		  }
	  }

	//prints current loyalty points of customer
	public void printLoyaltyPoints() {
		System.out.println("Ο πελάτης έχει " + loyaltyPoints + " πόντους.");
	}
}