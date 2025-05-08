package retailhub;

public class SaleItem {


	private static final SecurityLayer manageSaleItem = SecurityLayer.layer3;
		private Product product; // The product being sold
		private int quantity; // Quantity of product sold

	/**
	 * CONSTRUCTOR for SaleItem
	 * @param product the product sold
	 * @param quantity the quantity sold
	 */
	public SaleItem(User performingUser,Product product, int quantity) {
		if(!performingUser.getSecurityLevel().hasRequiredLevel(manageSaleItem)){
			throw new IllegalArgumentException("Forbidden."); // credentials check
		}
		if(product == null){ // Products not null check
			throw new IllegalArgumentException("Product cant be null.");
		}
		if(quantity < 1){ // valid form of quantity variable.
			throw new IllegalArgumentException("Quantity has to be a real integer.");
		}
			this.product = product;
			this.quantity = quantity;
		}

		//RETURN name of the sold product

		public String getName() {
	        return product.getName();
	    }

        //RETURN selling price per unit

	    public double getPrice() {
	        return product.getSellPrice();
	    }

		//RETURN Quantity sold

	    public int getQuantity() {
	        return quantity;
	    }

		//calculate total amount of price * quantity

	    public double getLineTotal() {
	        return product.getSellPrice() * quantity;
	    }

		//RETURN the product associated with the sale item

		public Product getProduct() {
			return this.product;
		}

	@Override
	public String toString() {
		return "SaleItem{" +
				"product=" + product +
				", quantity=" + quantity +
				' ';
	}
}

