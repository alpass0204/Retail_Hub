package retailhub;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    JButton customersButton = new JButton("Customers");
    JButton productsButton = new JButton("Products");

    public MainMenu(CustomerList customerList, ProductList productList, SupplierList supplierList, User loggedInUser) {
        this.setTitle("Retail Hub - Main Menu");
        this.setSize(350, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1, 10, 10));
        this.setLocationRelativeTo(null);

        customersButton.addActionListener(e -> new CustomerMenu(customerList, loggedInUser));
        productsButton.addActionListener(e -> new ProductMenu(productList, supplierList, loggedInUser));

        this.add(customersButton);
        this.add(productsButton);
        this.setVisible(true);
    }
}

