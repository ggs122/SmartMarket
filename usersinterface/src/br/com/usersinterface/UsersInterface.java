package br.com.usersinterface;

public interface UsersInterface {

    void createUser(String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword);
    void userchangeName(String userCpf, String userNewName, String userLogin, String userPassword);
    void userChangeCpf(String userName, String userNewCpf, String userLogin, String userPassword);
    void userChangeGetJobe_Tittle(String userCpf, String userLogin, String userPassword, String userNewGetJobe_Tittle);
    void userChangeLoginAndPasswor(String userCpf, String userOldLogin, String userOldPassword, String userNewLogin, String userNewPassword);

}
