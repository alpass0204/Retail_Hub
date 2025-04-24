package retailhub;

import java.util.ArrayList;

public class SupplierList {
	
	private ArrayList<Supplier> suppliers;
	
	/**
	 * Constructor για την λιστα προμηθευτων...
	 */
	public SupplierList() {
		this.suppliers = new ArrayList<Supplier>();
	}
	
	/**
	 * Μέθοδος προσθηκης supplier στη λιστα (προαιρετικο)...
	 * @param s
	 */
	public void addSupplier(Supplier s) {
		suppliers.add(s);
		
	}
	
	/**
	 * Δημιουργια supplier και καταχωριση του στη λιστα σε μια μεθοδο (με αποθηκευση και ελεγχο)...
	 * @param taxId
	 * @param brandName
	 * @param phone
	 * @param address
	 * @param email
	 * @return
	 */
	public boolean createAndAddSupplier(String taxId, String brandName, String phone, String address, String email) {
		if(getSupplierByVat(taxId) != null) {
			 System.out.println("A supplier with this VAT already exists.");
		     return false;
		}
		
		Supplier s = new Supplier(taxId, brandName, address, phone, email);
		suppliers.add(s);
		return true;
	}
	
		
	/**
	 * Αφαίρεση supplier εφοσον το ΑΦΜ του υπαρχει...
	 * @param taxId
	 */
	public void removeSupplier(String taxId) {
	    Supplier s = getSupplierByVat(taxId);
	    if (s != null) {
	        suppliers.remove(s);
	        System.out.println("The supplier with VAT "+s.getTaxId()+" has been removed!");
	    }
	    else {
	    	System.out.println("No such VAT exists. Please try again.");
	    }
	   
	}
	
	/**
	 *  Αναζήτηση supplier βασει του ΑΦΜ του. Αν τον βρει, καλουμε μεθοδους set για να αλλαξουμε στοιχεια...
	 * @param taxId
	 * @param brandName
	 * @param phone
	 * @param address
	 * @param email
	 * @return
	 */
	public boolean updateSupplier(String taxId, String brandName, String phone, String address, String email) {
	    for (Supplier s : suppliers) {
	        if (s.getTaxId().equals(taxId)) {
	            s.setBrandName(brandName);
	            s.setPhone(phone);
	            s.setAddress(address);
	            s.setEmail(email);
	            return true;
	        }
	    }
	    System.out.println("This supplier does not exist. Please enter a valid VAT!");
	    return false;
	}



	/**
	 * Εκτύπωση ολων των Suppliers στη λιστα...
	 */
	public void printList() {
		for(Supplier i: suppliers) {
			i.printSupplier();
		}
	}
	/**
	 * Ελεγχος αν υπαρχει ενα ΑΦΜ ηδη στη λιστα Suppliers...
	 * @param taxId
	 * @return
	 */
	public boolean vatExists(String taxId) {
	    for (Supplier s : suppliers) {
	        if (s.getTaxId().equals(taxId)) {                   
	            return true;
	        }
	    }
	    return false;
	}
	
	
	/**
	 * ελεγχος και επιστροφη supplier βασει του ΑΦΜ του...
	 * @param taxId
	 * @return
	 */
	public Supplier getSupplierByVat(String taxId) {
	    for (Supplier s : suppliers) {
	        if (s.getTaxId().equals(taxId)) {
	            return s;
	        }
	    }
	    return null;
	}

}
