package retailhub;

import java.util.Scanner;

//KLASI GIA TO MENU GIATI STIN MAIN THA GINEI XAMOS
//I LOGIKI EINAI OTI THA EXOUME CASES KAI GIA KATHE CASE META THA KALEITE METHODOS ME ALLA CASES

public class Menu {
    public void runMenu() {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("==== Menu ====");
            System.out.println("What would you like to do?");
            System.out.println("1. Customers");
            System.out.println("2. Products");
            System.out.println("3. Suppliers");
            System.out.println("4. Stock");
            System.out.println("5. Employees");
            System.out.println("7. Sales");
            System.out.println("8. Orders");
            System.out.println("9. Reports");
            System.out.println("0. Exit");

            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 9");
                in.nextInt();
            }
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    CustomerMenu();
                    break;
                case 2:

            }
        }
    }

    //AN EPILEKSEI 1 STO MENU THA KALEITE AUTI I METHODOS POU THA EXEI ALLA CASES PX CREATE, SEARCH etc.
    public void CustomerMenu() {
        Scanner in = new Scanner(System.in);
        CustomerList customerList = new CustomerList();
        User user;

        int choice;
        do {
            System.out.println("==== Customer Menu ====");
            System.out.println("What would you like to do?");
            System.out.println("1. Create a customer");
            System.out.println("2. Search a customer");
            System.out.println("3. Update a customer");
            System.out.println("4. Delete a customer");
            System.out.println("0. Menu");

            while (in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 4");
                in.nextInt();
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
                        customerList.createCustomer(user, name, email, phone, gender, age);
                    }
                    catch (Exception e) {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                case 2:
                    System.out.println("====Search a customer====");
                    System.out.println("Please enter phone or email.");
                    String input =  in.nextLine();
                    if (input.equals(customerList.getCustomerByEmail(user, input))) {  //prepei na checkaroume ti ginete me ta users edw
                        System.out.println("Customer found.");                         //giati den exw idea an douleuei auto to pragma
                        Customer c = customerList.getCustomerByEmail(user, input);
                        c.printCustomer();
                    }
                    else if (input.equals(customerList.getCustomerByPhone(user, input))) {
                        System.out.println("Customer found.");
                        Customer c = customerList.getCustomerByPhone(user, input);
                        c.printCustomer();
                    }
                    else {
                        System.out.println("Invalid input. Try again.");
                    }
            }
        }
    }
}
