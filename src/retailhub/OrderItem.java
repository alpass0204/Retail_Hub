package retailhub;

public class OrderItem {
	private Product p; // The product being ordered
	private int quantity; // Quantity of product

	/**
	 *  CONSTRUCTOR for OrderItem
	 * @param p The product being ordered
	 * @param quantity Quantity of the product being ordered
	 */
	public OrderItem(Product p, int quantity) {
		this.quantity = quantity;
		this.p = p;
	}

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
