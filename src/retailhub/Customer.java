package retailhub;

public class Customer {
	private String name;
	private String email;
	private String phone;
	private String gender;
	private int age;
	private int loyaltyPoints;
	
	//*BASIKOS KATASKEYASTIS
	
	public Customer(String name, String email, String phone, String gender, int age) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.loyaltyPoints = 0;
	}
	
	//*DEYTEROS KATASKEYASTHS
	//*ISWS VALOUME KAI KATI AKOMA???
	
	public Customer(String name) {
		this.name = name;
		this.loyaltyPoints = 0;
/*		this.email = "n/a" etc
 * 		
 */
	}
	
	//*SETTERS KAI GETTERS
	
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
		System.out.print("Customer's name: " + name);
		if (!email.equals(null)) {								//***GIA NA MHN VGAZEI ERROR AN EINAI NULL H O,TI... MPOREI KAI NA EINAI LATHOS***//
			System.out.print("Customer's email: "+ email);		//**ISWS EINAI KALUTERA NA ARXIKOPOIHSOUME TIS TIMES STON DEYTERO KATASKEYASTI
		}
		if (!phone.equals(null)) {
			System.out.print("Customer's phone: " + phone);
		}
		if (!gender.equals(null)) {
			System.out.print("Gender: " + gender);
		}
		if (age != null) {
			System.out.print("Age: " + age);
		}
		System.out.println("Loyalty points: " + loyaltyPoints);
	}
}