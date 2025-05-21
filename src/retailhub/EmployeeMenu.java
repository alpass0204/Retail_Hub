package retailhub;

import javax.swing.*;
import java.awt.*;

public class EmployeeMenu extends JFrame {

    public EmployeeMenu(UserList userList, User performingUser) {

        this.setTitle("Employees Menu");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(6,1,10,10));

        JButton createButton = new JButton("Create an employee");
        JButton searchButton = new JButton("Search an employee");
        JButton updateButton = new JButton("Update an employee");
        JButton deleteButton = new JButton("Delete an employee");
        JButton listButton = new JButton("List of all employees");
        JButton closeButton = new JButton("Close");

        createButton.addActionListener(e-> {
            try {
                String name = JOptionPane.showInputDialog("Name:");
                String lastName = JOptionPane.showInputDialog("Lastname:");
                String email = JOptionPane.showInputDialog("Email:");
                String address = JOptionPane.showInputDialog("Address");
                String username = JOptionPane.showInputDialog("Username:");
                String password = JOptionPane.showInputDialog("Password:");
                Role role = (Role) JOptionPane.showInputDialog(this, "Select role for the new user: ", "Role Selection",
                        JOptionPane.QUESTION_MESSAGE, null, Role.values(), Role.analyst
                );
                SecurityLayer initialLayer = (SecurityLayer) JOptionPane.showInputDialog(
                        this,
                        "Select security layer :",
                        "Security Level selection",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        SecurityLayer.values(),
                        SecurityLayer.layer1
                );


                String salaryStr = JOptionPane.showInputDialog("Salary:");
                double salary = Double.parseDouble(salaryStr);

                userList.createUser(performingUser, username, password, initialLayer, name, lastName, salary, email, address, role);


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        searchButton.addActionListener(e-> {
            try {
                String username = JOptionPane.showInputDialog("Enter the username of the employee you want to search: ");
                if (username == null) {
                    return;
                }
                User user = userList.searchUser(username);
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                }
                else {
                    JOptionPane.showMessageDialog(null,user.toString());
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        updateButton.addActionListener(e-> {
            try {
                String username = JOptionPane.showInputDialog("Enter the username of the employee you want to update: ");
                if (username == null) {
                    return;
                }
                User user = userList.searchUser(username);
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                    return;
                }

                if (!(user instanceof Employee)) {
                    JOptionPane.showMessageDialog(null, "This user is not an employee.");
                    return;
                }
                Employee employee = (Employee) user;

                String updateName =  JOptionPane.showInputDialog("Name:");
                String updateLastName = JOptionPane.showInputDialog("Last name:");
                String updateEmail = JOptionPane.showInputDialog("Email:");
                String updateAddress = JOptionPane.showInputDialog("Address:");
                String updateUsername = JOptionPane.showInputDialog("Username:");
                String updatePassword = JOptionPane.showInputDialog("Password:");
                Role newRole = (Role) JOptionPane.showInputDialog(
                        this, "Select role:", "Role Selection", JOptionPane.QUESTION_MESSAGE, null, Role.values(), Role.analyst
                );
                SecurityLayer newLayer = (SecurityLayer) JOptionPane.showInputDialog(
                        this,
                        "Select security layer:",
                        "Security Layer Selection",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        SecurityLayer.values(),
                        SecurityLayer.layer1
                );
                String salaryStr = JOptionPane.showInputDialog("Salary:");
                double salary = Double.parseDouble(salaryStr);

                employee.setName(updateName);
                employee.setLastName(updateLastName);
                employee.setEmail(updateEmail);
                employee.setAddress(updateAddress);
                employee.setUsername(updateUsername);
                employee.setPassword(updatePassword);
                employee.setRole(newRole);
                employee.setSalary(salary);

                JOptionPane.showMessageDialog(null, employee.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteButton.addActionListener(e-> {
            try {
                String username =  JOptionPane.showInputDialog("Enter username of the employee you want to delete: ");
                if (username == null) {
                    return;
                }
                User user = userList.searchUser(username);
                if (user == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                    return;
                }

                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete employee " + username + "?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    userList.removeUser(performingUser,  username);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Failed to delete user.");
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error:"+ex.getMessage());
            }
        });

        listButton.addActionListener(e-> {
            try{
                int yesNo = JOptionPane.showConfirmDialog(null,"Print all employees?","Employees List",JOptionPane.YES_NO_CANCEL_OPTION);
                if(yesNo == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Employees: "+userList.getAllUsersString(performingUser));
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
