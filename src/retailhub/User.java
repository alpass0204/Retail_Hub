package retailhub;

public abstract class User {

    private String username;
    private String password;
    protected SecurityLevel securityLevel;

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public abstract String getName();

    public SecurityLevel getSecurityLevel(){
        return securityLevel;
    }



}
