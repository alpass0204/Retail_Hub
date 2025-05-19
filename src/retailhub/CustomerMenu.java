package retailhub;

import javax.swing.*;
import java.awt.*;

public class CustomerMenu extends JFrame {

    public CustomerMenu(CustomerList customerList, User performingUser){

        this.setTitle("Customers Menu");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(6,1,10,10));

        JButton createButton = new JButton("Create a customer");
        JButton searchButton = new JButton("Search a customer");
        JButton updateButton = new JButton("Update a customer");
        JButton deleteButton = new JButton("Delete a customer");
        JButton listButton = new JButton("List of all customers");
        JButton closeButton = new JButton("Close");

        createButton.addActionListener(e->{
            try {
                String name = JOptionPane.showInputDialog("Name:");
                String email = JOptionPane.showInputDialog("Email:");
                String phone = JOptionPane.showInputDialog("Phone:");
                String gender = JOptionPane.showInputDialog("Gender:");
                String ageStr = JOptionPane.showInputDialog("Age:");
                int age = Integer.parseInt(ageStr);

                customerList.createCustomer(performingUser, name, email, phone, gender, age);
                JOptionPane.showInternalMessageDialog(null, "Customer created!");
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
            });

        searchButton.addActionListener(e-> {
            try {
                String input = JOptionPane.showInputDialog("Please give the email or phone of the customer you are looking for:");
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
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage());
            }

        });

        updateButton.addActionListener(e->{
            try {
                String emailToUpdate = JOptionPane.showInputDialog("Email of the customer you want to update:");
                String updatedName = JOptionPane.showInputDialog("New Name:");
                String updatedEmail = JOptionPane.showInputDialog("New email:");
                String updatedPhone = JOptionPane.showInputDialog("New phone:");
                String updatedGender = JOptionPane.showInputDialog("New gender:");
                String updatedAgeStr = JOptionPane.showInputDialog("New age:");
                int updatedAge = Integer.parseInt(updatedAgeStr);

                Customer customerToUpdate = customerList.getCustomerByEmail(performingUser, emailToUpdate);

                if (customerToUpdate != null) {
                    customerList.updateCustomer(performingUser, emailToUpdate, updatedName, updatedEmail, updatedPhone, updatedGender, updatedAge);
                    JOptionPane.showMessageDialog(null, "Customer updated successfully!");

                } else {
                    JOptionPane.showMessageDialog(null, "Customer not found.");
                }
            }
            catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage());
            }

        });

        deleteButton.addActionListener(e->{
            try{
                String inputToDelete = JOptionPane.showInputDialog("Please give the email or phone of the customer you want to delete:");
                Customer c = null;
                if(inputToDelete.contains("@")){
                    c = customerList.getCustomerByEmail(performingUser,inputToDelete);
                } else {
                    c = customerList.getCustomerByPhone(performingUser,inputToDelete);
                }
                if(c!=null){
                    int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this customer?","Customer Deletion",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(option == JOptionPane.YES_OPTION){
                        customerList.removeCustomer(performingUser,c);
                        JOptionPane.showMessageDialog(null,"Customer deleted.");
                    }

                else{
                    JOptionPane.showMessageDialog(null,"Customer not found.");
                    }
                }

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage());
            }
        });

        listButton.addActionListener(e->{
            try{
                int yesNo = JOptionPane.showConfirmDialog(null,"Print all customers?","Customers List",JOptionPane.YES_NO_CANCEL_OPTION);
                if(yesNo == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Customers:"+customerList.toString());
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        closeButton.addActionListener(e-> dispose());

        this.add(createButton);
        this.add(searchButton);
        this.add(updateButton);
        this.add(deleteButton);
        this.add(listButton);
        this.add(closeButton);

        this.setVisible(true);

    }
}
