package br.com.customer;

import java.util.Locale;

public final class CustomerUtills {

    private CustomerUtills() {}

    public static boolean checkingCustomerID(String customerID) {
        boolean isID;

      isID = customerID.matches("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{1}");

      if ((isID)) {
          IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de identidade: %s -> Válido.", customerID));
      } else {
          IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de identidade: %s -> Inválido.", customerID));
      }
      return isID;
    }

    public static boolean checkingCustomerCpf(String customerCpf) {
       boolean isCpf;

       isCpf = customerCpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}");

       if (isCpf) {
           IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de CPF: %s -> Válido.", customerCpf));
       } else {
           IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de CPF: %s -> Inválido", customerCpf));
       }
       return isCpf;
    }

    public static boolean checkingCustomerPhone(String customerPhone) {

        boolean isPhone;

        isPhone = customerPhone.matches("^\\(?[0-9]{2}\\)?\\s?(?:9[0-9]{4}|[0-9]{4})?[-.\\s]?[0-9]{4}$");

        if (isPhone) {
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de telefone: %s -> Válido.", customerPhone));
        } else {
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Formato de telefone: %s -> Inválido.", customerPhone));
        }
        return isPhone;
    }
}
