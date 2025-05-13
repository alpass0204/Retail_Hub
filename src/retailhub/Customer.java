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
	private ArrayList<Sales> salesHistory = new ArrayList<>();


	// CONSTRUCTORS

	/**
	 *  First Constructor that gets the follow parameters to create a new Instance of Customer with 4 parameters:
	 * @param name // Of Customer
	 * @param email // Of Customer
	 * @param phone // Of Customer
	 * @param gender // Of Customer
	 * @param age // Of Customer
	 *  The main idea is that Customers can be found by their phone or email which are unique.
	 */
	public Customer(String name, String email, String phone, String gender, int age) {
		if(phone.length() < 10 ){
			throw new IllegalArgumentException("Invalid phone number length");
		}
		if(email.equals(null)){
			throw new IllegalArgumentException("");
		}

		this.customerId = id++;
		this.name = name.trim().toLowerCase();
		this.email = email.trim();
		this.phone = phone.trim();
		this.gender = gender;
		this.age = age;
		this.loyaltyPoints = 0;
	}

	
	//Constructor which loyalty points are given by the user
	public Customer (String name, String email, String phone, String gender,
					 int age, int loyaltyPoints) {
		if(phone.length() < 10 ){
			throw new IllegalArgumentException("Invalid phone number length");
		}
		if(email.equals(null)){
			throw new IllegalArgumentException("");
		}
		this.customerId = id++;
		this.name = name.trim().toLowerCase();
		this.email = email.trim();
		this.phone = phone.trim();
		this.gender = gender;
		this.age = age;
		this.loyaltyPoints = loyaltyPoints;
		
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
	
	public void setName(String newName) {
		if(newName.trim() != null && !newName.trim().isEmpty()){
			this.name = newName;
		}
		else{
			System.err.println("Attempted to set a null name for the customer.");
		}
    }

	// METHODS FOR EMAIL

	public String getEmail() {
        return email;
    }
	
	public void setEmail(String newEmail) {
		if(newEmail.trim() != null && !newEmail.trim().isEmpty()){
			this.email = newEmail;
		}
		else{
			System.err.println("Attempted to set a null email for the customer.");
		}
    }

	//METHODS FOR PHONE

	public String getPhone() {
        return phone;
    }
	
	public void setPhone(String newPhone) {
        if(newPhone.trim() != null && !newPhone.trim().isEmpty()){
			this.phone = newPhone;
		}
		else{
			System.err.println(newPhone+" is an invalid phone number form.");
		}
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
	
	public void setAge(int newAge) {
        if(age > 0 ){
			this.age = newAge;
		}
		else{
			System.err.println(+newAge+" is an Invalid age.");
		}
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
       if(newLoyaltyPoints >= 0) {
		   this.loyaltyPoints = newLoyaltyPoints;
	   }
	   else{
		   System.err.println("Attempted to set negative loyatly points: "+newLoyaltyPoints);
	   }
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
	public void addSale(Sales sale) {
		if (sale != null) {
			salesHistory.add(sale);
		}
	}
	public ArrayList<Sales> getSalesHistory() {return new ArrayList<>(salesHistory);}

	public void addPoints(int earnedPoints) {
		this.loyaltyPoints += earnedPoints;
	}
	}
