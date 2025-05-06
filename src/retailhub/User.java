package retailhub;

import java.util.ArrayList;

/**
 * Abstract Class for all system users.
 * Contains all the basis elements for authentication and security
 */
public abstract class User {

    private String username; // UNIQUE username
    private String password; // User's Password
    private SecurityLevel securityLevel; // Security Level
    private ArrayList<Object> workHours; // User's hours worked.

    /**
     * Constructor
     * @param username unique username
     * @param password password
     * @param initialLayer the initial security layer (enum SecurityLayer).
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

        this.username = username.trim(); // removes unwanted spaces
        this.password = password;
        this.workHours = new ArrayList<>(); // initial list
        // Creation of Security Level object based on the 4 Security Layers
        this.securityLevel = new SecurityLevel(initialLayer);
    }

    //  GETTERS

    /**
     *
     * @return το username.
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return the password
     */
    public String getPassword() {

        return password;
    }

    /**
     * returns the object Security Level
     * @return the SecurityLevel.
     */
    public SecurityLevel getSecurityLevel() {
        return securityLevel;
    }

    /**
     * Returning the list of working hours.
     * @return ArrayList for working hours.
     */
    public ArrayList<Object> getWorkHours() {
        return workHours;
    }


    //  SETTERS

    /**
     * Defines a new password
     * @param newPassword the new password
     */
    public void setPassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
                throw new IllegalArgumentException("Failed to change password, please Try Again!");
        }
        this.password = newPassword;
    }

    /**
     * The credential's check should be investigated before this method get called.
     * e.g. UserList.udateUser
     * @param securityLevel The new object SecurityLayer.
     */
    public void setSecurityLevel(SecurityLevel securityLevel) {
        if (securityLevel == null) {
            throw new IllegalArgumentException("SecurityLevel cannot be null.");
        }
        this.securityLevel = securityLevel;
    }

    /**
     * Sets a new Username
     * @param newUsername Το νέο username.
     */
    public void setUsername(String newUsername) {
        if (newUsername == null || newUsername.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
        this.username = newUsername.trim();
    }

    // --- Abstract Methods ---

    /**
     * Abstract method for getting User's first name.
     * @return name.
     */
    public abstract String getName();

    //  OTHER METHODS

    /**
     * Prints basic information of the user. It can be overrided from the subclasses.
     */
    public void printUser() {
        //System.out.println("--- USER INFO ---");
       //System.out.println("Username: " + this.username);
        if (this.securityLevel != null) {
            //System.out.println("Security Level: " + this.securityLevel.getLayer());
        }
        else {
            //System.out.println("Security Level: Not Set");
        }
        //System.out.println("-----------------");
        System.out.println("--- Employee Details ---");
        System.out.println("username: " + this.username);
        System.out.println("password: " + "*************");
    }

    /**
     * Checks if this user can update another user.
     * It calls the canUpdateUser from SecurityLevel
     * @param targetUser The targeted user for updates.
     * @return True if the performer User has the credentials, false if not
     */
    public boolean canUpdateUser(User targetUser) {
        // The check is being implemented by this user ('this')
        if (this.securityLevel == null) {    //Small security check
            return false;
        }

        return this.securityLevel.canUpdateUser(this, targetUser);
    }

    /**
     * Calling a method from SecurityLevel for the securityLevel object.
     * @param isCritical if the operation is critical or not
     * @return true if after the check the user can Manage the Products, false if not.
     */
    public boolean canManageProducts(boolean isCritical) {
        if (this.securityLevel == null) return false;
        return this.securityLevel.canManageProducts(this, isCritical);
    }

}