
package retailhub;

import java.util.ArrayList;

/**
 * Manages a list of suppliers for the retail system
 * You can add, update, print the suppliers
 */

public class SupplierList {
	
	private ArrayList<Supplier> suppliers; // List of all suppliers
	
	/**
	 * CONSTRUCTOR initializing the supplier list
	 */

	public SupplierList() {
		this.suppliers = new ArrayList<Supplier>();
	}
	
	/**
	 * Adds a supplier to the list
	 * @param s Supplier to be added
	 */
	public void addSupplier(Supplier s) {
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
	/*public boolean createSupplier(int taxId, String brandName, String phone, String address, String email) {
		if(getSupplierByVat(taxId) != 0) {
			 System.out.println("A supplier with this VAT already exists.");
		     return false;
		}
		
		Supplier s = new Supplier(taxId, brandName, address, phone, email,true);
		suppliers.add(s);
		return true;
	}
	*/
		
	/**
	 * Remove supplier if VAT already exists
	 * @param taxId
	 */
	/*public void removeSupplier(String taxId) {
	    Supplier s = getSupplierByVat(taxId);
	    if (s != null) {
	        suppliers.remove(s);
	        System.out.println("The supplier with VAT "+s.getTaxId()+" has been removed!");
	    }
	    else {
	    	System.out.println("No such VAT exists. Please try again.");
	    }
	   
	}
	*/
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

