package retailhub;

public class Customer {
	private static int id = 1;
	private int customerId;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private int age;
	private int loyaltyPoints;
	
	//*BASIKOS KATASKEYASTIS
	
	public Customer(String name, String email, String phone, String gender, int age) {
		this.customerId = id++;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.loyaltyPoints = 0;
	}
	
	//*DEYTEROS KATASKEYASTHS
	//*ISWS VALOUME KAI KATI AKOMA???
	
	public Customer( String name) {
		this.customerId = id++;
		this.name = name;
		this.loyaltyPoints = 0;
/*		this.email = "n/a" etc
 * 		
 */
	}
	
	//Constructor which loyalty points are given by the user
	public Customer( String name, String email, String phone, String gender, int age, int loyaltyPoints) {
		this.customerId = id++;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.loyaltyPoints = loyaltyPoints;
		
	}

	//*SETTERS KAI GETTERS
	public int getCustomerId() {
        return customerId;
    }
	
	public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
	
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }
	
	public String getEmail() {
        return email;
    }
	
	public void setEmail(String email) {
        this.email = email;
    }
	
	public String getPhone() {
        return phone;
    }
	
	public void setPhone(String phone) {
        this.phone = phone;
    }
	
	public String getGender() {
        return gender;
    }
	
	public void setGender(String gender) {
        this.gender = gender;
    }
	
	public int getAge() {
        return age;
    }
	
	public void setAge(int age) {
        this.age = age;
    }
	
	public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
	
	public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
	
	//**METHODOS PRINT
	  public void printCustomer() {
		  System.out.print("Customer's ID: " + customerId+ "\n");
		  System.out.print("Customer's name: " + name+ "\n");

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

	  //add loyalty points;
	  public void addPoints(int points) {
		  this.loyaltyPoints += points;
		  System.out.println("Add: " + points + " to customer's loyalty profile.");
		  System.out.println("Loyalty points: " + loyaltyPoints);
	  }

	  //redeem customer loyalty points
	  public double redeemAllPoints() {
		  int redeemableSets = this.loyaltyPoints / 100; // for every 100point that customer has
		  if (redeemableSets > 0) {
			  int pointsToRemove = redeemableSets * 100;
			  double discount = redeemableSets * 5.0;
			  this.loyaltyPoints -= pointsToRemove;
			  System.out.println("Customer redeem points: " + pointsToRemove + " real discount: " + discount + "€.");
			  return discount;
		  } else {
			  System.out.println("Δεν υπάρχουν αρκετοί πόντοι για έκπτωση. Απαιτούνται 100.");
			  return 0.0;
		  }
	  }


	//print loyalty points
	public void printLoyaltyPoints() {
		System.out.println("Ο πελάτης έχει " + loyaltyPoints + " πόντους.");
	}



}