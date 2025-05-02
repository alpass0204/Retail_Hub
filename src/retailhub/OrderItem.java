
public class OrderItem {
	private Product p;
	int quantity;
	
	public OrderItem(Product p, int quantity) {
		this.quantity = quantity;
		this.p = p;
	}
	
	public double getProductPurchasePrice() {
		return p.getPurchasePrice();
	}
	
	public String getPurchaseProductName() {
        return p.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPurchaseOrderLineTotal() {
        return p.getProductPurchasePrice() * quantity;
    }
}
