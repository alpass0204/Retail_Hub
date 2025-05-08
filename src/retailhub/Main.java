package retailhub;

import java.util.ArrayList;
import retailhub.Sales.PaymentMethod;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//INITIALIZATION OF LISTS FOR STORAGE
		Scanner in = new Scanner(System.in);
		UserList userList = new UserList();
		CustomerList customerList = new CustomerList();
		OrderList orderList = new OrderList();
		ProductList productList = new ProductList();
		SalesList salesList = new SalesList();
		SupplierList supplierList = new SupplierList();


		//USE CASE 1
		// Authentication class testing.
		// User loging in with 3 attempts, method finds user and types password

		User e3 = new Employee("ilias", "maz", SecurityLayer.layer3,
				"jane", "doe", 3000.13, "uom@2323.gr",
				"toumpa", Role.accountant);                                    //CREATION OF MANAGE EMPLOYEE
		Employee e1 = new Employee("kwstas", "willie", SecurityLayer.layer1,
				"jane", "doe", 3000.13, "uom@2323.gr",
				"toumpa", Role.salesPerson);                                 //CREATION OF LAYER1 EMPLOYEE
		Employee e2 = new Employee("Harry", "qwerty", SecurityLayer.layer2,
				"Harris", "Karam", 967.5, "xarkar@uom.gr",
				"473 BROADWAY", Role.accountant);                        //CREATION OF  ACCOUNTANT
		User sysadmin = new Employee("sudo", "wqfvdsf", SecurityLayer.layer4,
				"Administrator", "ADMIN", 0.0,
				"A@A.com", "", Role.sysadmin);                            //CREATION OF LAYER4 SYSADMIN


		//ADDITION TO USERLIST
		userList.addUserToList(e3, e1);
		userList.addUserToList(e3, e2);
		userList.addUserToList(e3, e3);


/*
		//PRINT LIST
		userList.printList(e1);

		//LOGIN FEATURE AND WORKHOURS INITIALIZATION

		Authentication.login("kwstas", userList);			//TODO - GET EMPLOYEE OBJECT FROM LOGIN
			WorkHours workHours = new WorkHours();			//TODO - DEPARTURE TIME ON EXIT/CLOCKOUT
			e1.addWorkSession(workHours);

*/
		/*


		//USE CASE 3
		//PRODUCT AND STOCK MANAGEMENT

		//CREATION OF SUPPLIER
		supplierList.createSupplier(e3,784523948,"WHOLESALE SUPPLIER","210 1234568",
				"Leoforos poseidonos 180", "generalmanagement@wholesale.com");

		//supplierList.printList(e3);


		Supplier s = supplierList.getSupplierByVat(e3,784523948);
		//PRODUCT CREATION FROM DIFFERENT SECURITY LAYERS

		//LAYER1 CANNOT MANAGE PRODUCTS
//		productList.createProduct(e1, "Headphones", "Electronics",289,350,1 , s, 0);

		//LAYER2 CAN MANAGE PRODUCTS
		productList.createProduct(e2, "PC monitor", "Electronics",25.0,21,1,s,0 );

		//LAYER3 AND HIGHER CAN MANAGE PRODUCTS
		productList.createProduct(e3,"Mac Lipstick", "Beauty",45.2,13, 3, s,1);

		//VIEW PRODUCT/PRODUCTLIST  -- CAN BE VIEWED BY ANYONE
		productList.printList(e2);

		//UPDATE PRODUCT
		productList.updateProduct(e2,1,"PC",";;;",345.4,340,12,s,2);

		//DELETE PRODUCT
		productList.removeProduct(e2,2);

		//SEARCH PRODUCT
		productList.searchProducts(e2,1);

		//VIEW PRODUCT/PRODUCTLIST  -- CAN BE VIEWED BY ANYONE
		productList.printList(e2);



		//USE CASE 4
		//MANAGEMENT OF SALES



		//CREATION OF PRODUCTS NEEDED FOR SALES
		supplierList.createSupplier(e3,784523948,"WHOLESALE SUPPLIER","210 1234568",
				"Leoforos poseidonos 180", "generalmanagement@wholesale.com");
		Supplier s = supplierList.getSupplierByVat(e3,784523948);
		Product p1 =  new Product( "PC monitor", "Electronics",25.0,21,10,s,0);
		Product p2 = new Product("Mac Lipstick", "Beauty",45.2,13, 3, s,1);
		Product p3 = new Product("Headphones", "Electronics",289,350,23 ,s, 1);


		//CREATION OF CUSTOMERS NEEDED FOR SALES
		Customer cust = new Customer("Alex","e124","6983249829","Male",25);


		//ADDITION OF SALE ITEM AND QUANTITY

		SaleItem sItems1 = new SaleItem(e3,p1,2);
		SaleItem sItems2 = new SaleItem(e3,p3,1);
		ArrayList<SaleItem> items = new ArrayList<>();


		//INITIALIZATION OF SALE
		Sales s1 = new Sales(123, items,PaymentMethod.CASH,cust);
		s1.addItem(e2,sItems2);
		s1.addItem(e2,sItems1);


		//System.out.println(s1.toString());

		//VIEW  Sales List
		salesList.addSaleToList(e3,s1);
		//salesList.printAllSales(e3);

		//UPDATE SALE
		salesList.updateSale(e3,123,PaymentMethod.CREDIT_CARD );

		//SEARH SALE
		salesList.searchSale(e3,123);

		//RECEIPT OF SALE
		s1.receipt(e3);

		//REMOVE SALE
		salesList.removeSaleFromTheList(e1,123);

		//VIEW  Sales List
		//salesList.addSaleToList(e3,s1);
		salesList.printAllSales(e3);






		//USE CASE 5
		//CUSTOMER MANAGEMENT


		//CREATE CUSTOMER AND ADDITION TO THE LIST
		Customer c1 = customerList.createCustomer(e3,"Ilias","mazarakis@msn.com", "1234567890","+",58);
		Customer c2 = customerList.createCustomer(e2, "MAria Papadopoulou", "maraki@yahoo.gr", "6969699696", "female", 27 );
		Customer c3 = customerList.createCustomer(e3, "Sakis Ampatzoglou", "sk@yahoo.gr", "6969659696", "female", 27 );
		Customer c4 = customerList.createCustomer(e3, "areti Papadopoulou", "areti@yahoo.gr", "6969799696", "female", 27 );
		//customerList.addCustomerToList(e3, c4);

		//PRINT CUSTOMERLIST
		//customerList.printList(e3);

		//SEARH AND UPDATE CUSTOMER
		customerList.updateCustomer(e3,"george","mazarakis@msn.com","1234567890","+",58,0 );
		//System.out.println(customerList.getCustomerByEmail(e3, "marewqreraki@yahoo.gr").getName());
		customerList.printList(e3);

		//SEARCH AND REMOVE CUSTOMER
		Customer customerToRemove = customerList.getCustomerByPhone(e3,"1234567890");
		customerList.removeCustomer(e3,customerToRemove);

		//PRINT CUSTOMERLIST
		customerList.printList(e3);




		
		//USE CASE 6
		//MANAGEMENT OF SUPPLIERS AND ORDERS

		//CREATE SUPPLIER AND ADD TO THE LIST
		 Supplier s1 = supplierList.createSupplier(e3,784523948,
				 "WHOLESALE SUPPLIER","210 1234568",
				"Leoforos poseidonos 180", "generalmanagement@wholesale.com");

		//supplierList.addSupplier(s1,e3);
		supplierList.printList(e3);

		//SEARCH SUPPLIER
		supplierList.getSupplierByVat(e3,784523948);

		//UPDATE SUPPLIER
		supplierList.updateSupplier(e3,784523948,"wholesale","0123789456",
				"SYggrou 12", "barethika@uom.gr");
		supplierList.vatExists(e3, 784523948);

		//REMOVE SUPPLIER
		supplierList.removeSupplierFromList(e3,784523948);
		supplierList.printList(e3);

*/

/*
		//ORDER
		//CREATE ORDER

		//ORDER DEPENDENTS INITIALIZATION
		Supplier s1 = supplierList.createSupplier(e3, 12456987, "Athens", "2101234567", "Leof. nikis 68", "info@papcorp.com");
		Product p1 = new Product("test", "Beauty", 12, 27, 11, s1, 10);
		OrderItem item1 = new OrderItem(e3, p1, 5);
		ArrayList<OrderItem> items = new ArrayList<>();
		items.add(item1);

        // CREATE ORDER
		Order order1 = new Order( s1, items, Order.PaymentMethod.cash);

		order1.setSupplier(s1);  // SETTING SUPPLIER

		orderList.addOrderToList(order1);

        // VIEW/PRINT ORDER
		orderList.printAllOrders(e3);

        // UPDATE ORDER
		orderList.updateOrder(e3,1, Order.PaymentMethod.mobilePay);

        // CALCULATES TOTAL COST OF ORDERS
		System.out.println("Total value of all orders: " + orderList.totalOrderListValue(e1) + "€");

		//SEARCH ORDER
		orderList.searchOrder(e3,1);

		//CHECKING STOCK OF PRODUCT ORDERED
		System.out.println("Product " + p1.getName()+"has "+p1.getStock() +" items left in stock.");  //TODO method MUST update stock

        // REMOVES AN ORDER FROM THE LIST
		orderList.removeOrderFromList(e3,1);

*/

		//USE CASE 7 , 7.1 , 8
		//REPORTS
/*
		FinancialReport overall = new FinancialReport(salesList, orderList, userList);
		overall.generateReport(e3);
*/

		// ----------------------------------------------------------------- //

	}
}