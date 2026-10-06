package br.com.users;

import br.com.users.userdefault.UsersDefault;

import java.util.ArrayList;
import java.util.List;

public class CreateUsers extends UsersDefault {

    static List<CreateUsers> users = new ArrayList<>();


    protected CreateUsers(long userId, long enrollmentNumber, String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword) {
        super(userId, enrollmentNumber, userName, userCpf, jobe_Tittle, userLogin, userPassword);
    }

    @Override
    public void createUser(String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword) {

    }

    @Override
    public void userchangeName(String userCpf, String userNewName, String userLogin, String userPassword) {

    }

    @Override
    public void userChangeCpf(String userName, String userNewCpf, String userLogin, String userPassword) {

    }

    @Override
    public void userChangeGetJobe_Tittle(String userCpf, String userLogin, String userPassword, String userNewGetJobe_Tittle) {

    }

    @Override
    public void userChangeLoginAndPasswor(String userCpf, String userOldLogin, String userOldPassword, String userNewLogin, String userNewPassword) {

    }

    @Override
    public void userPrint() {

    }
}
