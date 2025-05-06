package retailhub;

import java.util.ArrayList;

/**
 * Manages a list of sales transactions
 * Provides adding, updating, removing, calculating statistics on sales
 */

public class SalesList {
    private ArrayList<Sales> sales; // List of all sales

    // CONSTRUCTOR

    public SalesList() {
        this.sales = new ArrayList<>();
    }

    /**
     * Adds a sale to the list if all items are in stock
     * @param sale sale to be added
     */

    public void addSaleToList(Sales sale) {
        boolean productStock = true;
        for (SaleItem item : sale.getItemsSold()) {
            Product p = item.getProduct();
            int soldQuantity = item.getQuantity();
            if (p.getStock() < soldQuantity) {
                System.out.println("Insufficient Stock for product: "+ p.getProductId() +
                        " Name: " + p.getName()+"\n Required: " + soldQuantity+
                        "\n Available: " + p.getStock() + "\n Sale aborted.");
                productStock = false;
                break;
            }
        }
        if (productStock) {
            System.out.println("Sale added successfully.");
        }
    }

    // Prints all sales in the list
    public void printAllSales() {
        if (sales.isEmpty()) {
            System.out.println("No sales have been made yet.");
        } else {
            for (Sales sale : sales) {
                System.out.println(sale.toString());
            }
        }
    }

    /**
     * Removes a sale based on ID
     * @param salesId ID of the sale to remove
     */
    public void removeSaleFromTheList(int salesId) {
        Sales saleToRemove = null;
        for (Sales sale : sales) {
            if (sale.getSalesId() == salesId) {
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

    /**
     * Updates the payment method of a sale
     * @param salesId sale to update
     * @param newPaymentMethod Payment method to set
     */

    public void updateSale(int salesId, Sales.PaymentMethod newPaymentMethod) {
        for (Sales sale : sales) {
            if (sale.getSalesId() == salesId) {
                // Update the sale's date and payment method
                sale.getDate();
                sale.getTime();
                System.out.println("New payment method: " + newPaymentMethod.toString());
                sale.setPaymentMethod(newPaymentMethod);
                System.out.println("Sale with ID " + salesId + " has been updated.");
                return;  // Exit the method after updating the sale
            }
        }
        
        // If no sale is found with the given sales_id
        System.out.println("No sale found with ID " + salesId + ".");
    }

    /**
     * Returns an item from a sale
     * @param sale the sale where the return is happening
     * @param item the item being returned
     */
    public void returnSaleItem(Sales sale, SaleItem item) {
        sale.returnItem(item);
    }

    //RETURN Total number of sales

    public int totalSalesCount() {
        return sales.size();
    }

    /**
     * Calculates total revenue from all sales
     * @return revenue amount
     */
    public double getTotalRevenue() {
        double revenue = 0;
        for (Sales sale : sales) {
            revenue += sale.getTotalamount();
        }
        System.out.println("Total revenue: " + revenue);
        return revenue;
    }
}