package retailhub;

import java.util.ArrayList;

public class SalesList {
    private ArrayList<Sales> sales;

    // Constructor
    public SalesList() {
        this.sales = new ArrayList<>();
    }

    // Προσθήκη νέας πώλησης
    public void addSale(Sales sale) {
        sales.add(sale);
        System.out.println("Sale added successfully.");
    }

    // Υπολογισμός συνολικών εσόδων
    public double calculateTotalRevenue() {
        double total = 0;
        for (Sales sale : sales) {
            total += sale.getTotalPrice();
        }
        return total;
    }

    // Εκτύπωση όλων των πωλήσεων
    public void printAllSales() {
        if (sales.isEmpty()) {
            System.out.println("No sales have been made yet.");
        } else {
            for (Sales sale : sales) {
                sale.printSale();
            }
        }
    }

    // Πόσες πωλήσεις έχουν γίνει
    public int totalSalesCount() {
        return sales.size();
    }
}