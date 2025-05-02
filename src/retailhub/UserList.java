package retailhub;

import java.util.ArrayList;
import java.util.Iterator;

public class UserList {
    private ArrayList<User> usersList;

    public UserList(){
        this.usersList = new ArrayList<User>();
    }

    // Create User to the list.

    public boolean createUser(User user){
        if(findUser(user.getUsername()) != null){
            throw new IllegalArgumentException("You must create a Unique username! ");
        }
        else{
            usersList.add(user);
            System.out.println("User: "+user+" has been created!");
            return true;
        }
    }

    public



    /**
     *Searching User
     *
     */

    public void searchUser(User username, int UserId){
        Iterator<User> iterator = usersList.iterator();
        while(iterator.hasNext()){
            User currentUser = iterator.next();
            if(currentUser.getUsername().equals(username.getUsername())){
                System.out.println("User found: "+currentUser.getUsername()); // edw prepei na balw kai alla details
                break;
            }
            else {
                System.out.println("User not found!");
            }
        }
    }

    public User findUser(String username){
        for(User user: usersList){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public boolean removeUser(String usernameToDelete, User UserIdToDelete){
        User targetUser = findUser(usernameToDelete);

        if(targetUser == null){
            System.out.println("Action failed.\n User: "+usernameToDelete+" not found.");
            return false;
        }
        else{
            usersList.remove(targetUser);
            System.out.println("User: "+usernameToDelete+" has been deleted!");
            return true;
        }
    }



    public boolean updateUser(String usernameToUpdate,User userPerformingAction,
                              User updatedUserData){
        User targetUser = findUser(usernameToUpdate);

        if(targetUser.getSecurityLevel().canUpdateUser(userPerformingAction, targetUser) ){

        }







    }




}
