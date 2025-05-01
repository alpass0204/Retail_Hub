package retailhub;

public class SecurityLevel{

    // The Security Layer eg 1,2,3,4
    private SecurityLayer layer;

    public enum SecurityLayer{
        layer1,
        layer2,
        layer3,
        layer4
    }
    /*
    * Constructor for SecurityLevel with check for valid SecurityLevel and throw error if not.
    */
    public SecurityLevel(SecurityLayer layer) {
        if (layer == null) {
            throw new IllegalArgumentException("The Security Level must be a Valid Choice.");
        }
        else {
            this.layer = layer;
        }

    }

    public SecurityLayer getLayer(){
        return layer;
    }


    public void printSecurityLevel() {
        System.out.println("Layer: " + layer);
    }
}
