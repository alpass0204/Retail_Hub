package retailhub;

public class SaleItem {
		
		private Product product;
		private int quantity;
		
		/*
		 * Constructor
		 */
		public SaleItem(Product product, int quantity) {
			this.product = product;
			this.quantity = quantity;
		}
		
		public String getName() {
	        return product.getName();
	    }

	    public double getPrice() {
	        return product.getSellPrice();
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public double getLineTotal() {
	        return product.getSellPrice() * quantity;
	    }

	}
