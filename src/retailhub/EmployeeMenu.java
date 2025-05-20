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
                String phone = JOptionPane.showInputDialog("Phone:");
                String address = JOptionPane.showInputDialog("Address");
                String username = JOptionPane.showInputDialog("Username:");
                String password = JOptionPane.showInputDialog("Password:");
                String role = JOptionPane.showInputDialog("Role:");
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

                UserList.createUser(performingUser, username, password, initialLayer, name, lastName, salary, email, address, role);


            }
        });
    }
}
