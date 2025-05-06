package retailhub;

/**
 * Represents an employee in the system
 * Extends the abstract user class and adds specific employee related fields
 */
public class Employee extends User {

    // FIELDS ONLY FOR EMPLOYEE
    private String name;
    private String lastName;
    private int userId; // unique employee ID
    private static int id = 1;
    private int userId; //   ============ NA MPEI STATIC =============
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
     * @param userId        ID of employee
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
        this.name = name;
        this.lastName = lastName;
        this.userId = id++;
        this.salary = salary;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    // --- Υλοποίηση Abstract Μεθόδων της User ---
    // Returns the name of the employee
    @Override
    public String getName() {
        return this.name;
    }

    // Η getUsername() υλοποιείται πλέον στην User και επιστρέφει το πεδίο username.

    // --- GETTERS and SETTERS for Employee FIELDS ---

    // Μπορείς να κάνεις override το getName() αν η abstract δεν σε καλύπτει
    // @Override public String getName() { return this.name; }

    //METHODS FOR NAME

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }

    // Συνήθως το ID δεν αλλάζει, οπότε δεν βάζουμε setter. Αν χρειάζεται, πρόσθεσέ τον.
    // public void setUserId(int userId) { this.userId = userId; }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        // TODO: Ίσως έλεγχος δικαιωμάτων και εδώ; Ή μόνο στην updateUser της UserList.
        this.salary = salary;
    }

    //METHODS FOR EMAIL

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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


    // --- Override άλλων μεθόδων (π.χ., printUser) ---

    @Override
    public void printUser() {
        // Call the basic print of User
        super.printUser();
        // Πρόσθεσε την εκτύπωση των πεδίων του Employee
        //System.out.println("--- Employee Details ---");
        System.out.println("Full Name: " + this.name + " " + this.lastName);
        System.out.println("User ID: " + this.userId);
        System.out.println("Role: " + this.role);
        System.out.println("Email: " + this.email);
        System.out.println("Address: " + this.address);
        System.out.println("Salary: " + this.salary); // Ίσως να μην θέλεις να τυπώνεται πάντα
        System.out.println("----------------------");
    }

    // Μπορείς να προσθέσεις κι άλλες μεθόδους ειδικές για τον Employee εδώ.

}