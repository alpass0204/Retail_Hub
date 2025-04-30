package retailhub;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sales {
    private String productName;
    private int quantity;
    private double unitPrice;
    private int IdSale;
    private LocalDate date;
    private LocalTime time;
    private ArrayList<Product> products;

    // Constructor
    public Sales(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.IdSale = IdSale;
    }

    // Υπολογισμός συνολικής τιμής για την πώληση
    public double getTotalPrice() {
        return quantity * unitPrice;
    }

    // Εκτύπωση στοιχείων πώλησης
    public void printSale() {
        System.out.println("Product: " + productName + ", Quantity: " + quantity + ", Unit Price: " + unitPrice + ", Total Price: " + getTotalPrice());
    }

    // Getters και Setters για κάθε πεδίο (αν χρειάζεσαι αλλαγές/προσβάσεις)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
