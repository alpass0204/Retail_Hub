package retailhub;

import javax.swing.*;
import java.awt.*;

public class AuthenticationGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton clearButton;
    private JPanel mainPanel;

    // --- Τα νέα πεδία που κρατούν τις λίστες για να περάσουν στο MainMenu ---
    private final CustomerList customerList;
    private final ProductList productList;
    private final SupplierList supplierList;

    public AuthenticationGUI(UserList userList,
                             CustomerList customerList,
                             ProductList productList,
                             SupplierList supplierList,
                             SalesList salesList) {

        this.customerList = customerList;
        this.productList = productList;
        this.supplierList = supplierList;

        setTitle("Retail Hub - Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== UI Setup =====
        mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Log In");
        clearButton = new JButton("Clear");

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(new JLabel("Username:"));
        mainPanel.add(usernameField);
        mainPanel.add(new JLabel("Password:"));
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(clearButton);

        add(mainPanel);
        setVisible(true);

        // ===== Button Logic =====
        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            User user = userList.findUser(username);

            if (user != null && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "Welcome, " + username + "!");
                dispose(); // Κλείνει το login window

                // Άνοιγμα του MainMenu με ΟΛΕΣ τις λίστες
                new MainMenu(customerList, productList, supplierList, user);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

