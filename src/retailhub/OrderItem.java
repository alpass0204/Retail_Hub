package retailhub;

public class OrderItem {

	// FIELDS

	private Product p; // The product being ordered
	private int quantity; // Quantity of product
	private static final SecurityLayer manageOrderItem = SecurityLayer.layer3;
	/**
	 *  CONSTRUCTOR for OrderItem
	 * @param p The product being ordered
	 * @param quantity Quantity of the product being ordered
	 */
	public OrderItem(User performerUser,Product p, int quantity) {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageOrderItem)){
			throw new IllegalArgumentException("Forbidden."); // Credentials check
		}
		if(p.equals(null)){ //check if product data entry is empty
			throw new IllegalArgumentException("Forbidden.");
		}
		if(quantity<1){ // The idea is that quantity has to be a real integer number.
			throw new IllegalArgumentException("Quantinty cant be negative or 0.");
		}

		this.quantity = quantity;
		this.p = p;
	}

	// METHODS

	// RETURNS the purchase price per unit of the product
	public double getProductPurchasePrice() {
		return p.getPurchasePrice();
	}

	// RETURNS the name of the product being ordered
	public String getPurchaseProductName() {
        return p.getName();
    }

	//RETURNS the quantity being ordered
    public int getQuantity() {
        return quantity;
    }

	/**
	 * Calculates and returns the total cost of the item
	 * purchase price * quantity
	 * RETURNS Total purchase cost for this line item
	 */
	public double getPurchaseOrderLineTotal() {
        return p.getPurchasePrice() * quantity;
    }

	//RETURNS A summary of the order item

	public String toString() {
		return " " + p.getName() + " : " + this.quantity +" pieces  * "
				+  p.getPurchasePrice() + " €";
	}

	public Product getProduct() {
		return this.p;
	}


}
