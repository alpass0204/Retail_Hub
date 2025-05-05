package retailhub;

import retailhub.Role;
import retailhub.SecurityLayer;

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
		//Supplier s1 = new Supplier("12", "Coc", "d2", "1324902", "femk", true);
		//Product p1 = new Product(1, "Shampoo", "Hair", 2, 1.85, 5, s1);
		//Product p2 = new Product(2, "Cannabis", "Hair", 5, 1.85, 5, s1);
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
		//ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		//OrderItem orderitem1 = new OrderItem(p1, 5);
		//OrderItem orderitem2 = new OrderItem(p2, 10);
//		items.add(orderitem1);
//		items.add(orderitem2);
		
		/*
		Order order1 = new Order(1, s1, items, Order.PaymentMethod.cash);
		order1.totalOrderValue();
		//System.out.println(order1.toString());
//		order1.printOrder();
		System.out.println("");
		order1.addOrderItem(orderitem1);
		order1.addOrderItem(orderitem2);
		*/

		//System.out.println(order1.toString());
		//OrderList orderlist1 = new OrderList();
//		orderlist1.addOrder(order1);
		//orderlist1.printAllOrders();
		//OrderList orderlist1 = new OrderList();
		//orderlist1.addOrder(order1);
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

/*
		//Creation of Userlist
		UserList userlist = new UserList();

		//Creation of users and SecurityLevel TESTING
		User karamf29 = new UserOne("karamf29", "xaris", "xaris" ,"karamf",29,50000,"xaris@yahoo.gr",
				"bp 39", Role.analyst  );
		User maz25 = new UserOne("maz25", "ilias0984398", "ilias" ,"maz",25,50000,"xaris@yahoo.gr",
				"bp 39", Role.analyst  );
		User kostas28 = new UserTwo("kostas28","kostas","kostas","kotsaris",28,55000,
				"kostas@uom.cz","Armenopoulou 12", Role.accountant);
		User alex21 = new UserThree("alex21","alex","alexandros","alexakis",21,550000,
				"alex@xela.com","Karaoli 12", Role.manager);
		User pavlos19 = new UserFour("pavlos19","pavlos","pavlaras","Prof",19,150000,
				"pavlosprof@igetis.com","Dodekanisou 99", Role.sysadmin);

		//Testing of userList methods

		//AddUser to the userList
		userlist.addUser(karamf29);
		userlist.addUser(maz25);
		userlist.addUser(kostas28);
		userlist.addUser(alex21);
		userlist.addUser(pavlos19);
		//userlist.printList();

		//Search User
		//userlist.searchUser(karamf29,29 );
		//userlist.searchUser(maz25,25);
		//userlist.searchUser(Dora,11);


		//Remove User
		//userlist.removeUser("karamf29",29);
		//userlist.printList();

		//Update user

		userlist.updateUser(pavlos19, "karamf29", "1234", "xaroulis", 11, 5, "a@a.net",
				"giannitswn 23", Role.sysadmin, new SecurityLevel(SecurityLayer.layer4));
		//userlist.printList();

		pavlos19.printUser();
		karamf29.printUser();
*/
//Customer Testing
		/*Customer c5 = new Customer(001, "Maria", "Maria@gmail.com", "6912345678", "Female",25,0);
		c5.printCustomer();
		c5.addPoints(150);
		c5.redeemAllPoints();
		c5.printLoyaltyPoints();
		c5.setPhone("6988888888");
		System.out.println("Updated phone: " + c5.getPhone()); */


		//CustomerList Testing
		CustomerList list = new CustomerList();

		//Δημιουργία πελατών
		list.createCustomer(001, "Maria", "maria@mail.com", "6912345678", "neutral", 150, 0);
		list.createCustomer(002, "Herrer", "her@mail.com", "6912323278", "neutral", 10, 0);

		//Εκτύπωση όλων
		// list.printList();

		// Προσθήκη πελάτη
		Customer Giannis= new Customer("Giannis", "Giannis@gmail.com","6945678912","Male",35,90);
		Customer Ilias= new Customer("Ilias", "iliass@gmail.com","6945678912","Male",35,90);
		list.addCustomerToList(Giannis);
		list.addCustomerToList(Ilias);
		list.printList();

        // Αναζήτηση πελάτ
		/**
       Customer found = list.getCustomerById(002);
       if (found != null) {
       found.printCustomer();}
		*/
		// Ενημέρωση πελάτη
		/*list.updateCustomer("001", "Maria Papadopoulou", "newmaria@mail.com", "6900000001", "Female", 31, 300);

       // Διαγραφή
       list.removeCustomer("003");

      // Εκτύπωση τελικής λίστας
      ist.printList(); }*/

	  /*Testing Order Item
		Supplier s1 = new Supplier("12", "Coc", "d2", "1324902", "femk", true);
		Product p1 = new Product(1, "Shampoo", "Hair", 10, 1.50, 0, s1);

		OrderItem item1 = new OrderItem(p1, 3);
		items.add(item1);


		System.out.println("Όνομα προϊόντος: " + item1.getPurchaseProductName());
		System.out.println("Τιμή αγοράς: " + item1.getProductPurchasePrice());
		System.out.println("Ποσότητα: " + item1.getQuantity());
		System.out.println("Γραμμή συνόλου: " + item1.getPurchaseOrderLineTotal() + " €");

		System.out.println("toString(): " + item1);  */

 /*Testing OrderList
		// Δημιουργία προϊόντων και supplier
		Supplier s1 = new Supplier("SUP01", "PapCorp", "Athens", "2101234567", "info@papcorp.com", true);
		Product p1 = new Product(1, "Printer", "Office", 5, 150.0, 2, s1);
		OrderItem item1 = new OrderItem(p1, 1);
		ArrayList<OrderItem> items = new ArrayList<>();
		items.add(item1);

        // Δημιουργία παραγγελίας
		Order order1 = new Order(1001, s1, items, Order.PaymentMethod.cash);
		order1.setSupplier(s1);  // Μην ξεχνάς να το αρχικοποιήσεις

        // Δημιουργία λίστας παραγγελιών
		OrderList orderList = new OrderList();
		orderList.addOrderToList(order1);

        // Εκτύπωση
		orderList.printAllOrders();

        // Ενημέρωση πληρωμής
		orderList.updateOrder(1001, Order.PaymentMethod.mobilePay);

        // Υπολογισμός συνολικού κόστους
		System.out.println("Total value of all orders: " + orderList.totalOrderListValue() + "€");

        // Διαγραφή παραγγελίας
		orderList.removeOrderFromList(1001);


		//Testing Order,OrderItem,OrderList
		/* ΔΗΜΙΟΥΡΓΙΑ SUPPLIER & PRODUCT
        Supplier s1 = new Supplier("SUP01", "PapCorp", "Athens", "2101234567", "info@papcorp.com", true);
        Product p1 = new Product(1, "Printer", "Office", 5, 150.0, 2, s1);*/

       /*Testing Order Item
       OrderItem item1 = new OrderItem(p1, 3);

       System.out.println("Order Item");
       System.out.println("Όνομα προϊόντος: " + item1.getPurchaseProductName());
       System.out.println("Τιμή αγοράς: " + item1.getProductPurchasePrice() + " €");
       System.out.println("Ποσότητα: " + item1.getQuantity());
       System.out.println("Γραμμή συνόλου: " + item1.getPurchaseOrderLineTotal() + " €");
       System.out.println("toString(): " + item1);

       //Προσθήκη σε ProductList
       ArrayList<OrderItem> items = new ArrayList<>();
       items.add(item1);

       //Δημηουργία ORDER
       Order order1 = new Order(1001, s1, items, Order.PaymentMethod.cash);
       order1.setSupplier(s1);
       order1.totalOrderValue();

       OrderList orderList = new OrderList();
       orderList.addOrderToList(order1);


       System.out.println("\n=== All Orders ===");
       orderList.printAllOrders();

       // Ενημέρωση τρόπου πληρωμής
       orderList.updateOrder(1001, Order.PaymentMethod.mobilePay);

       // Συνολικό κόστος Παραγγελιών
       System.out.println("\nTotal value of all orders: " + orderList.totalOrderListValue() + " €");

       //Διαγραφή Παραγγελίας
       orderList.removeOrderFromList(1001);
      System.out.println("\n=== Final Order List ===");
      orderList.printAllOrders();  */

		Customer c1 = new Customer("Alex", "asasq","14351","male",25);
		c1.addPoints(100);
		Supplier supplier = new Supplier(32,"324","3214","2311","23",true);
		Product p1 = new Product(14,"NS", "1r4",12.23,21.32,5000,supplier,5);
		ArrayList<SaleItem> items = new ArrayList<>();
		SaleItem si1 = new SaleItem(p1,125);
		items.add(si1);
		SalesList sL1 = new SalesList();
		Sales s1 = new Sales(123,items,PaymentMethod.DEBIT_CARD,c1);
		sL1.addSaleToList(s1);

		System.out.println(s1.toString());
		sL1.printAllSales();
		

	}
}