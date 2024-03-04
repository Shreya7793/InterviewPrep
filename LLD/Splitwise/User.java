package LLD.Splitwise;

public class User implements UserObserver{
    String userId;
    String userName;

    User(String userId, String userName){
        this.userId=userId;
        this.userName=userName;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println(userName + " received update: " + message);
    }
}
