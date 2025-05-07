package retailhub;

/**
 * Generates a financial report for the business based on revenue, purchases, and salaries
 * It aggregates data from sales, orders and users
 */

public class FinancialReport {

    // FIELDS

    private static final SecurityLayer getReport = SecurityLayer.layer3;
    private SalesList salesList; // CONTAINS all sales data
    private OrderList orderList; // CONTAINS all order data
    private UserList userList;   // CONTAINS all user(employee) data for salaries

    /**
     * CONSTRUCTOR FOR THE FinancialReport
     * @param salesList Reference to the SalesList (for revenue calculation)
     * @param orderList Reference to the OrderList (for purchase expenses)
     * @param userList Reference to the UserList (for salary expenses)
     */
    public FinancialReport(SalesList salesList, OrderList orderList, UserList userList) {
        if(salesList.equals(null) || orderList.equals(null) || userList.equals(null)){
            throw new IllegalArgumentException("Arguments (salesList, orderList, userList) cant be null.  ");
        }
        this.salesList = salesList;
        this.orderList = orderList;
        this.userList = userList;
    }

    // METHODS

    /**
     * Generates and prints the FinancialReport
     * Total Revenue (from sales)
     * Purchase expenses (from orders)
     * Salary expenses (from employees)
     * Net profit (revenue - total expenses)
     */
    public void generateReport(User performerUser) throws SecurityException {
        if(!performerUser.getSecurityLevel().hasRequiredLevel(getReport)){
            throw new SecurityException("Forbidden");
        }
        double revenue = salesList.getTotalRevenue(); // Total income from sales
        double purchaseExpenses = orderList.getTotalPurchaseCost(); // Cost of buying products
        double salaryExpenses = userList.getTotalSalaryExpenses(performerUser); // Employee salaries

        double totalExpenses = purchaseExpenses + salaryExpenses; // Sum of all expenses
        double netProfit = revenue - totalExpenses; // Final profit after expenses

        //PRINT FINANCIAL REPORT

        System.out.println("=== Financial Report ===");
        System.out.println("Total Revenue      : €" + revenue);
        System.out.println("Purchase Expenses  : €" + purchaseExpenses);
        System.out.println("Salary Expenses    : €" + salaryExpenses);
        System.out.println("--------------------------");
        System.out.println("Net Profit         : €" + netProfit);
        System.out.println("==========================");
    }
}

