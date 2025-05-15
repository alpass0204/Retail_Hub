package retailhub;

import java.util.ArrayList;
import retailhub.Sales.PaymentMethod;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


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

		//CREATION OF SUPPLIER
		Supplier s = supplierList.createSupplier(e3,12345,"avon","210 1234568",
				"Leoforos poseidonos 180", "generalmanagement@wholesale.com");

		//CREATION OF PRODUCTS NEEDED FOR SALES
		productList.createProduct( e3,"PC monitor", "Electronics",25.0,21,10,s,0);
		productList.createProduct(e3,"Mac Lipstick", "Beauty",45.2,13, 3, s,1);
		productList.createProduct(e3,"Headphones", "Electronics",289,350,23 ,s, 1);

		customerList.createCustomer(e3,"AEGEAN AE","aegean@fly.com","2463083145","non",50);
		customerList.createCustomer(e3,"KWSTAKIS AE","kwstakissexsymbol@gn.gr","6984005180","non",25);
		customerList.createCustomer(e3,"BACCARA BAR","baccara@gmail.com","2310231020","Male",45);



		//ADDITION TO USERLIST
		userList.addUserToList(e3, e1);
		userList.addUserToList(e3, e2);
		userList.addUserToList(e3, e3);
		userList.addUserToList(sysadmin,sysadmin);


		/*
		User logInUser = null;
		while (logInUser == null) {
			System.out.println("Please enter your username:");
			String username = in.nextLine();
			Authentication.login(username,userList);


			if (logInUser == null) {
				System.out.println("Invalid username or password. Please try again.");

			}
		}
		*/
		//Menu menu = new Menu();
		//menu.runMenu(logInUser, customerList, productList, supplierList, in);

		//in.close();
		//System.out.println("Application terminated.");



















