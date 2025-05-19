package retailhub;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    JButton customersButton = new JButton("Customers");

    public MainMenu(CustomerList customerList, User loggedInUser){



        this.setTitle("Retail Hub - Main Menu");
        this.setSize(350,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,1,10,10));
        this.setLocationRelativeTo(null);

        customersButton.addActionListener(e -> {
            new CustomerMenu(customerList,loggedInUser);
            this.dispose();
        });

        this.add(customersButton);

        this.setVisible(true);

    }


}
