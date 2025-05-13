package retailhub;

import java.util.Scanner;

//KLASI GIA TO MENU GIATI STIN MAIN THA GINEI XAMOS
//I LOGIKI EINAI OTI THA EXOUME CASES KAI GIA KATHE CASE META THA KALEITE METHODOS ME ALLA CASES

public class Menu {

    private Authentication auth;

    public void runMenu(User loggedInUser, CustomerList customerList, ProductList productList,
                        SupplierList supplierList, Scanner in) {

        int choice;
        do {
            System.out.println("==== Menu ====");
            System.out.println("What would you like to do?");
            System.out.println("1. Customers");
            System.out.println("2. Products");
            System.out.println("3. Suppliers");
            System.out.println("4. Employees");
            System.out.println("5. Sales");
            System.out.println("6. Orders");
            System.out.println("7. Reports");
            System.out.println("0. Exit");


            choice = in.nextInt();

            switch (choice) {
                case 1:
                    customerMenu(loggedInUser, customerList, in);
                    break;
                case 2:
                    productMenu(loggedInUser, productList, supplierList, in);
                    break;
                case 3:
                    System.out.println("UNDER CONSTRUCTION. PLEASE TRY AGAIN LATER. ");
                    //supplierMenu( loggedInUser,  supplierList, in);
                    break;
                case 4:
                    System.out.println("UNDER CONSTRUCTION. PLEASE TRY AGAIN LATER. ");
                    //employeeMenu( loggedInUser,  userList, in);
                    break;
                case 5:
                    System.out.println("UNDER CONSTRUCTION. PLEASE TRY AGAIN LATER. ");
                    //salesMenu( loggedInUser,  salesList, in);
                    break;
                case 6:
                    System.out.println("UNDER CONSTRUCTION. PLEASE TRY AGAIN LATER. ");
                    //orderMenu( loggedInUser,  orderList, in);
                    break;
                case 7:
                    System.out.println("UNDER CONSTRUCTION. PLEASE TRY AGAIN LATER. ");
                    //reportsMenu( loggedInUser, in);
                    break;
                case 0:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 0);
    }


    public void customerMenu(User performingUser, CustomerList customerList, Scanner in) {


        int choice;
        do {
            System.out.println("==== Customer Menu ====");
            System.out.println("What would you like to do?");
            System.out.println("1. Create a customer");
            System.out.println("2. Search a customer");
            System.out.println("3. Update a customer");
            System.out.println("4. Delete a customer");
            System.out.println("5. List all customers");
            System.out.println("0. Menu");

            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 5");
                in.next();
            }

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("====Create a customer====");
                    System.out.println("Name: ");
                    String name = in.nextLine();
                    System.out.println("Email: ");
                    String email = in.nextLine();
                    System.out.println("Phone: ");
                    String phone = in.nextLine();
                    System.out.println("Gender: ");
                    String gender = in.nextLine();
                    System.out.println("Age: ");
                    int age = in.nextInt();

                    try {
                        customerList.createCustomer(performingUser, name, email, phone, gender, age);
                    } catch (Exception e) {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                case 2:
                    System.out.println("====Search a customer====");
                    System.out.println("Please enter phone or email.");
                    String input = in.nextLine();
                    Customer c = null;

                    if (input.contains("@")) {
                        c = customerList.getCustomerByEmail(performingUser, input);
                    } else {
                        c = customerList.getCustomerByPhone(performingUser, input);
                    }
                    if (c != null) {
                        System.out.println("Customer found.");
                        c.printCustomer();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 3:
                    System.out.println("====Update a customer");
                    System.out.println("Name: ");
                    String updatedName = in.nextLine();
                    System.out.println("Email: ");
                    String updatedEmail = in.nextLine();
                    System.out.println("Phone: ");
                    String updatedPhone = in.nextLine();
                    System.out.println("Gender: ");
                    String updatedGender = in.nextLine();
                    System.out.println("Age: ");
                    int updatedAge = in.nextInt();

                    boolean isUpdated = customerList.updateCustomer(performingUser, updatedName, updatedEmail, updatedPhone, updatedGender, updatedAge);
                    if (isUpdated) {
                        System.out.println("Customer updated successfully.");
                    } else {
                        System.out.println("Customer not found. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("====Search for customer to remove====");
                    System.out.println("Please enter phone or email.");
                    String inputToRemove = in.nextLine();
                    Customer customerToRemove = null;

                    if (inputToRemove.contains("@")) {
                        customerToRemove = customerList.getCustomerByEmail(performingUser, inputToRemove);
                    } else {
                        customerToRemove = customerList.getCustomerByPhone(performingUser, inputToRemove);
                    }
                    if (customerToRemove != null) {
                        System.out.println("Are you sure you want to remove this customer? (yes/no) ");
                        if (in.nextLine().equalsIgnoreCase("yes")) {
                            System.out.println("Customer removed.");
                            customerList.removeCustomer(performingUser, customerToRemove);
                        } else {
                            System.out.println("Deletion cancelled.");

                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.println("====List all customers====");

                    customerList.printList(performingUser);

                case 0:
                    System.out.println("Exiting to Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        }
        while (choice != 0);
    }


    public void productMenu(User performingUser, ProductList productList, SupplierList supplierList, Scanner in) {


        int choice;
        do {
            System.out.println("==== Product Menu ====");
            System.out.println("What would you like to do?");
            System.out.println("1. Create a product");
            System.out.println("2. Search a product");
            System.out.println("3. Update a product");
            System.out.println("4. Delete a product");
            System.out.println("0. Menu");

            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 4");
                in.next();
            }

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("====Create a product====");
                    System.out.println("Name: ");
                    String name = in.nextLine();
                    System.out.println("Category: ");
                    String category = in.nextLine();
                    System.out.println("Purchase Price: ");
                    double purchasePrice = in.nextDouble();
                    System.out.println("Sell Price: ");
                    double sellPrice = in.nextDouble();
                    System.out.println("Stock: ");
                    int stock = in.nextInt();
                    System.out.println("Supplier's tax ID: ");
                    int taxId = in.nextInt();
                    Supplier s = supplierList.getSupplierByVat(performingUser, taxId);
                    System.out.println("Notification Stock: ");
                    int notificationStock = in.nextInt();
                    Product product = new Product(name, category, purchasePrice, sellPrice, stock, s, notificationStock);
                    productList.addProduct(product);
                    break;
                case 2:
                    System.out.println("====Search a product====");
                    System.out.println("Please enter product's ID:");
                    int input = in.nextInt();
                    Product productToSearch = productList.searchProducts(performingUser, input);
                    if (productToSearch != null) {
                        System.out.println("Product found.");
                        productToSearch.printProduct();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.println("====Update a product====");
                    System.out.println("Please enter product's ID:");
                    int inputToUpdate = in.nextInt();
                    Product productToUpdate = productList.searchProducts(performingUser, inputToUpdate);
                    if (productToUpdate != null) {
                        System.out.println("Name: ");
                        String updatedName = in.nextLine();
                        productToUpdate.setName(updatedName);
                        System.out.println("Category: ");
                        String updatedCategory = in.nextLine();
                        productToUpdate.setCategory(updatedCategory);
                        System.out.println("Purchase Price: ");
                        double updatedPurchasePrice = in.nextDouble();
                        productToUpdate.setPurchasePrice(updatedPurchasePrice);
                        System.out.println("Sell Price: ");
                        double updatedSellPrice = in.nextDouble();
                        productToUpdate.setSellPrice(updatedSellPrice);
                        System.out.println("Stock: ");
                        int updatedStock = in.nextInt();
                        productToUpdate.setStock(updatedStock);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    System.out.println("====Delete a product====");
                    System.out.println("Please enter product's ID:");
                    int inputToDelete = in.nextInt();
                    in.nextLine();
                    Product productToDelete = productList.searchProducts(performingUser, inputToDelete);
                    if (productToDelete != null) {
                        System.out.println("Are you sure you want to delete this product? (yes/no) ");
                        if (in.nextLine().equalsIgnoreCase("yes")) {
                            System.out.println("Product deleted.");
                            productList.removeProduct(performingUser, inputToDelete);
                        } else {
                            System.out.println("Deletion cancelled.");

                        }
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public void SalesMenu(User performingUser, SalesList salesList, ProductList productList, Scanner in) {
        int choice;

        do {
            System.out.println("1. New Sale ");
            System.out.println("2. Search Sale ");
            System.out.println("3. Update sale");
            System.out.println("4. Remove sale");
            System.out.println("5. Print all sales");
            System.out.println("0. Menu");


            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 5.");
                in.next();
            }

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:

            }
        }
        while (choice != 0);

    }
}