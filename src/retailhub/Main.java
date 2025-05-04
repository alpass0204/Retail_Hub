package retailhub;

import java.util.ArrayList;
import java.util.Scanner;

import retailhub.Sales.PaymentMethod;

public class Main {

	public static void main(String[] args) {
		//TESTING CRUD FOR SUPPLIER AND SUPPLIERLIST

		//CREATION OF SUPPLIER LIST FOR STORAGE OF SUPPLIERS
		//SupplierList suppliersTechnology = new SupplierList();

		//CREATION OF SUPPLIERS
		//Supplier Cosmote = new Supplier("25021","Cosmote","Enwtikwn11","698400","asodiaosi",null);
		//Supplier Vodafone = new Supplier("32232","Vodafone","Xaroupolh 22","69849584","ilias@iois",null);

		//ProductList productList1 = new ProductList();
		//Product product1 = new Product(123,"cola","electronics");
		//Product product2 = new Product(1, "fanta", "cosmetics", 123231, 1321, null  );
		//Product product3 = new Product();
		//Product product4 = new Product(2, "sprite", "cosmetics", 123231, 1321,null );
		//Product product5 = new Product(3, "sprite", "cosmetics", 123231, 1321,null);
		//suppliersTechnology.addSupplier(Cosmote);
		//suppliersTechnology.addSupplier(Vodafone);
		//suppliersTechnology.printList();
		//product1.printProduct();
		//product2.productPrint();
		//product3.productPrint();

		//productList1.addProduct(product1);
		//productList1.addProduct(product2);
		//productList1.addProduct(product3);

		//productList1.searchProducts(121);
		//productList1.searchProducts(123);
		//productList1.searchProducts(-1);

		//productList1.printList();

		//productList1.createProduct(121,"sdq", "21412", 2131, 2131);
		//productList1.printList();
		//suppliersTechnology.printList();
		//Cosmote.printSupplier();
		
	/*  ------- SALEITEM + SALES CLASSES-METHODS TESTED <3---------*/
		Supplier s1 = new Supplier("12", "Coc", "d2", "1324902", "femk", true);
		Product p1 = new Product(1, "Shampoo", "Hair", 2, 1.85, 5, s1);
		Product p2 = new Product(2, "Cannabis", "Hair", 5, 1.85, 5, s1);
//		SaleItem item1 = new SaleItem(p1,2);
//		SaleItem item2 = new SaleItem(p2,2);                                                                   //   SALEITEM + SALES CLASSES-METHODS TESTED <3
	
/*		System.out.println(item1.getName());
		System.out.println(item1.getLineTotal());
		Employee e1 = new Employee("34513","14432", 1,2254, "34124", "3i24kj","1431","14", Role.MANAGER);
		ArrayList<SaleItem> items = new ArrayList<SaleItem>();
		items.add(item1);
		items.add(item2);
		
		
		Sales sale1 = new Sales("14324","34125", e1, items, PaymentMethod.DEBIT_CARD);
		
		sale1.sumTotal();
		System.out.println(sale1.getTotalamount());
		System.out.println(sale1.receipt());
*/		

		//Testing Order, OrderItem, OrderList classes
		//Create a supplier, a product or two and test if the classes works
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		OrderItem orderitem1 = new OrderItem(p1, 5);
		OrderItem orderitem2 = new OrderItem(p2, 10);
//		items.add(orderitem1);
//		items.add(orderitem2);
		
		
		Order order1 = new Order(1, s1, items, Order.PaymentMethod.cash);
		order1.totalOrderValue();
		//System.out.println(order1.toString());
//		order1.printOrder();
		System.out.println("");
		order1.addOrderItem(orderitem1);
		order1.addOrderItem(orderitem2);
		
		//System.out.println(order1.toString());
		//OrderList orderlist1 = new OrderList();
//		orderlist1.addOrder(order1);
		//orderlist1.printAllOrders();







		// κατασκευή και δοκιμη supplier και supplierList
		//SupplierList suppliers = new SupplierList();
		//Supplier supplier1 = new Supplier;
		//suppliers.createAndAddSupplier("1", "2321", "32", "23f", "1rr");
		//suppliers.createAndAddSupplier("2", "231", "321", "23", "1r");
		//suppliers.printList();
		
		//suppliers.updateSupplier(null, "mmm", "145", "13254","1431", );
		//suppliers.printList();




		
		/* Αφαίρεση supplier με scanner από το χρήστη.
		Scanner sc = new Scanner(System.in);
		System.out.println("Give a VAT");
		String taxID = sc.nextLine();             REMOVE SUPPLIER ME USER INPUT!!!
		
		suppliers.removeSupplier(taxID);
		
		sc.close();
		suppliers.printList();
		*/
		
		
		


		

	}

}
