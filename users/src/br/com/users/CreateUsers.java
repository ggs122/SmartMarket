package br.com.users;

import br.com.users.userdefault.UsersDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateUsers extends UsersDefault {

    private Locale localeBr = Locale.forLanguageTag("pt-BR");
    static List<CreateUsers> users = new ArrayList<>();


    private CreateUsers(long userId, long enrollmentNumber, String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword) {
        super(userId, enrollmentNumber, userName, userCpf, jobe_Tittle, userLogin, userPassword);
    }

    @Override
    public void createUser(String userName, String userCpf, String jobe_Tittle, String userLogin, String userPassword) {
        boolean isPassCpfFormat = UserUtills.checkingCpf(userCpf);
        boolean isLoginFormat = UserUtills.checkingLogin(userLogin);
        boolean isPassWordFormat = UserUtills.checkingPassword(userPassword);

        if (isPassCpfFormat) {
            if (isLoginFormat) {
                if (isPassWordFormat) {
                    CreateUsers createUsers = new CreateUsers(staticUserId++, staticEnrolllmentNumber++, userName, userCpf, jobe_Tittle, userLogin, userPassword);
                    users.add(createUsers);
                } else {
                    IO.println(String.format(localeBr, "Formato de senha: %s -> Inválido", userPassword));
                }
            } else {
                IO.println(String.format(localeBr, "Formato de Login: %s -> Inválido!", userLogin));
            }
        } else {
            IO.println(String.format(localeBr, "Formato de CPF: %s -> Inválido", userCpf));
        }


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
