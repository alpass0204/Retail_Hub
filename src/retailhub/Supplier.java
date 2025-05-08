package retailhub;

import java.util.ArrayList;

public class Supplier {

	private final int taxId;
	private String brandName;
	private String address;
	private String phone;
	private String email;
	private boolean isActive;
	private final ArrayList<Product> products;

	/**
	 * Constructor για Suppliers
	 * @param brandName
	 * @param address
	 * @param phone
	 * @param email
	 */
	public Supplier(int taxId, String brandName, String address, String phone, String email, Boolean active) {
		if(brandName.equals(null)){
			throw new IllegalArgumentException("Brand-Name cant be NULL");
		}
		if(taxId == 0){

			throw new IllegalArgumentException("Tax id can't be empty.");
		}
		if(phone.length() < 10 ){
			throw new IllegalArgumentException("Invalid phone number length");
		}
		if(email.equals(null)){
			throw new IllegalArgumentException("E-mail cant be NULL");
		}
		this.taxId = taxId;
		this.brandName = brandName.trim().toLowerCase();
		this.address = address.trim().toLowerCase();
		this.phone = phone.trim();
		this.email = email;
		this.isActive = true;
		this.products = new ArrayList<>();
	}

	/**
	 * GETTER FOR PRODUCTS STORED IN SUPPLIER'S PRODUCT LIST
	 * @return
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * METHOD FOR ADDING PRODUCT FROM SUPPLIER'S PRODUCT LIST
	 * @param product
	 */
	public void addProduct(Product product){
		if (!products.contains(product)) {
			this.products.add(product);
			product.setSupplier(this);
		}
	}

	/**
	 * METHOD FOR REMOVING SUPPLIER'S PRODUCT LIST
	 * @param product
	 */
	public void removeProduct(Product product){
		if (products.contains(product)) {
			this.products.remove(product);
			product.setSupplier(null);
		}
	}

	//SETTER AND GETTERS FOR SUPPLIERS FIELDS

	//METHODS FOR taxId

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		if(taxId == 0 ){

		}
	}

	//METHODS FOR brandName

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	//METHODS FOR address

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//METHODS FOR phone

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//METHODS FOR email

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

	/**
	 * METHOD FOR PRINTING SUPPLIER INFO
	 */
	public void printSupplier() {
		System.out.println("TaxID: "+taxId+" BrandName: "+brandName+" Address: "
				+address+" E-mail: "+email+
				phone+" Status:"+isActive);
	}


}
