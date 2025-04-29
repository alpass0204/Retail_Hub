package retailhub;

import java.util.ArrayList;

public class Supplier {

	private String taxId;
	private String brandName;
	private String address;
	private String phone;
	private String email;
	private boolean isActive;
	private ArrayList<Product> products;

	/**
	 * Constructor για Suppliers
	 * @param taxId
	 * @param brandName
	 * @param address
	 * @param phone
	 * @param email
	 */
	public Supplier(String taxId, String brandName, String address, String phone, String email, Boolean active) {
		this.taxId = taxId;
		this.brandName = brandName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.isActive = true;
		this.products = new ArrayList<>();
	}

	public void addProduct(Product product){
		if (!products.contains(product)) {
			this.products.add(product);
			product.setSupplier(this);
		}
	}

	public void removeProduct(Product product){
		if (products.contains(product)) {
			this.products.remove(product);
			product.setSupplier(null);
		}
	}
	public Product getProduct(Product products){
		return products;
	}


	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void printSupplier() {
		System.out.println("TaxID: "+taxId+" BrandName: "+brandName+" Address: "+address+" E-mail: "+email+
				phone+" Status:"+isActive);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
}
