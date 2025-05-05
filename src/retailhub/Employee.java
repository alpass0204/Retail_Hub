package retailhub;

/**
 * Συγκεκριμένη κλάση που αναπαριστά έναν υπάλληλο/χρήστη του συστήματος.
 * Κληρονομεί από την User και προσθέτει συγκεκριμένα πεδία υπαλλήλου.
 */
public class Employee extends User {

    // Πεδία ΜΟΝΟ για τον Employee
    private String name;
    private String lastName;
    private int userId; // Θεωρούμε ότι παραμένει μοναδικό ID
    private double salary;
    private String email;
    private String address;
    private Role role; // Χρησιμοποιούμε το enum Role που είχες

    /**
     * Constructor για τη δημιουργία ενός Employee.
     *
     * @param username      Το όνομα χρήστη (για την User).
     * @param password      Ο κωδικός (για την User).
     * @param initialLayer  Το αρχικό SecurityLayer (για την User).
     * @param name          Το όνομα του υπαλλήλου.
     * @param lastName      Το επώνυμο του υπαλλήλου.
     * @param userId        Το ID του υπαλλήλου.
     * @param salary        Ο μισθός.
     * @param email         Το email.
     * @param address       Η διεύθυνση.
     * @param role          Ο ρόλος (από το enum Role).
     */
    public Employee(String username, String password, SecurityLayer initialLayer,
                    String name, String lastName, int userId, double salary, String email,
                    String address, Role role) {

        // 1. Κλήση του constructor της υπερκλάσης User
        super(username, password, initialLayer);

        // 2. Αρχικοποίηση των πεδίων της κλάσης Employee
        this.name = name;
        this.lastName = lastName;
        // TODO: Έλεγχος μοναδικότητας για userId; (Ίσως σε επίπεδο UserList)
        this.userId = userId;
        this.salary = salary;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    // --- Υλοποίηση Abstract Μεθόδων της User ---

    @Override
    public String getName() {
        return this.name;
    }

    // Η getUsername() υλοποιείται πλέον στην User και επιστρέφει το πεδίο username.

    // --- Getters και Setters για τα πεδία του Employee ---

    // Μπορείς να κάνεις override το getName() αν η abstract δεν σε καλύπτει
    // @Override public String getName() { return this.name; }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // --- Override άλλων μεθόδων (π.χ., printUser) ---

    @Override
    public void printUser() {
        // Κάλεσε τη βασική εκτύπωση της User
        super.printUser();
        // Πρόσθεσε την εκτύπωση των πεδίων του Employee
        System.out.println("--- Employee Details ---");
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