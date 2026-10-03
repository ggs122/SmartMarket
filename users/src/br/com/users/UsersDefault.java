package br.com.users;

public abstract class UsersDefault {
    private int userId;
    private static int staticUserId;
    private String userName;
    private String userCpf;
    private String jobe_Tittle;
    private String userLogin;
    private String userPassword;

    private UsersDefault(int userId, String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userCpf = userCpf;
        this.jobe_Tittle = jobe_Tittle;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    protected int getUserId() {
        return userId;
    }

    protected String getUserName() {
        return userName;
    }

    protected String getUserCpf() {
        return userCpf;
    }

    protected String getJobe_Tittle() {
        return jobe_Tittle;
    }

    protected String getUserLogin() {
        return userLogin;
    }

    protected String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "UsersDefault{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCpf='" + userCpf + '\'' +
                ", jobe_Tittle='" + jobe_Tittle + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
