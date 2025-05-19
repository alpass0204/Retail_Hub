package retailhub;

import javax.swing.*;
import java.awt.*;

public class ProductMenu extends JFrame {

    public ProductMenu(ProductList productList, SupplierList supplierList, User performingUser) {

        this.setTitle("Products Menu");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(6, 1, 10, 10));

        JButton createButton = new JButton("Create a product");
        JButton searchButton = new JButton("Search a product");
        JButton updateButton = new JButton("Update a product");
        JButton deleteButton = new JButton("Delete a product");
        JButton listButton = new JButton("List all products");
        JButton closeButton = new JButton("Close");

        createButton.addActionListener(e -> {
            try {
                String name = JOptionPane.showInputDialog("Name:");
                String category = JOptionPane.showInputDialog("Category:");
                double purchasePrice = Double.parseDouble(JOptionPane.showInputDialog("Purchase Price:"));
                double sellPrice = Double.parseDouble(JOptionPane.showInputDialog("Sell Price:"));
                int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock:"));
                int taxId = Integer.parseInt(JOptionPane.showInputDialog("Supplier Tax ID:"));
                Supplier s = supplierList.getSupplierByVat(performingUser, taxId);
                int notificationStock = Integer.parseInt(JOptionPane.showInputDialog("Notification Stock:"));

                productList.createProduct(performingUser, name, category, purchasePrice, sellPrice, stock, s, notificationStock);
                JOptionPane.showMessageDialog(this, "Product created!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        searchButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter product ID:"));
                Product product = productList.searchProducts(performingUser, id);
                if (product != null) {
                    JOptionPane.showMessageDialog(this, product.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Product not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        updateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Product ID to update:"));
                String updatedName = JOptionPane.showInputDialog("New Name:");
                String updatedCategory = JOptionPane.showInputDialog("New Category:");
                double updatedPurchasePrice = Double.parseDouble(JOptionPane.showInputDialog("New Purchase Price:"));
                double updatedSellPrice = Double.parseDouble(JOptionPane.showInputDialog("New Sell Price:"));
                int updatedStock = Integer.parseInt(JOptionPane.showInputDialog("New Stock:"));
                int notificationStock = Integer.parseInt(JOptionPane.showInputDialog("New Notification Stock:"));

                Supplier s = productList.searchProducts(performingUser, id).getSupplier();
                productList.updateProduct(performingUser, id, updatedName, updatedCategory,
                        updatedPurchasePrice, updatedSellPrice, updatedStock, s, notificationStock);
                JOptionPane.showMessageDialog(this, "Product updated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter product ID to delete:"));
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this product?");
                if (confirm == JOptionPane.YES_OPTION) {
                    productList.removeProduct(performingUser, id);
                    JOptionPane.showMessageDialog(this, "Product deleted.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        listButton.addActionListener(e -> {
            try {
                productList.printList(performingUser);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        closeButton.addActionListener(e -> dispose());

        this.add(createButton);
        this.add(searchButton);
        this.add(updateButton);
        this.add(deleteButton);
        this.add(listButton);
        this.add(closeButton);

        this.setVisible(true);
    }
}

