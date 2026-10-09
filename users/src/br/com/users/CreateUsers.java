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
        boolean isFormatCpf = UserUtills.checkingCpf(userCpf);
       boolean isLogin = users
                .stream()
                .anyMatch(u -> u.getUserCpf().equalsIgnoreCase(userCpf) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword));

       if (isLogin) {
           if (isFormatCpf) {
               users
                       .stream()
                       .filter(u -> u.getUserCpf().equalsIgnoreCase(userCpf) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword))
                       .forEach(u -> u.setUserName(userNewName));
               users
                       .stream()
                       .filter(u -> u.getUserCpf().equalsIgnoreCase(userCpf) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword))
                       .forEach(u -> IO.println(String.format(localeBr, "Nome de usuário alterado para -> %s", u.getUserName())));
           } else {
               IO.println(String.format(localeBr, "Formato de CPF: %s -> Inválido.", userCpf));
           }

       } else {
           IO.println("Login falhou!");
       }
    }

    @Override
    public void userChangeCpf(String userName, String userNewCpf, String userLogin, String userPassword) {
        boolean isFormatCpf = UserUtills.checkingCpf(userNewCpf);
        boolean isLogin = users
                .stream()
                .anyMatch(u -> u.getUserName().equalsIgnoreCase(userName) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword));

        if (isLogin) {
            if (isFormatCpf) {
                users
                        .stream()
                        .filter(u -> u.getUserName().equalsIgnoreCase(userName) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword))
                        .forEach(u -> u.setUserCpf(userNewCpf));
                users
                        .stream()
                        .filter(u -> u.getUserName().equalsIgnoreCase(userName) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword))
                        .forEach(u -> IO.println(String.format(localeBr, "CPF de usuário alterado para -> %s", u.getUserCpf())));
            } else {
                IO.println(String.format(localeBr, "Formato de CPF: %s -> Inválido!", userNewCpf));
            }

        } else {
            IO.println("Login falhou!");
        }
    }

    @Override
    public void userChangeGetJobe_Tittle(String userCpf, String userLogin, String userPassword, String userNewGetJobe_Tittle) {
        boolean isFormatCpf = UserUtills.checkingCpf(userCpf);
        boolean isLogin = users
                .stream()
                .anyMatch(u -> u.getUserCpf().equalsIgnoreCase(userCpf) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword));

        if (isLogin) {
            if (isFormatCpf) {
                users
                        .stream()
                        .filter(u -> u.getUserCpf().equalsIgnoreCase(userCpf) && userLogin.equalsIgnoreCase(userLogin) && userPassword.equalsIgnoreCase(userPassword))
                        .forEach(u -> u.setJobe_Tittle(userNewGetJobe_Tittle));
            } else {
                IO.println(String.format(localeBr, "Formato de CPF: %s -> Inválido!", userCpf));
            }
        } else {
            IO.println("Login Falhou!");
        }
    }

    @Override
    public void userChangeLoginAndPasswor(String userCpf, String userOldLogin, String userOldPassword, String userNewLogin, String userNewPassword) {
       boolean formatIsCpf = UserUtills.checkingCpf(userCpf);
       boolean isOldLoginFormat = UserUtills.checkingLogin(userOldLogin);
       boolean isOldPasswordFormat = UserUtills.checkingPassword(userOldPassword);

      boolean isLogin = users
                .stream()
                .anyMatch(u -> u.getUserCpf().equalsIgnoreCase(userCpf) && u.getUserLogin().equalsIgnoreCase(userOldLogin) && u.getUserPassword().equalsIgnoreCase(userOldPassword));
      if (isLogin) {
          if (formatIsCpf) {
              if (isOldLoginFormat) {
                  if (isOldPasswordFormat) {
                      users
                              .stream()
                              .filter(u -> u.getUserCpf().equalsIgnoreCase(userCpf) && u.getUserLogin().equalsIgnoreCase(userOldLogin) && u.getUserPassword().equalsIgnoreCase(userOldPassword))
                              .forEach(u -> {
                                  u.setUserLogin(userNewLogin);
                                  u.setUserPassword(userNewPassword);
                                  IO.println("Login e Senha Alterados com sucesso!");
                              });
                  } else {
                  IO.println("Impossível alterar login e senha!");
                  }
              } else {
                  IO.println("Impossível alterar login e senha!");
              }
          } else {
              IO.println("Impossível alterar Login e Senha!");
          }
      } else {
          IO.println("Login falhou!");
      }
    }

    @Override
    public void userPrint() {
        if (!users.isEmpty()) {
            users
                    .stream()
                    .forEach(u -> IO.println(u));
        } else {
            IO.println("Logins não cadastrados. Cadastre!");
        }

    }
}
