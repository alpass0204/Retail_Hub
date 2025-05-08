
package retailhub;

import java.util.ArrayList;

/**
 * Manages a list of suppliers for the retail system
 * You can add, update, print the suppliers
 */

public class SupplierList {

	// FIELDS

	private final ArrayList<Supplier> suppliers; // List of all suppliers
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
		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSupplier)){
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
	public Supplier createSupplier(User performingUser, int taxId,
								  String brandName,
								  String phone, String address,
								  String email) throws SecurityException {
		if(performingUser.equals(null)) { // First check: If performing User = null
			throw new SecurityException("Performing user can't be NULL");
		}
		if(!performingUser.getSecurityLevel().hasRequiredLevel(manageSupplier)){
			throw new SecurityException("Forbidden."); // Credentials check
		}

		if(taxId == 0 && brandName.trim().toLowerCase().equals(null) ||
		brandName.trim().isEmpty()){ // Brand Name and Tax-Id not null values check
			throw new SecurityException("Tax-Id And Brand Name can't be NULLS");
		}
		
		Supplier s = new Supplier(taxId, brandName, address, phone, email,true);
		suppliers.add(s);
		return s;
	}



		
	/**
	 * Remove supplier if VAT already exists
	 * @param taxId
	 */
	public void removeSupplierFromList(User performerUser , int taxId) {
		if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSupplier)){
			throw new IllegalArgumentException("Forbidden."); // Credentials check
		}
		if(taxId==0){
			throw new IllegalArgumentException("TaxId-ID cant be 0."); //check for invalid orderId
		}

		Supplier supplierToRemove = null;
		for(Supplier supplier : suppliers){
			if(supplier.getTaxId() == taxId){
				supplierToRemove = supplier;
				break;
			}
		}
		if(supplierToRemove != null){
			suppliers.remove(supplierToRemove);
			System.out.println("Supplier with TaxId: "+taxId+" has been removed.");
		}
		else{
			System.out.println("No order found with ID "+taxId+".");
		}
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
	public boolean updateSupplier(User performerUser,int taxId,
								  String brandName, String phone,
								  String address, String email) {

		// 1) CHECK FOR CREDENTIALS TO UPDATE
	   if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSupplier)){
		   System.err.println("Forbidden");
		   return false; // exits the operation
	   }


	    for (Supplier s : suppliers) {
	        if (s.getTaxId() == (taxId)) { // checks and update supplier by taxId
	            s.setBrandName(brandName);
	            s.setPhone(phone);
	            s.setAddress(address);
	            s.setEmail(email);
				return true;
	        }
	    }
	    System.out.println("This supplier does not exist. Please enter a valid VAT!");
		return false; //exits the operation
	}



	/**
	 * PRINTS all suppliers in the list
	 */
	public void printList(User performingUser)throws SecurityException {
		if(!performingUser.getSecurityLevel().hasRequiredLevel(viewSupplier)){
			throw new SecurityException("Forbidden");
		}
		for(Supplier supplier: suppliers) {
			supplier.printSupplier();
		}
	}


	/**
	 * Check if a VAT number already exists in Suppliers List
	 * @param taxId
	 * @return
	 */
	public boolean vatExists(User performingUser,int taxId) {
		if(!performingUser.getSecurityLevel().hasRequiredLevel(viewSupplier)){
			System.err.println("Forbidden.");
			return false; //exits operation if user don't have the credentials
		}
		if(taxId==0){
			System.err.println("TaxId cant be NULL");
			return false; //exits operation
		}
	    for (Supplier s : suppliers) {
	        if (s.getTaxId() == taxId) {
	            return true;
	        }
	    }
	    return true;
	}
	
	/**
	 * Check and return supplier based on its VAT
	 * @param taxId
	 * @return
	 */
	public Supplier getSupplierByVat(User performingUser,
									 int taxId) {
		if(!performingUser.getSecurityLevel().hasRequiredLevel(viewSupplier)){
			throw new IllegalArgumentException("Forbidden.");  // credentials check
		}
		if(taxId==0){ // taxId value validation
			throw new IllegalArgumentException("TaxId can't be null.");
		}

	    for (Supplier s : suppliers) {
	        if (s.getTaxId()== taxId) {
	            return s;
	        }
	    }
	    System.out.println("Supplier not found");
	    return null;
	}
}

