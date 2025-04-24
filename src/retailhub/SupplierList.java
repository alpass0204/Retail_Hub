package retailhub;

import java.util.ArrayList;

public class SupplierList {
	
	private ArrayList<Supplier> suppliers;
	
	//Constructor για την λιστα προμηθευτων...
	public SupplierList() {
		this.suppliers = new ArrayList<Supplier>();
	}
	
	public void addSupplier(Supplier s) {
		suppliers.add(s);
		
	}
	
	public Supplier createAndAddSupplier(String taxId, String brandName, String phone, String address, String email) {
	    Supplier s = new Supplier(taxId, brandName, phone, address, email);
	    this.addSupplier(s);
	    return s;
	}
	
	public void userInput(String taxId, String brandName, String phone, String address, String email) {
		
	}

	
	public void printList() {
		for(Supplier i: suppliers) {
			i.printSupplier();
		}
	}
	
	public boolean vatExists(String taxId) {
	    for (Supplier s : suppliers) {
	        if (s.getTaxId().equals(taxId)) {
	            return true;
	        }
	    }
	    return false;
	}


}
