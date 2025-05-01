package retailhub;

public abstract class User {

    private String username;
    private String password;
    private SecurityLevel securityLevel;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }



    public void createUser(String username, String password,
                           SecurityLevel securityLevel){
        System.out.println("You Username should be your Last Name followed by youd Id");

    }

    public abstract String getUsername();

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public abstract String getName();

    public SecurityLevel getSecurityLevel(){
        return securityLevel;
    }



}
