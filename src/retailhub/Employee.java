package retailhub;

/**
 * Represents an employee in the system
 * Extends the abstract user class and adds specific employee related fields
 */
public class Employee extends User {

    // FIELDS

    private String name;
    private String lastName;
    private int userId; // unique employee ID
    private static int id = 1;
    private double salary;
    private String email;
    private String address;
    private Role role; // Role of the employee in the company

    /**
     * CONSTRUCTOR FOR CREATING AN EMPLOYEE OBJECT
     *
     * @param username      Username for system login (User class)
     * @param password      Password for system login (User class)
     * @param initialLayer  Security Access Level     (User class)
     * @param name          First name of employee
     * @param lastName      Second name of employee
     * @param salary        Salary of employee
     * @param email         Email address of employee
     * @param address       Address of employee
     * @param role          Role of employee (enum role)
     */
    public Employee(String username, String password,  SecurityLayer initialLayer,
                    String name, String lastName, double salary, String email,
                    String address, Role role) {

        // 1. Call to superclass Constructor User
        super(username, password, initialLayer);

        // 2. Initializing the FIELDS of Employee class
        if(name.equals(null) || lastName.equals(null)){
            throw new IllegalArgumentException("Name can't be NULL");
        }
        if(email.trim().equals(null)){
            throw new IllegalArgumentException("E-mail can't be NULL");
        }


        this.name = name.trim().toLowerCase();
        this.lastName = lastName.trim().toLowerCase();
        this.userId = id++;
        this.salary = salary;
        this.email = email.trim();
        this.address = address.trim().toLowerCase();
        this.role = role;
    }

    //  Abstract Methods
    // Returns the name of the employee
    @Override
    public String getName() {
        return this.name;
    }


    //  GETTERS and SETTERS for Employee FIELDS

    //METHODS FOR NAME

    public void setName(String name) {
        if(name.equals(null)){
            throw new IllegalArgumentException("Name can't be NULL");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.equals(null)){
            throw new IllegalArgumentException("Name can't be NULL");
        }
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 0){
            throw new IllegalArgumentException("Salary cant be Negative.");
        }
    }

    //METHODS FOR EMAIL

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.equals(null)){
            throw new IllegalArgumentException("E-mail cant be NULL");
        }
        this.email = email;
    }

    //METHODS FOR ADDRESS

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //METHODS FOR ROLE

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Prints user and employee specific details
     */




    @Override
    public void printUser() {

        super.printUser();

        System.out.println("--- Employee Details ---");
        System.out.println("Full Name: " + this.name + " " + this.lastName);
        System.out.println("User ID: " + this.userId);
        System.out.println("Role: " + this.role);
        System.out.println("Email: " + this.email);
        System.out.println("Address: " + this.address);
        System.out.println("Salary: " + this.salary);
        System.out.println("----------------------");
    }


}