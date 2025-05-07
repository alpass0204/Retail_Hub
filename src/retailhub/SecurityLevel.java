package retailhub;

/**
 * Represents a security level in the system with associated permissions.
 * Security levels are hierarchical , with higher levels have all
 */

public class SecurityLevel{

    // FIELDS

    private SecurityLayer layer;  // The Security Layer (1,2,3 or 4)

    /**
     * CONSTRUCTOR for Security Level with Validation.
     * @param layer The security layer to assign.
     * @throws SecurityException if the layer is null.
     */
    public SecurityLevel(SecurityLayer layer){
        if(layer==null){
            throw new SecurityException("The Security level must be a Valid Choice.");
        }
        else{
            this.layer = layer;
        }
    }

    /**
     *
     * @return the layer of the SecurityLayer object.
     */
    public SecurityLayer getLayer(){
        return this.layer;
    }
    /**
     *
     * @param newLayer
     * @param adminUser
     */

    public void setSecurityLayer(SecurityLayer newLayer, User adminUser){
        // Main Idea : Users with level4 credentials only can change the SecurityLevel.
        if(adminUser.getSecurityLevel().getLayer() != SecurityLayer.layer4){
            throw new SecurityException("Only Adminstrators can change security levels.");
        }
        if(newLayer == null){
            throw new SecurityException("The Security Level must be a Valid Choice.");
        }
        this.layer = newLayer;
        System.out.println("Security layer updated to "+newLayer+ " by "+adminUser.getUsername());
    }

    /** HAS_REQUIRED_LEVEL
     * CHECKS if this security level can perform operations requiring a certain minimum level
     * @param requiredLevel = The min security level.
     * @return True if the User has the Credentials to perform the wanted Action or False if he doesn't.
     */
    public boolean hasRequiredLevel(SecurityLayer requiredLevel){
        return this.layer.ordinal()>= requiredLevel.ordinal();
    }

    /** CAN_UPDATE_USER
     *  CHECKS if the user has the credentials to handle other Users data
     *  Every User can access his own data
     *  Layer3+ can manage other peoples information (Layer2 and Layer1)
     *  Layer4 is God Mode.
     * @param userPerformer USER
     * @param targetUser   USER
     * @return
     */
    public boolean canUpdateUser(User userPerformer, User targetUser){
        if(userPerformer == null || targetUser == null){
            return false;
        }
        // Get Security levels
        SecurityLayer performersLevel = userPerformer.getSecurityLevel().getLayer();
        SecurityLayer targetsLevel = targetUser.getSecurityLevel().getLayer();

        // Main ideas
        //1) Any user can view their own info.
        //2) Layer3+ can update users at their level or below.
        //3) Layer4 has god mode.

        // Implementation of 1
        if(userPerformer.getUsername().equals(targetUser.getUsername())){
            return true;
        }

        // Implementation of 2
        if(performersLevel == SecurityLayer.layer3 && targetsLevel.ordinal() <= performersLevel.ordinal()){
            return true;
        }

        // Implementation of 3
        if(performersLevel == SecurityLayer.layer4){
            return true;
        }
        // Default Deny
        return false;
    }

    /** CAN_MANAGE_PRODUCTS
     * CHEKCS if user can manage products (create, update, delete)
     * @param performerUser (USER) The User attempting to manage products.
     * @param isCritical  (BOOLEAN) Whether the action trying to operate is Critical/Not Critical
     * @return true if the operation is allowed, false otherwise
     */
    public boolean canManageProducts(User performerUser, boolean isCritical){
        if (performerUser == null){
            return false;
        }
        SecurityLayer performerUserLevel = performerUser.getSecurityLevel().getLayer();
        //Not Critical Layer2+
        if(!isCritical){
            return performerUserLevel.ordinal() >= SecurityLayer.layer2.ordinal();
        }

        // Critical  Layer3+
        return performerUserLevel.ordinal() >= SecurityLayer.layer3.ordinal();
    }

    /**
     * Prints The current Security Layer
     */

    public void printSecurityLevel(){
        System.out.println("SecurityLayer: "+layer);
    }










}