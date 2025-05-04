package retailhub;

//calculate from userlist for salaries saleslist for sales revenues and orderlist for purchase expenses
//DEN TA EBALA MAIN NA JERETE O THEOS KAI I PSIHI MAS|| EPISIS ola ginan se lists gia na ta pairnei soreytika

public class FinancialReport {
    private SalesList salesList;
    private OrderList orderList;
    private UserList userList;

    public FinancialReport(SalesList salesList, OrderList orderList, UserList userList) {
        this.salesList = salesList;
        this.orderList = orderList;
        this.userList = userList;
    }

    public void generateReport() {
        double revenue = salesList.getTotalRevenue();
        double purchaseExpenses = orderList.getTotalPurchaseCost();
        double salaryExpenses = userList.getTotalSalaryExpenses();

        double totalExpenses = purchaseExpenses + salaryExpenses;
        double netProfit = revenue - totalExpenses;

        System.out.println("=== Financial Report ===");
        System.out.println("Total Revenue      : €" + revenue);
        System.out.println("Purchase Expenses  : €" + purchaseExpenses);
        System.out.println("Salary Expenses    : €" + salaryExpenses);
        System.out.println("--------------------------");
        System.out.println("Net Profit         : €" + netProfit);
        System.out.println("==========================");
    }
}

