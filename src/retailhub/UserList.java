package retailhub;

import java.util.ArrayList;
import java.util.Iterator;


public class UserList {

    private ArrayList<User> userList;

    public UserList() {

        this.userList = new ArrayList<User>();
    }

    /**
     * Method for adding a new User.
     * @param user
     * @return
     */
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
     * Method for searching a user by his Username in a ArrayList<User>
     * @param usernameToSearch
     * @return Users Information through printUser() method
     */
    public void searchUser(String usernameToSearch) {
        for (User user : userList) { // Απλή επανάληψη στη λίστα
            if (user.getUsername().equals(usernameToSearch)) {
                System.out.println("User found:");
                user.printUser();
                return;
            }
        }
        System.out.println("User not found: " + usernameToSearch);
    }


    /**
     * Emergency method to find user via their username.
     * @param username
     * @return
     */
    public User findUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * A method that removes a user
     * @param userToDelete
     * @return message if removed or not
     */
    public void removeUser(String userToDelete){
        Iterator<User> iterator = userList.iterator();
        boolean foundAndRemoved = false;
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getUsername().equals(userToDelete)){
                iterator.remove();
                System.out.println("The user : "+userToDelete+" has been removed Successfully!");
                foundAndRemoved = true;
                break;
            }
            if(!foundAndRemoved){
            System.out.println("User: "+userToDelete+" is not found!");
            }
        }
    }

    /**
     * Method for printing all the objects(users) in a Arraylist<User>
     */
    public void printList() {
        for (User user : userList) {
            user.printUser();
        }
    }


    /**
     * Method for Updating users data.
     * The Security Credentials are being checked inside the method.
     * @param performingUser     // The user that's trying the operation.(User)
     * @param usernameToUpdate   // new username(String)
     * @param passwordToUpdate   // new password(String)
     * @param nameToUpdate      // new name(String)
     * @param userIdToUpdate     // new userId(Int)
     * @param salaryToUpdate    // new gross salary
     * @param emailToUpdate     // new email(String)
     * @param addressToUpdate   // new address(String)
     * @param roleToUpdate      // new role(Role)
     * @param newSecurityLevel  // new SecurityLevel(SecuirtyLevel)
     * @return
     */
    public boolean updateUser(User performingUser, String usernameToUpdate,
                              String passwordToUpdate, String nameToUpdate,
                              int userIdToUpdate, double salaryToUpdate,
                              String emailToUpdate, String addressToUpdate,
                              Role roleToUpdate, SecurityLevel newSecurityLevel) {

        User targetUser = findUser(usernameToUpdate);

        if (targetUser == null) {
            System.out.println("Action failed. User: " + usernameToUpdate + " not found.");
            return false;
        }

        // 1) CHECK FOR CREDENTIALS TO UPDATE
        //  We use the method canUpdateUser from SecurityLevel for the performingUser

        if (!performingUser.getSecurityLevel().canUpdateUser(performingUser, targetUser)) {
            System.out.println("Permission Denied: User " + performingUser.getUsername() +
                    " cannot update user " + targetUser.getUsername());
            return false; // Έξοδος αν δεν υπάρχει δικαίωμα
        }



        // 2) Only layer 4 can change others Security Level.

        boolean levelChanging = !targetUser.getSecurityLevel().getLayer().equals(newSecurityLevel.getLayer());
        if (levelChanging && performingUser.getSecurityLevel().getLayer() != SecurityLayer.layer4) {
            System.out.println("Permission Denied: Only Administrators (Layer 4) can change security levels.");
            return false;
        }

        // If checks are being passed, user can continue to Update other data
        targetUser.setPassword(passwordToUpdate);
        if (levelChanging) { //Change level if only user has permission
            targetUser.setSecurityLevel(newSecurityLevel);
        } else if (!levelChanging) {

            // We suppose that if User don't have the rights to change Security level then he wont
            // reach these fields.
        }


        boolean updatedSpecifics = false; // flag
        // (setName, setUserId, setSalary ..)
        //  the instanceof checks and updates

        // prints Success message
        if(updatedSpecifics){
            System.out.println("User " + usernameToUpdate + " updated successfully by " + performingUser.getUsername());
        } else if (targetUser instanceof User) { // Πάντα θα είναι true αν βρέθηκε
            System.out.println("User " + usernameToUpdate + " common fields updated by " + performingUser.getUsername()
                    +". Specific type fields possibly not updated if type mismatch in instanceof checks.");
        }

        return true;
    }


    /**
     * Calculates the Total Salaries spend
     * @return
     */
    public double getTotalSalaryExpenses() {
        double sal = 0;
        for (User user : userList) {
            if (user instanceof Employee) {
                sal += ((Employee) user).getSalary();
            }
        }
        System.out.println("Total Salary Expenses: €" + sal);
        return sal;
    }
}







