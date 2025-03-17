package model.user;

public class UserInfo {
    private String username, userEmail, userPassword;
    private int userID;
    private static UserInfo instance;

    // getInstance
    public static UserInfo getInstance() {
        if (instance == null) {
            instance = new UserInfo();
        }
        return instance;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
