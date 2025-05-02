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


    // Εκτύπωση όλων των πωλήσεων
    public void printAllSales() {
        if (sales.isEmpty()) {
            System.out.println("No sales have been made yet.");
        } else {
            for (Sales sale : sales) {
                System.out.println(sale.toString());
            }
        }
    }
    
    public void removeSale(String salesId) {
        Sales saleToRemove = null;
        for (Sales sale : sales) {
            if (sale.getSales_id().equals(salesId)) {
                saleToRemove = sale; // Found the sale with the matching sales_id
                break;
            }
        }

        if (saleToRemove != null) {
            sales.remove(saleToRemove);  // Remove the sale from the list
            System.out.println("Sale with ID " + salesId + " has been removed.");
        } else {
            System.out.println("No sale found with ID " + salesId + ".");
        }
    }
    
    public void updateSale(String salesId, String newDate, Sales.PaymentMethod newPaymentMethod) {
        for (Sales sale : sales) {
            if (sale.getSales_id().equals(salesId)) {
                // Update the sale's date and payment method
                sale.setDate(newDate);
                sale.setPaymentMethod(newPaymentMethod);
                System.out.println("Sale with ID " + salesId + " has been updated.");
                return;  // Exit the method after updating the sale
            }
        }
        
        // If no sale is found with the given sales_id
        System.out.println("No sale found with ID " + salesId + ".");
    }



    // Πόσες πωλήσεις έχουν γίνει
    public int totalSalesCount() {
        return sales.size();
    }
}