package retailhub;

public class UserOne extends User {
    private String name;
    private String lastName;
    private int userId;
    private double salary;
    private String email;
    private String address;
    private UserOne.Role role;
    private SecurityLevel layer;

    public enum Role {
        analyst,
        accountant,
        salesPerson
    }

    public UserOne(String username,String name,String lastName,int userId,double salary,String email,
                   String address,Role role, SecurityLevel layer1){
    super(username);
    this.name = name;
    this.lastName = lastName;
    this.userId = userId;
    this.salary = salary;
    this.email = email;
    this.address = address;
    this.role = role;
    this.layer = layer1;
    }

    // METHODS FOR @name

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    // METHODS FOR @lastName

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    // METHODS FOR @userId with no setter method, 1 unique ID per User

    public int getUserId(){
        return this.userId;
    }

    // METHODS FOR @salary

    public double getSalary(){
        return this.salary;
    }

    public void setSalary(double newSalary){
        this.salary = newSalary;
    }

    // METHODS FOR @email

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    // METHODS FOR @address

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    // Methods for @Role

    public Role getRole(){
        return this.role;
    }

    public void setRole(Role newRole){
        this.role = newRole;
    }

}
