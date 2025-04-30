package retailhub;

import java.time.LocalDateTime;

public class Sales {
    private Product product;
    private int quantity;
    private LocalDateTime dateTime;
    private double totalPrice;

    // Constructor
    public Sales(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.dateTime = LocalDateTime.now();
        this.totalPrice = product.getPrice() * quantity;

        // Μειώνουμε το stock του προϊόντος
        int newStock = product.getStock() - quantity;
        product.setStock(newStock);
    }

    // Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Εκτυπώνουμε την πώληση
    public void printSale() {
        System.out.println("Sale of " + quantity + " units of " + product.getName() +
                " on " + dateTime + ". Total: " + totalPrice + " €");
    }
}

