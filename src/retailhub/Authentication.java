package retailhub;

import java.util.Scanner;

public class Authentication {
    public static boolean login(String username, UserList userlist) {
        Scanner in = new Scanner(System.in);

        User user = userlist.findUser(username);
        if (user == null) {
            System.out.println("Invalid Username.");
            return false;
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter password: ");
            String password = in.nextLine();
            if (password.equals(user.getPassword())) {
                System.out.println("Welcome " + username +".");
                return true;
            }
            else {
                System.out.println("Incorrect password. Try again. " + i + " attempts.");
            }
        }
        System.out.println("Too many failed attempts.");
        return false;
    }
}
