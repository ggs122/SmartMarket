package br.com.users.userdefault;

import java.util.Locale;

public abstract class UsersDefault {
    private long userId = staticUserId;
    protected static long staticUserId = 20000;
    private long enrollmentNumber = staticEnrolllmentNumber;
    protected static long staticEnrolllmentNumber = 1;
    private String userName;
    private String userCpf;
    private String jobe_Tittle;
    private String userLogin;
    private String userPassword;

    private Locale localeBr = Locale.forLanguageTag("pt-BR");

    protected UsersDefault(long userId, long enrollmentNumber, String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword) {
        this.enrollmentNumber = enrollmentNumber;
        this.userId = userId;
        this.userName = userName;
        this.userCpf = userCpf;
        this.jobe_Tittle = jobe_Tittle;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    protected long getUserId() {
        return userId;
    }

    protected long getEnrollmentNumber() {
        return enrollmentNumber;
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

    public abstract void createUser(String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword);
    public abstract void userchangeName(String userCpf, String userNewName, String userLogin, String userPassword);
    public abstract void userChangeCpf(String userName, String userNewCpf, String userLogin, String userPassword);
    public abstract void userChangeGetJobe_Tittle(String userCpf, String userLogin, String userPassword, String userNewGetJobe_Tittle);
    public abstract void userChangeLoginAndPasswor(String userCpf, String userOldLogin, String userOldPassword, String userNewLogin, String userNewPassword);
    public abstract void userPrint();

    @Override
    public String toString() {
        return String.format(localeBr, "ID: %s | Nome: %s | Matrícula %s | CPF: %s | Cargo: %s | Login: %s | Senha: %s", userId, userName, enrollmentNumber, userCpf, jobe_Tittle, userLogin, userPassword);
    }
}
