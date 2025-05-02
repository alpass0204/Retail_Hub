package retailhub;

public class UserThree extends User{
    private String name;
    private String lastName;
    private int userId;
    private double salary;
    private String email;
    private String address;
    private UserThree.Role role;
    private SecurityLevel layer;

    public enum Role {
        assistantManager,
        manager
    }

    @Override
    public String getUsername(){
        return this.lastName+this.userId;
    }

    public UserThree(String username,String password, String name, String lastName, int userId, double salary, String email,
                     String address, Role role, SecurityLevel layer3) {
        super(username,password);
        this.name = name;
        this.lastName = lastName;
        this.userId = userId;
        this.salary = salary;
        this.email = email;
        this.address = address;
        this.role = role;
        this.layer = layer3;
    }

    // METHODS FOR @name

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    // METHODS FOR @lastName

    public String getLastName() {
        return lastName;
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

    public UserThree.Role getRole(){
        return this.role;
    }

    public void setRole(UserThree.Role newRole){
        this.role = newRole;
    }

    public void setSalary(double newSalary, User user){
        SecurityLevel.SecurityLayer requiredLevel = SecurityLevel.SecurityLayer.layer3;
        if (user.getSecurityLevel().getLayer().ordinal() < requiredLevel.ordinal()) {
            throw new SecurityException("You don't have the permission to finish this Action.");
        }
        else{
            this.salary = newSalary;
            System.out.println("Salary has been changed to: "+newSalary+" from "+user.getUsername());
        }

    }

}
