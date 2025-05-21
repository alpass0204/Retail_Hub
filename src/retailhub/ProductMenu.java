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
                if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

                String category = JOptionPane.showInputDialog("Category:");
                if (category == null || category.trim().isEmpty()) throw new IllegalArgumentException("Category cannot be empty.");

                String purchasePriceStr = JOptionPane.showInputDialog("Purchase Price:");
                if (purchasePriceStr == null || purchasePriceStr.trim().isEmpty()) throw new IllegalArgumentException("Purchase price required.");
                double purchasePrice = Double.parseDouble(purchasePriceStr);

                String sellPriceStr = JOptionPane.showInputDialog("Sell Price:");
                if (sellPriceStr == null || sellPriceStr.trim().isEmpty()) throw new IllegalArgumentException("Sell price required.");
                double sellPrice = Double.parseDouble(sellPriceStr);

                String stockStr = JOptionPane.showInputDialog("Stock:");
                if (stockStr == null || stockStr.trim().isEmpty()) throw new IllegalArgumentException("Stock required.");
                int stock = Integer.parseInt(stockStr);
                if (stock < 0) throw new IllegalArgumentException("Stock must be 0 or more.");

                String taxIdStr = JOptionPane.showInputDialog("Supplier Tax ID:");
                if (taxIdStr == null || taxIdStr.trim().isEmpty()) throw new IllegalArgumentException("Supplier tax ID required.");
                int taxId = Integer.parseInt(taxIdStr);
                Supplier s = supplierList.getSupplierByVat(performingUser, taxId);
                if (s == null) throw new IllegalArgumentException("Supplier not found.");

                String notificationStockStr = JOptionPane.showInputDialog("Notification Stock:");
                if (notificationStockStr == null || notificationStockStr.trim().isEmpty()) throw new IllegalArgumentException("Notification stock required.");
                int notificationStock = Integer.parseInt(notificationStockStr);

                productList.createProduct(performingUser, name, category, purchasePrice, sellPrice, stock, s, notificationStock);
                JOptionPane.showMessageDialog(this, "Product created!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        searchButton.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog("Enter product ID:");
                if (idStr == null || idStr.trim().isEmpty()) throw new IllegalArgumentException("ID required.");
                int id = Integer.parseInt(idStr);
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
                String idStr = JOptionPane.showInputDialog("Product ID to update:");
                if (idStr == null || idStr.trim().isEmpty()) throw new IllegalArgumentException("ID required.");
                int id = Integer.parseInt(idStr);

                Product existingProduct = productList.searchProducts(performingUser, id);
                if (existingProduct == null) throw new IllegalArgumentException("Product not found.");

                String updatedName = JOptionPane.showInputDialog("New Name:", existingProduct.getName());
                if (updatedName == null || updatedName.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

                String updatedCategory = JOptionPane.showInputDialog("New Category:", existingProduct.getCategory());
                if (updatedCategory == null || updatedCategory.trim().isEmpty()) throw new IllegalArgumentException("Category cannot be empty.");

                String purchasePriceStr = JOptionPane.showInputDialog("New Purchase Price:", existingProduct.getPurchasePrice());
                if (purchasePriceStr == null || purchasePriceStr.trim().isEmpty()) throw new IllegalArgumentException("Purchase price required.");
                double purchasePrice = Double.parseDouble(purchasePriceStr);

                String sellPriceStr = JOptionPane.showInputDialog("New Sell Price:", existingProduct.getSellPrice());
                if (sellPriceStr == null || sellPriceStr.trim().isEmpty()) throw new IllegalArgumentException("Sell price required.");
                double sellPrice = Double.parseDouble(sellPriceStr);

                String stockStr = JOptionPane.showInputDialog("New Stock:", existingProduct.getStock());
                if (stockStr == null || stockStr.trim().isEmpty()) throw new IllegalArgumentException("Stock required.");
                int stock = Integer.parseInt(stockStr);
                if (stock < 0) throw new IllegalArgumentException("Stock must be 0 or more.");

                String notificationStockStr = JOptionPane.showInputDialog("New Notification Stock:", existingProduct.getNotificationStock());
                if (notificationStockStr == null || notificationStockStr.trim().isEmpty()) throw new IllegalArgumentException("Notification stock required.");
                int notificationStock = Integer.parseInt(notificationStockStr);

                Supplier s = existingProduct.getSupplier();
                productList.updateProduct(performingUser, id, updatedName, updatedCategory,
                        purchasePrice, sellPrice, stock, s, notificationStock);
                JOptionPane.showMessageDialog(this, "Product updated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                String idStr = JOptionPane.showInputDialog("Enter product ID to delete:");
                if (idStr == null || idStr.trim().isEmpty()) throw new IllegalArgumentException("ID required.");
                int id = Integer.parseInt(idStr);
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
                int yesNo = JOptionPane.showConfirmDialog(
                        null,
                        "Print all products?",
                        "Products List",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if (yesNo == JOptionPane.YES_OPTION) {
                    StringBuilder sb = new StringBuilder("Products:\n");
                    for (Product product : productList.getAllProducts()) {
                        sb.append(product.toString()).append("\n------------------\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
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
