 enum userState{
    NEW,ACTIVE,BLOKED,BANNED

}
public class WebUser {

    private String login_Id;
    private String password;
    private userState state;

    public WebUser(String login_Id, String password) {
        this.login_Id = login_Id;
        this.password = password;
        this.state = userState.NEW;
    }

    public String getLogin_Id() {
        return login_Id;
    }

    public void setLogInId(String logInId) {
        this.login_Id = logInId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public userState getState() {
        return state;
    }

    public void setState(userState state) {
        this.state = state;
    }
}