package retailhub;

import javax.swing.*;
import java.awt.*;

public class SalesMenu extends JFrame {
    public SalesMenu(SalesList salesList, CustomerList customerList, ProductList productList, User performingUser) {
        this.setTitle("Sales Menu");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(6,1,10,10));

        JButton createButton = new JButton("New Sale");
        JButton searchButton = new JButton("Search Sale");
        JButton updateButton = new JButton("Update sale");
        JButton deleteButton = new JButton("Remove sale");
        JButton listButton = new JButton("Print all sales");
        JButton closeButton = new JButton("Close");

        createButton.addActionListener(e -> {
            try {
                String input = JOptionPane.showInputDialog("Please give the email or phone of the customer: ");
                Customer c = null;
                if(input.contains("@")){
                    c = customerList.getCustomerByEmail(performingUser,input);
                    JOptionPane.showMessageDialog(null,"Customer: " +c.toString());
                } else {
                    c = customerList.getCustomerByPhone(performingUser,input);
                }
                if(c!=null){
                    JOptionPane.showMessageDialog(null,c.toString());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Customer not found.");
                }
                Sales.PaymentMethod paymentMethod = (Sales.PaymentMethod) JOptionPane.showInputDialog(
                        this,
                        "Select Payment Method",
                        "Payment Method",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        Sales.PaymentMethod.values(),
                        Sales.PaymentMethod.CASH
                );
                Sales sale = new Sales(paymentMethod, c);

                boolean addProduct = true;
                while (addProduct) {
                    String idStr = JOptionPane.showInputDialog(this, "Enter Product ID:");
                    if (idStr == null || idStr.trim().isEmpty()) {
                        break;
                    }

                    int productId = Integer.parseInt(idStr);
                    Product product = productList.searchProducts(performingUser, productId);
                    if (product == null) {
                        JOptionPane.showMessageDialog(null,"Product not found.");
                        continue;
                    }
                    String strQty = JOptionPane.showInputDialog("Enter Quantity:");
                    int quantity = Integer.parseInt(strQty);

                    SaleItem saleItem = new SaleItem(performingUser, product, quantity);
                    sale.addItem(performingUser, saleItem);

                    int choice = JOptionPane.showConfirmDialog(this, "Do you want to add another product?", "Continue", JOptionPane.YES_NO_OPTION);
                    if (choice != JOptionPane.YES_OPTION) {
                        addProduct = false;
                    }

                }
                c.addSale(sale);
                LoyaltyPoints.processLoyalty(sale);
                salesList.addSaleToList(performingUser,sale);
                JOptionPane.showMessageDialog(this, "Sale created successfully! Total amount after discount :  "+ String.valueOf(sale.getTotalamount()) + " €");
                int choice = JOptionPane.showConfirmDialog(this, "Do you want a receipt?", "Continue", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    sale.receipt(performingUser);
                }
            }
            catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
            }
        });


        searchButton.addActionListener(e->{
            try{
                String inputId = JOptionPane.showInputDialog("Please give the ID of the sale you are looking for:");
                int inputIdToSearch = Integer.parseInt(inputId);
                Sales saleToSearch = null;

                saleToSearch = salesList.searchSale(performingUser, inputIdToSearch);

                if (saleToSearch != null) {
                    JOptionPane.showMessageDialog(null, saleToSearch.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Sale not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
            }

        });


        updateButton.addActionListener(e->{
            try {
                String ID = JOptionPane.showInputDialog("ID of the sale you want to update:");
                int idToUpdate = Integer.parseInt(ID);
                String newId = JOptionPane.showInputDialog("New sale ID:");
                int updatedId = Integer.parseInt(newId);
                String updatedPaymentMethod = JOptionPane.showInputDialog("Updated Payment Method:");
                Sales.PaymentMethod newMethod =  Sales.PaymentMethod.valueOf(updatedPaymentMethod);

                Sales saleToUpdate = salesList.updateSale(performingUser, updatedId, newMethod );
                if (saleToUpdate != null) {
                    JOptionPane.showMessageDialog(null, "Sale updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Sale not found.");
                }

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage());
            }

        });


        deleteButton.addActionListener(e->{
           try {
               String id = JOptionPane.showInputDialog("Please type the ID of the sale you want to delete: ");
               int idToRemove = Integer.parseInt(id);

               Sales saleToRemove = salesList.searchSale(performingUser, idToRemove);
               if (saleToRemove != null) {
                   JOptionPane.showMessageDialog(null, saleToRemove.toString());
               }
               else {
                   JOptionPane.showMessageDialog(null, "Sale not found.");
               }
               int choice = JOptionPane.showConfirmDialog(this,
                       "Are you sure you want to delete"+ saleToRemove.getSalesId() +" ?", "Continue", JOptionPane.YES_NO_OPTION);
               if (choice == JOptionPane.YES_OPTION) {
                   salesList.removeSaleFromTheList(performingUser, idToRemove);
                   JOptionPane.showMessageDialog(null, "Sale deleted successfully!");
               }
               else {
                   JOptionPane.showMessageDialog(null, "Cancelled");
               }
           } catch (Exception ex) {
               JOptionPane.showMessageDialog(this, "Invalid ID. Please enter a valid number.");
           }
        });
        listButton.addActionListener(e -> {
            try {
                int yesNo = JOptionPane.showConfirmDialog(
                        null,
                        "Print all sales?",
                        "Sales List",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );
                if (yesNo == JOptionPane.YES_OPTION) {
                    StringBuilder sb = new StringBuilder("Sales:\n");
                    for (Sales sale : salesList.getAllSales()) {
                        sb.append(sale.toString()).append("\n------------------\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
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
