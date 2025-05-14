package retailhub;


import java.util.Scanner;

    /**
     * The Authentication class provides a mechanism to authenticate
     * users through a login process. The process includes validating
     * a username against a user list and verifying the corresponding
     * password with up to 3 attempts.
     */
    public class Authentication {
        public static User login(String username, UserList userlist) {
            Scanner in = new Scanner(System.in);

            User user = userlist.findUser(username);
            if (user == null) {
                //System.out.println("Invalid Username.");
                return null;
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter password: ");
                String password = in.nextLine();
                if (password.equals(user.getPassword())) {
                    System.out.println("Welcome " + username + ".");

                    return user;
                } else {
                    System.err.println("Wrong password/username. Please try again . " + i + "/3 attempts.");
                }
            }
            System.out.println("Too many failed attempts.");
            return null;
        }
    }



