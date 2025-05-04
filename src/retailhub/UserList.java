package retailhub;

import java.util.ArrayList;
import java.util.Iterator;


public class UserList {
    private ArrayList<User> userList;

    public UserList() {
        this.userList = new ArrayList<User>();
    }

    // Create User to the list.

    public boolean addUser(User user) {
        if (findUser(user.getUsername()) != null) {
            throw new IllegalArgumentException("You must create a Unique username! ");
        } else {
            userList.add(user);
            //System.out.println("User: " + user.printUser() + " has been created!");
            return true;
        }
    }

    /**
     * Searching User
     */

    public void searchUser(String usernameToSearch) { // <-- Νέα υπογραφή
        for (User currentUser : userList) { // Απλή επανάληψη στη λίστα
            if (currentUser.getUsername().equals(usernameToSearch)) {
                System.out.println("User found:");
                currentUser.printUser(); // <-- Καλούμε την διορθωμένη printUser
                return; // Βρέθηκε ο χρήστης, τελειώνει η μέθοδος
            }
        }
        // Η επανάληψη τελείωσε και ο χρήστης δεν βρέθηκε
        System.out.println("User not found: " + usernameToSearch);
    }

    public User findUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean removeUser(String usernameToDelete, int UserIdToDelete) {
        User targetUser = findUser(usernameToDelete);

        if (targetUser == null) {
            System.out.println("Action failed.\n User: " + usernameToDelete + " not found.");
            return false;
        } else {
            userList.remove(targetUser);
            System.out.println("User: " + usernameToDelete + " has been deleted!");
            return true;
        }
    }

    public void printList() {
        for (User user : userList) {
            user.printUser();
        }
    }

    public boolean updateUser(User performingUser, // <-- ΠΡΟΣΘΗΚΗ: Ποιος κάνει την αλλαγή;
                              String usernameToUpdate, String passwordToUpdate, String nameToUpdate,
                              int userIdToUpdate, double salaryToUpdate,
                              String emailToUpdate, String addressToUpdate, Role roleToUpdate, SecurityLevel newSecurityLevel) {

        User targetUser = findUser(usernameToUpdate);

        if (targetUser == null) {
            System.out.println("Action failed. User: " + usernameToUpdate + " not found.");
            return false;
        }

        // ---> 1. ΕΛΕΓΧΟΣ ΔΙΚΑΙΩΜΑΤΩΝ ΕΝΗΜΕΡΩΣΗΣ <---
        // Χρησιμοποιούμε την canUpdateUser της SecurityLevel του performingUser
        if (!performingUser.getSecurityLevel().canUpdateUser(performingUser, targetUser)) {
            System.out.println("Permission Denied: User " + performingUser.getUsername() +
                    " cannot update user " + targetUser.getUsername());
            return false; // Έξοδος αν δεν υπάρχει δικαίωμα
        }

        // ---> 2. ΠΡΟΑΙΡΕΤΙΚΟΣ ΕΛΕΓΧΟΣ: Αλλαγή Security Level <---
        // Μόνο ο Layer 4 μπορεί να αλλάξει Security Level άλλου (ή και του εαυτού του)
        // Έλεγξε αν το επίπεδο όντως αλλάζει
        boolean levelChanging = !targetUser.getSecurityLevel().getLayer().equals(newSecurityLevel.getLayer());
        if (levelChanging && performingUser.getSecurityLevel().getLayer() != SecurityLayer.layer4) {
            System.out.println("Permission Denied: Only Administrators (Layer 4) can change security levels.");
            // Μπορείς είτε να απορρίψεις όλη την ενημέρωση (return false)
            // είτε να επιτρέψεις τις άλλες αλλαγές αλλά όχι του security level
            // (πιο απλό είναι να το απορρίψεις εδώ)
            return false;
        }

        // Αν οι έλεγχοι περάσουν, συνέχισε με τις ενημερώσεις:
        targetUser.setPassword(passwordToUpdate);
        if (levelChanging) { // Άλλαξε το level μόνο αν επιτρέπεται (ή αν δεν άλλαζε מלכתחילה)
            targetUser.setSecurityLevel(newSecurityLevel);
        } else if (!levelChanging) {
            // Αν προσπαθούσε να αλλάξει επίπεδο χωρίς δικαίωμα, αλλά τα υπόλοιπα πεδία
            // θέλουμε να ενημερωθούν, δεν κάνουμε τίποτα εδώ για το SecurityLevel.
            // Αν όμως η προηγούμενη συνθήκη έκανε 'return false', δεν φτάνουμε ποτέ εδώ.
            // Εξαρτάται πώς θα χειριστείς την αποτυχία αλλαγής επιπέδου.
            // Ας υποθέσουμε ότι αν δεν έχει δικαίωμα να αλλάξει level, δεν γίνεται καμία αλλαγή.
        }


        boolean updatedSpecifics = false;
        // ... οι instanceof έλεγχοι και οι υπόλοιπες ενημερώσεις ...
        // (setName, setUserId, setSalary κλπ)

        // ... εκτύπωση μηνύματος επιτυχίας ...
        if(updatedSpecifics){ // Ίσως να θες να αλλάξεις τη λογική εδώ
            System.out.println("User " + usernameToUpdate + " updated successfully by " + performingUser.getUsername());
        } else if (targetUser instanceof User) { // Πάντα θα είναι true αν βρέθηκε
            System.out.println("User " + usernameToUpdate + " common fields updated by " + performingUser.getUsername() +". Specific type fields possibly not updated if type mismatch in instanceof checks.");
        }

        return true;
    }
}







