package retailhub;

import javax.swing.*;
import java.awt.*;

public class SuppliersMenu extends JFrame {

    public SuppliersMenu(SupplierList supplierList, User performingUser) {

        this.setTitle("Suppliers Menu");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(6, 1, 10, 10));

        JButton createButton = new JButton("Create a supplier");
        JButton searchButton = new JButton("Search a supplier");
        JButton updateButton = new JButton("Update a supplier");
        JButton deleteButton = new JButton("Delete a supplier");
        JButton listButton = new JButton("List of all suppliers");
        JButton closeButton = new JButton("Close");

        createButton.addActionListener(e -> {
            try {
                String taxID = JOptionPane.showInputDialog("Tax ID:");
                int taxId = Integer.parseInt(taxID);
                String name = JOptionPane.showInputDialog("Name:");
                String phone = JOptionPane.showInputDialog("Phone:");
                String address = JOptionPane.showInputDialog("Address:");
                String email = JOptionPane.showInputDialog("Email:");


                supplierList.createSupplier(performingUser, taxId, name, phone, address, email);
                JOptionPane.showInternalMessageDialog(null, "Supplier created!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        searchButton.addActionListener(e -> {
            try {
                String inputId = JOptionPane.showInputDialog("Please give the tax ID of the supplier you are looking for:");
                int inputTaxId = Integer.parseInt(inputId);
                Supplier supplier = null;
                if (supplierList.vatExists(performingUser, inputTaxId)) {
                    supplier = supplierList.getSupplierByVat(performingUser, inputTaxId);
                }
                if (supplier != null) {
                    JOptionPane.showMessageDialog(null, supplier.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Supplier not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
            }

        });


        updateButton.addActionListener(e->{
            try {
                String tax = JOptionPane.showInputDialog("Tax ID of the supplier you want to update:");
                int taxSupplierId = Integer.parseInt(tax);
                String tx = JOptionPane.showInputDialog("New Tax ID:");
                int updatedTaxId = Integer.parseInt(tx);
                String updatedName = JOptionPane.showInputDialog("New Name:");
                String updatedPhone = JOptionPane.showInputDialog("New phone:");
                String updatedAddress = JOptionPane.showInputDialog("New address:");
                String updatedEmail = JOptionPane.showInputDialog("New email:");


                Supplier supplierToUpdate = supplierList.updateSupplier(performingUser, taxSupplierId, updatedTaxId, updatedName, updatedPhone, updatedAddress, updatedEmail);
                if (supplierToUpdate != null) {
                    JOptionPane.showMessageDialog(null, "Supplier updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Supplier not found.");
                }

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage());
            }

        });


        deleteButton.addActionListener(e->{
            try{
                String taxIdToDelete = JOptionPane.showInputDialog("Please give the tax ID of the supplier you want to delete:");
                int TaxIdToDelete = Integer.parseInt(taxIdToDelete);
                Supplier supplierToDelete = supplierList.getSupplierByVat(performingUser,TaxIdToDelete);

                if(supplierToDelete!=null){
                    int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this supplier?","Supplier Deletion",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(option == JOptionPane.YES_OPTION){
                        supplierList.removeSupplierFromList(performingUser,TaxIdToDelete);
                        JOptionPane.showMessageDialog(null,"Supplier deleted.");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Supplier not found.");
                    }
                }

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage());
            }
        });

        listButton.addActionListener(e->{
            try{
                int yesNo = JOptionPane.showConfirmDialog(null,"Print all suppliers?","Suppliers List",JOptionPane.YES_NO_CANCEL_OPTION);
                if(yesNo == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Suppliers:"+supplierList.toString());
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
