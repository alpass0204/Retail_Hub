package retailhub;

public class SecurityLevel {

    // The Security Level eg 1,2,3,4
    private int securityLevel;

    /*
    * Constructor for SecurityLevel with check for valid SecurityLevel and throw error if not.
    */
    public SecurityLevel(int securityLevel) {
        if(securityLevel>=1 && securityLevel<=4){
            this.securityLevel = securityLevel;
        }
        else{
            System.err.println();
        }
    }
    /*
    * Setter method to Set the SecurityLevel between 1&4 with check for err
     */
    public void setSecurityLevel(int level){
        if(level >= 1 && level <=4){
            this.securityLevel = level;
        }
    }
    public int getSecurityLevel(){
        return this.securityLevel;
    }



}
