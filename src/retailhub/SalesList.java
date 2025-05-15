package retailhub;

import java.util.ArrayList;

/**
 * Manages a list of sales transactions
 * Provides adding, updating, removing, calculating statistics on sales
 */

public class SalesList {

    // FIELDS
    private static final SecurityLayer viewSalesList = SecurityLayer.layer1;
    private static final SecurityLayer manageSalesList = SecurityLayer.layer3;
    private final ArrayList<Sales> sales; // List of all sales

    // CONSTRUCTOR

    public SalesList() {
        this.sales = new ArrayList<>();
    }

    /**
     * Adds a sale to the list if all items are in stock
     * @param sale sale to be added
     */

    public void addSaleToList(User performerUser,Sales sale)throws SecurityException {
        if(!performerUser.getSecurityLevel().hasRequiredLevel(viewSalesList)){
            throw new SecurityException("Forbidden."); // credentials check
        }
        if(sale == null){
            throw new SecurityException("Sale cant be null."); // check of sale validation
        }
        sales.add(sale);
    }

    // Prints all sales in the list
    public void printAllSales(User performerUser) throws SecurityException {
        if (!performerUser.getSecurityLevel().hasRequiredLevel(viewSalesList))
            throw new SecurityException("Forbidden.");{
            if (sales.isEmpty()) {
                System.out.println("No sales have been made yet.");
            } else {
                for (Sales sale : sales) {
                    System.out.println(sale.toString());
                }
            }
        }
    }

    /**
     * Removes a sale based on ID
     * @param salesId ID of the sale to remove
     */
    public void removeSaleFromTheList(User performerUser, int salesId) throws SecurityException {
        if (!performerUser.getSecurityLevel().hasRequiredLevel(viewSalesList))
            throw new SecurityException("Forbidden.");{
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
    }

    /**
     * Updates the payment method of a sale
     * @param salesId sale to update
     * @param newPaymentMethod Payment method to set
     */

    public void updateSale(User performerUser, int salesId, Sales.PaymentMethod newPaymentMethod) throws SecurityException {
        if (!performerUser.getSecurityLevel().hasRequiredLevel(viewSalesList))
            throw new SecurityException("Forbidden.");
        {
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
    }

    /**
     * Returns an item from a sale
     * @param sale the sale where the return is happening
     * @param item the item being returned
     */
    public void returnSaleItem(User performerUser,Sales sale,SaleItem item)  throws SecurityException {
            if (!performerUser.getSecurityLevel().hasRequiredLevel(viewSalesList))
                throw new SecurityException("Forbidden");
            {
                sale.returnItem(performerUser, item);
            }
        }
    //RETURN Total number of sales


    /**
     * Search Sales by salesId
     * @param performerUser
     * @param salesId
     * @returns the Sale Id if exists
     */
    public Sales searchSale(User performerUser, int salesId){
        if (salesId <= 0) {
            System.out.println("Give a valid ID number");
            return null;
        }

        for(Sales sale : sales) {
            if (sale.getSalesId() == salesId) {
                sale.printSale();
                System.out.println("Sale found with ID " + salesId + ".");
                return sale;
            }
        }
        System.out.println("Sale not found.");
        return null;
    }

    public int totalSalesCount() {
        return sales.size();
    }

    /**
     * Calculates total revenue from all sales
     * @return revenue amount
     */
    public double getTotalRevenue(User performerUser) throws SecurityException {
        if(!performerUser.getSecurityLevel().hasRequiredLevel(manageSalesList))
            throw new SecurityException("Forbidden");

        double revenue = 0;
        for (Sales sale : sales) {
            revenue += sale.getTotalamount();
        }
        System.out.println("Total revenue: " + revenue);
        return revenue;
    }
}