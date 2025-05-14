package retailhub;

import java.util.Scanner;

public class LoyaltyPoints {

    private static final int POINTS_PER_EURO = 1; // 1 πόντος για κάθε 5€
    private static final int EURO_STEP = 5;

    private static final int POINTS_REQUIRED_STEP = 100;
    private static final double DISCOUNT_PER_STEP = 5;

    /**
     * Processes loyalty points for a given sale:
     * - Adds points based on total amount
     * - Checks if the customer can redeem points
     * - Applies fixed discount if user agrees
     */
    public static void processLoyalty(Sales sale) {
        if (sale == null || sale.getCustomer() == null) {
            System.out.println("Invalid sale or customer.");
            return;
        }
        // Get customer and total amount paid
        Customer customer = sale.getCustomer();
        double amountPaid = sale.getTotalamount();

        // Calculate loyalty points earned (1 point per 5€ spent)
        int earnedPoints = (int) (amountPaid / EURO_STEP) * POINTS_PER_EURO;
        customer.addPoints(earnedPoints);
        // Display loyalty status
        System.out.println("The customer " + customer.getName() +
                " earn " + earnedPoints + " points.");
        System.out.println("Total points now: " + customer.getLoyaltyPoints());

        // Check if the customer has enough points to redeem
        int availablePoints = customer.getLoyaltyPoints();
        int sets = availablePoints / POINTS_REQUIRED_STEP;

        if (sets > 0) {
            // Calculate total discount (5€ per 100 points)
            double discountAmount = sets * DISCOUNT_PER_STEP;  // FIXED: 5€ per 100 points

            // Ask user if they want to redeem points
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to redeem? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("ναι") || response.equals("yes")) {

                // Redeem points and apply discount
                int pointsToDeduct = sets * 100;
                customer.setLoyaltyPoints(availablePoints - pointsToDeduct);

                System.out.println(" Discount: " + discountAmount + "€.");
                System.out.println(" Removed " + pointsToDeduct + " points.");
                System.out.println(" Points balance: " + customer.getLoyaltyPoints());

                // Update sale total
                sale.setTotalamount(amountPaid - discountAmount);
            } else {
                System.out.println("Not redeemed. Points remain.");
            }
        } else {
            System.out.println("Not enough points for a discount.");
        }
    }
}
