package retailhub;

import java.util.ArrayList; // Χρειάζεται για το workHours

/**
 * Αφηρημένη κλάση βάσης για όλους τους χρήστες του συστήματος.
 * Περιέχει τα βασικά στοιχεία ταυτοποίησης και ασφάλειας.
 */
public abstract class User {

    private String username; // Μοναδικό όνομα χρήστη
    private String password; // Κωδικός πρόσβασης (Σημείωση: Σε πραγματικό σύστημα θα ήταν hashed)
    private SecurityLevel securityLevel; // Το επίπεδο ασφαλείας (ΕΝΑ πεδίο εδώ)
    private ArrayList<Object> workHours; // Λίστα για ώρες εργασίας (Ο τύπος Object είναι γενικός, μπορείς να τον αλλάξεις)

    /**
     * Constructor για τη βασική κλάση User.
     * @param username Το όνομα χρήστη.
     * @param password Ο κωδικός πρόσβασης.
     * @param initialLayer Το αρχικό επίπεδο ασφαλείας (enum SecurityLayer).
     */
    public User(String username, String password, SecurityLayer initialLayer) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        if (initialLayer == null) {
            throw new IllegalArgumentException("Initial SecurityLayer cannot be null.");
        }

        this.username = username.trim(); // Αφαίρεση κενών αρχής/τέλους
        this.password = password;
        this.workHours = new ArrayList<>(); // Αρχικοποίηση λίστας
        // Δημιουργία του SecurityLevel αντικειμένου εδώ, με βάση το layer
        this.securityLevel = new SecurityLevel(initialLayer);
    }

    // --- Getters ---

    /**
     * Επιστρέφει το όνομα χρήστη.
     * @return το username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Επιστρέφει τον (μη κρυπτογραφημένο) κωδικό πρόσβασης.
     * @return τον κωδικό πρόσβασης.
     */
    public String getPassword() {
        // Σημείωση: Η επιστροφή του password έτσι δεν είναι ασφαλής πρακτική.
        // Συνήθως θα είχαμε μέθοδο checkPassword(String attempt).
        return password;
    }

    /**
     * Επιστρέφει το αντικείμενο SecurityLevel του χρήστη.
     * @return το SecurityLevel.
     */
    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    /**
     * Επιστρέφει τη λίστα ωρών εργασίας.
     * @return ArrayList για τις ώρες εργασίας.
     */
    public ArrayList<Object> getWorkHours() {
        return workHours;
        // Σημείωση: Η επιστροφή της λίστας απευθείας επιτρέπει εξωτερική τροποποίηση.
        // Καλύτερα: return new ArrayList<>(workHours); ή παροχή μεθόδων add/remove workHour.
    }


    // --- Setters ---

    /**
     * Ορίζει έναν νέο κωδικό πρόσβασης.
     * @param newPassword Ο νέος κωδικός.
     */
    public void setPassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
            System.err.println("Warning: Attempted to set an empty password for user " + this.username);
            // ή throw new IllegalArgumentException("Password cannot be empty.");
            return;
        }
        this.password = newPassword;
    }

    /**
     * Ορίζει ένα νέο επίπεδο ασφαλείας.
     * Σημείωση: Ο έλεγχος δικαιωμάτων για το *ποιος* μπορεί να καλέσει αυτή τη μέθοδο
     * πρέπει να γίνεται *πριν* την κλήση της (π.χ., στην UserList.updateUser).
     * @param securityLevel Το νέο αντικείμενο SecurityLevel.
     */
    public void setSecurityLevel(SecurityLevel securityLevel) {
        if (securityLevel == null) {
            throw new IllegalArgumentException("SecurityLevel cannot be null.");
        }
        this.securityLevel = securityLevel;
    }

    /**
     * Ορίζει ένα νέο username.
     * ΠΡΟΣΟΧΗ: Αν το username είναι κλειδί σε λίστες, αυτή η αλλαγή
     * μπορεί να προκαλέσει προβλήματα αν δεν γίνει σωστή διαχείριση.
     * @param newUsername Το νέο username.
     */
    public void setUsername(String newUsername) {
        if (newUsername == null || newUsername.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        // Εδώ θα χρειαζόταν έλεγχος μοναδικότητας αν καλείται αφού ο χρήστης είναι σε λίστα
        this.username = newUsername.trim();
    }

    // --- Abstract Methods ---

    /**
     * Αφηρημένη μέθοδος για τη λήψη του κύριου ονόματος του χρήστη (π.χ. "Γιώργος").
     * Πρέπει να υλοποιηθεί από τις υποκλάσεις.
     * @return το όνομα.
     */
    public abstract String getName();

    // --- Other Methods ---

    /**
     * Εκτυπώνει βασικές πληροφορίες του χρήστη. Μπορεί να γίνει override από υποκλάσεις.
     */
    public void printUser() {
        System.out.println("--- User Info ---");
        System.out.println("Username: " + this.username);
        // System.out.println("Password: [Protected]"); // Καλύτερα να μην τυπώνουμε τον κωδικό
        if (this.securityLevel != null) {
            System.out.println("Security Level: " + this.securityLevel.getLayer());
        } else {
            System.out.println("Security Level: Not Set");
        }
        // Δεν τυπώνουμε όλη τη λίστα workHours εδώ συνήθως
        System.out.println("-----------------");
    }

    /**
     * Ελέγχει αν αυτός ο χρήστης μπορεί να ενημερώσει έναν άλλο χρήστη.
     * Απλά καλεί την αντίστοιχη μέθοδο του SecurityLevel.
     * @param targetUser Ο χρήστης που πρόκειται να ενημερωθεί.
     * @return true αν επιτρέπεται, false αλλιώς.
     */
    public boolean canUpdateUser(User targetUser) {
        // Ο έλεγχος γίνεται από το SecurityLevel αυτού του χρήστη ('this')
        if (this.securityLevel == null) return false; // Ασφάλεια αν δεν έχει οριστεί επίπεδο
        return this.securityLevel.canUpdateUser(this, targetUser);
    }

    // Θα μπορούσες να προσθέσεις και άλλες μεθόδους can[Action] εδώ,
    // καλώντας τις αντίστοιχες του securityLevel αντικειμένου.
    public boolean canManageProducts(boolean isCritical) {
        if (this.securityLevel == null) return false;
        return this.securityLevel.canManageProducts(this, isCritical);
    }

}