package retailhub;

/**
 * Represents a security level in the system with associated permissions.
 * Security levels are hierarchical, with higher levels having all permissions of lower levels.
 */
public class SecurityLevel {
    // The Security Layer (1, 2, 3, or 4)
    private SecurityLayer layer;

    /**
     * 4 Security Layers
     */
    public enum SecurityLayer {
        layer1,  // Basic access (view products, basic searches)
        layer2,  // Standard operations (update non-critical fields, manage inventory)
        layer3,  // Advanced operations (pricing changes, manage users)
        layer4   // Administrative operations (system configuration, security management)
    }

    /**
     * Constructor for SecurityLevel with validation
     * @param layer The security layer to assign
     * @throws SecurityException if the layer is null
     */
    public SecurityLevel(SecurityLayer layer) {
        if (layer == null) {
            throw new SecurityException("The Security Level must be a Valid Choice.");
        }
        this.layer = layer;
    }

    /**
     * Gets the current security layer
     * @return The security layer
     */
    public SecurityLayer getLayer() {
        return layer;
    }

    /**
     * Sets a new security layer
     * @param newLayer The new security layer to assign
     * @param adminUser The user attempting to change the security level
     * @throws SecurityException if the admin user doesn't have layer4 privileges
     */
    public void setSecurityLayer(SecurityLayer newLayer, User adminUser) {
        // Only layer4 users can change security levels
        if (adminUser.getSecurityLevel().getLayer() != SecurityLayer.layer4) {
            throw new SecurityException("Only administrators can change security levels.");
        }

        if (newLayer == null) {
            throw new SecurityException("The Security Level must be a Valid Choice.");
        }

        this.layer = newLayer;
        System.out.println("Security layer updated to " + newLayer + " by " + adminUser.getUsername());
    }

    /**
     * Checks if this security level can perform operations requiring a certain minimum level
     * @param requiredLevel The minimum security level required for an operation
     * @return true if this level is sufficient, false otherwise
     */
    public boolean hasRequiredLevel(SecurityLayer requiredLevel) {
        return this.layer.ordinal() >= requiredLevel.ordinal();
    }

    /**
     * Checks if a user can update another user's information
     * @param userPerformer The user attempting to make changes
     * @param targetUser The user being modified
     * @return true if the operation is allowed, false otherwise
     */
    public boolean canUpdateUser(User userPerformer, User targetUser) {
        if (userPerformer == null || targetUser == null) {
            return false;
        }

        // Get security levels
        SecurityLayer performerLevel = userPerformer.getSecurityLevel().getLayer();
        SecurityLayer targetLevel = targetUser.getSecurityLevel().getLayer();

        // Rules:
        // 1. Any user can view their own information
        // 2. Layer3+ users can update users at their level or below
        // 3. Layer4 users can update any user

        // Same user - always allowed to view own information
        if (userPerformer.getUsername().equals(targetUser.getUsername())) {
            return true;
        }

        // Layer4 can update anyone
        if (performerLevel == SecurityLayer.layer4) {
            return true;
        }

        // Layer3 can update layer3 or below
        if (performerLevel == SecurityLayer.layer3 &&
                targetLevel.ordinal() <= performerLevel.ordinal()) {
            return true;
        }

        // Default deny
        return false;
    }

    /**
     * Checks if a user can manage products (create, update, delete)
     * @param userPerformer The user attempting to manage products
     * @param isCriticalOperation Whether this is a critical operation (price changes, deletion)
     * @return true if the operation is allowed, false otherwise
     */
    public boolean canManageProducts(User userPerformer, boolean isCriticalOperation) {
        if (userPerformer == null) {
            return false;
        }

        SecurityLayer performerLevel = userPerformer.getSecurityLevel().getLayer();

        // Non-critical operations (update name, category, stock) - Layer2+
        if (!isCriticalOperation) {
            return performerLevel.ordinal() >= SecurityLayer.layer2.ordinal();
        }

        // Critical operations (price changes, deletion) - Layer3+
        return performerLevel.ordinal() >= SecurityLayer.layer3.ordinal();
    }

    /**
     * Prints the current security level
     */
    public void printSecurityLevel() {
        System.out.println("Security Layer: " + layer);
    }

    /**
     * String representation of the security level
     */
    @Override
    public String toString() {
        return "SecurityLevel: " + layer;
    }
}