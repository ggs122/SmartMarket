package br.com.users;

import java.util.Locale;

public final class UserUtills {

    private UserUtills() {}

    public static boolean checkingCpf(String userCpf) {
        boolean isCpf;

       isCpf = userCpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}");

        if (isCpf) {
            IO.println("--------------------------------------------------------------------------------------------------------");
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de CPF: %s -> Válido.", userCpf));
            IO.println("--------------------------------------------------------------------------------------------------------");
        } else {
            IO.println("--------------------------------------------------------------------------------------------------------");
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de CPF: %s -> Inválido", userCpf));
            IO.println("--------------------------------------------------------------------------------------------------------");
        }
        return isCpf;
    }

    public static boolean checkingLogin(String userLogin) {
       boolean isLogin = userLogin.matches("[A-Z]{1}[0-9]?[a-z]{6}");

        if (isLogin) {
            IO.println("--------------------------------------------------------------------------------------------------------");
            IO.println("Formato de login válido");
            IO.println("--------------------------------------------------------------------------------------------------------");
        } else {
            IO.println("--------------------------------------------------------------------------------------------------------");
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de login: %s -> Inválido", isLogin));
            IO.println("--------------------------------------------------------------------------------------------------------");
        }
        return isLogin;
    }

    public static boolean checkingPassword(String userPassword) {
        boolean isPassword;

       isPassword = userPassword.matches("[0-9]{6}");

        if (isPassword) {
            IO.println("--------------------------------------------------------------------------------------------------------");
            IO.println("Formato de login válido");
            IO.println("--------------------------------------------------------------------------------------------------------");
        } else {
            IO.println("--------------------------------------------------------------------------------------------------------");
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de senha: %s -> Inválido", isPassword));
            IO.println("--------------------------------------------------------------------------------------------------------");
        }
        return isPassword;
    }

}
