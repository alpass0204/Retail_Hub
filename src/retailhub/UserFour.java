package retailhub;

public class UserFour extends User{
    private String name;
    private String lastname;
    private int userId;
    private double salary;
    private String email;
    private String address;
    private UserFour.Role role;
    private SecurityLevel layer;

    public enum Role {
        director
    }

    public UserFour(String username, String name, String lastname, int userId, double salary, String email,
                    String address, Role role, SecurityLevel layer4) {
        super(username);
        this.name = name;
        this.lastname = lastname;
        this.userId = userId;
        this.salary = salary;
        this.email = email;
        this.address = address;
        this.role = role;
        this.layer = layer4;
    }

    // METHODS FOR @name

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    // METHODS FOR @lastName

    public void setLastname(String newLastname) {
        this.lastname = newLastname;
    }

    public String getLastname() {
        return lastname;
    }

    // METHODS FOR @userId with no setter method, 1 unique ID per User

    public int getUserId() {
        return userId;
    }

    // METHODS FOR @salary

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }

    // METHODS FOR @email

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getEmail() {
        return email;
    }

    // METHODS FOR @address

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public String getAddress() {
        return address;
    }

    // Methods for @Role

    public UserFour.Role getRole(){
        return this.role;
    }

    public void setRole(UserFour.Role newRole){
        this.role = newRole;
    }

}