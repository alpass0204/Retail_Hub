
package retailhub;

import java.util.ArrayList;

/**
 * Manages a list of suppliers for the retail system
 * You can add, update, print the suppliers
 */

public class SupplierList {

	// FIELDS

	private ArrayList<Supplier> suppliers; // List of all suppliers
	private static final SecurityLayer viewSupplier = SecurityLayer.layer1;
	private static final SecurityLayer manageSupplier = SecurityLayer.layer2;

	/**
	 * CONSTRUCTOR initializing the supplier list
	 */
	public SupplierList() {
		this.suppliers = new ArrayList<Supplier>();
	}


	// FIELDS


	/**
	 * Adds a supplier to the list
	 * @param s Supplier to be added
	 */
	public void addSupplier(Supplier s,User performerUser)throws SecurityException {
		if(performerUser.getSecurityLevel().hasRequiredLevel(manageSupplier)){
			throw new SecurityException("Forbidden."); // credentials check
		}
		if(s.equals(null)){ // checks suppliers existence
			throw new SecurityException("Supplier has to be initialized before added to list");
		}
		suppliers.add(s);
	}
	
	/**
	 * Creating a supplier and adding it to the list
	 * @param taxId Suppliers VAT number
	 * @param brandName
	 * @param phone
	 * @param address
	 * @param email
	 * @return TRUE if supplier was found, FALSER otherwise
	 */
	public boolean createSupplier(User performingUser,
								  int taxId, String brandName,
								  String phone, String address,
								  String email) throws SecurityException {
		if(performingUser.equals(null)) { // First check: If performing User = null
			throw new SecurityException("Performing user can't be NULL");
		}
		if(!performingUser.getSecurityLevel().hasRequiredLevel(manageSupplier)){
			throw new SecurityException("Forbidden."); // Credentials check
		}

		if(taxId == 0 && brandName.trim().toLowerCase().equals(null) ||
		brandName.trim().toLowerCase().isEmpty()){ // Brand Name and Tax-Id not null values check
			throw new SecurityException("Tax-Id And Brand Name can't be NULLS");
		}
		
		Supplier s = new Supplier(taxId, brandName, address, phone, email,true);
		suppliers.add(s);
		return true;
	}

		
	/**
	 * Remove supplier if VAT already exists
	 * @param taxId
	 */
	public void removeSupplier(String taxId) {

	   
	}

	/**
	 * Search supplier based on VAT. If it is  found, we call set methods to change data
	 * @param taxId
	 * @param brandName
	 * @param phone
	 * @param address
	 * @param email
	 * @return
	 */
	public boolean updateSupplier(int taxId, String brandName, String phone, String address, String email) {
	    for (Supplier s : suppliers) {
	        if (s.getTaxId() == (taxId)) {
	            s.setBrandName(brandName);
	            s.setPhone(phone);
	            s.setAddress(address);
	            s.setEmail(email);
	            return true;
	        }
	    }
	    System.out.println("This supplier does not exist. Please enter a valid VAT!");
	    return false; //we need to create an exception error ( try-catch-final )
	}



	/**
	 * PRINTS all suppliers in the list
	 */
	public void printList() {
		for(Supplier i: suppliers) {
			i.printSupplier();
		}
	}
	/**
	 * Check if a VAT number already exists in Suppliers List
	 * @param taxId
	 * @return
	 */
	/*public boolean vatExists(String taxId) {
	    for (Supplier s : suppliers) {
	        if (s.getTaxId() == (taxId)) {
	            return true;
	        }
	    }
	    return false;
	}
	*/
	
	/**
	 * Check and return supplier based on its VAT
	 * @param taxId
	 * @return
	 */
	/*public Supplier getSupplierByVat(String taxId) {
	    for (Supplier s : suppliers) {
	        if (s.getTaxId().equals(taxId)) {
	            return s;
	        }
	    }
	    System.out.println("Supplier not found");
	    return null;
	}
*/
}

