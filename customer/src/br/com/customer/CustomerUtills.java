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

        customerPhone.matches("");

    }

    static void main(String[] args) {

       boolean testBoolean = CustomerUtills.checkingCustomerID("15.235.589-7");
        System.out.println(testBoolean);

        boolean testBoolean2 = CustomerUtills.checkingCustomerCpf("256.652.195-75");
        System.out.println(testBoolean2);
    }

}
