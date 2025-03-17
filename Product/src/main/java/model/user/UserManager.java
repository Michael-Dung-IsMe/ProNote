package model.user;


import java.util.ArrayList;

public class UserManager {
    private static UserManager instance;
    private ArrayList<UserInfo> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(UserInfo user) { users.add(user); }

    public boolean checkUserOnList(String username, String password) {
        for (UserInfo user : users) {
            if (user.getUserEmail().equals(username) && user.getUserPassword().equals(password))
                return true;
        }
        return false;
    }

}
