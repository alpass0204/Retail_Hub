package retailhub;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	
		
		SupplierList suppliers = new SupplierList();
		
		
			
		
		
		suppliers.createAndAddSupplier("1", "2321", "32", "23f", "1rr");
		suppliers.createAndAddSupplier("2", "231", "321", "23", "1r");
		suppliers.printList();
		
		suppliers.updateSupplier(null, "mmm", "145", "13254","1431");
		suppliers.printList();
		


		
		/**
		Scanner sc = new Scanner(System.in);
		System.out.println("Give a VAT");
		String taxID = sc.nextLine();             REMOVE SUPPLIER ME USER INPUT!!!
		
		suppliers.removeSupplier(taxID);
		
		sc.close();
		suppliers.printList();
		**/
		
		
		


		

	}

}
