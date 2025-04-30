package retailhub;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ProductList productList1 = new ProductList();
		Product product1 = new Product(123,"adas","electronics");
		Product product2 = new Product(1, "2", "cosmetics", 123231, 1321 );
		Product product3 = new Product();

		//product1.productPrint();
		//product2.productPrint();
		//product3.productPrint();

		productList1.addProduct(product1);
		productList1.addProduct(product2);
		productList1.addProduct(product3);

		//productList1.searchProducts(121);
		//productList1.searchProducts(123);
		//productList1.searchProducts(-1);

		//productList1.printList();

		productList1.createProduct(121,"sdq", "21412", 2131, 2131);
		productList1.printList();









		/* κατασκευή και δοκιμη supplier και supplierList
		SupplierList suppliers = new SupplierList();
		
		suppliers.createAndAddSupplier("1", "2321", "32", "23f", "1rr");
		suppliers.createAndAddSupplier("2", "231", "321", "23", "1r");
		suppliers.printList();
		
		suppliers.updateSupplier(null, "mmm", "145", "13254","1431");
		suppliers.printList();
		*/


		
		/* Αφαίρεση supplier με scanner από το χρήστη.
		Scanner sc = new Scanner(System.in);
		System.out.println("Give a VAT");
		String taxID = sc.nextLine();             REMOVE SUPPLIER ME USER INPUT!!!
		
		suppliers.removeSupplier(taxID);
		
		sc.close();
		suppliers.printList();
		*/
		SalesList saleList = new SalesList();

		ProductList productList = new ProductList();
		Product product1 = new Product(1001, "Laptop", "Electronics", 999.99, 10);
		productList.addProduct(product1);

// Κάνουμε μια πώληση
		Sales sale1 = new Sales(product1, 2); // πουλάμε 2 laptops
		saleList.addSale(sale1);

		saleList.printAllSales();
		System.out.println("Total revenue: " + saleList.calculateTotalRevenue() + " €");








	}

}
