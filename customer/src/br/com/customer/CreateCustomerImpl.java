package br.com.customer;

import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.customer.customerdefault.CustomerDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateCustomerImpl extends CustomerDefault implements CreateCustomerInterface {

    private Locale localeBr = Locale.forLanguageTag("pt-BR");


    protected CreateCustomerImpl(long customerId, String customerID, String customerCpf, String customerName, String customerPhone) {
        super(customerId, customerID, customerCpf, customerName, customerPhone);
    }

    public CreateCustomerImpl() {
        super();
    }

    static List<CreateCustomerImpl> creatCustomerImplList = new ArrayList<>();

    @Override
    public void createCustomer(String cutomerID, String customerCpf, String customerName, String customerPhone) {
        boolean isCustomerID = CustomerUtills.checkingCustomerID(cutomerID);
        boolean isCustomerCpf = CustomerUtills.checkingCustomerCpf(customerCpf);
        boolean isCustomerPhone = CustomerUtills.checkingCustomerPhone(customerPhone);
        boolean isSameCustomer = checkingIsSameCustomer(cutomerID, customerCpf);
        if (isCustomerID) {
            if (isCustomerCpf) {
                if (isCustomerPhone) {
                    if (isSameCustomer) {
                        CreateCustomerImpl createCustomer = new CreateCustomerImpl(CustomerDefault.customerIdStatic++, cutomerID, customerCpf, customerName, customerPhone);
                        creatCustomerImplList.add(createCustomer);
                        if (!creatCustomerImplList.isEmpty()) {
                            IO.println("--------------------------------------------------------------------------------------------------------------------");
                            IO.println("Cliente cadastrado com sucesso:");
                            creatCustomerImplList
                                    .stream()
                                    .filter(c -> c.getCustomerID().equalsIgnoreCase(cutomerID) && c.getCustomerCpf().equalsIgnoreCase(customerCpf) && c.getCustomerName().equalsIgnoreCase(customerName) && c.getCustomerPhone().equalsIgnoreCase(customerPhone))
                                    .forEach(c -> IO.println(c));
                            IO.println("--------------------------------------------------------------------------------------------------------------------");
                        } else {
                            IO.println("Nenhum cliente foi cadastrado -> Cadastre!");
                        }
                    } else {
                        IO.println("--------------------------------------------------------------------------------------------------------");
                        IO.println(String.format(localeBr, "Impossível cadastrar o cliente com identidade N°: %s e CPF Nº: %s", cutomerID, customerCpf));
                        IO.println("--------------------------------------------------------------------------------------------------------");
                    }
                } else {
                    IO.println("--------------------------------------------------------------------------------------------------------");
                    IO.println(String.format(localeBr, "Impossível cadastrar o cliente com o formato de telefone: %s.\nFavor digite um formato válido.", customerPhone));
                    IO.println("--------------------------------------------------------------------------------------------------------");
                }
            } else {
                IO.println("--------------------------------------------------------------------------------------------------------");
                IO.println(String.format(localeBr, "Impossível cadastrar o cliente com o formato de CPF: %s.\nFavor digite um formato válido.", customerCpf));
                IO.println("--------------------------------------------------------------------------------------------------------");
            }
        } else {
            IO.println("--------------------------------------------------------------------------------------------------------");
            IO.println(String.format(localeBr, "Impossível cadastrar o cliente com o formato de identidade: %s.\nFavor digite um formato válido.", cutomerID));
            IO.println("--------------------------------------------------------------------------------------------------------");
        }

    }

    private boolean checkingIsSameCustomer(String ID, String cpf) {
        boolean finalResult;

      boolean isSameID = creatCustomerImplList
                .stream()
                .anyMatch(c -> c.getCustomerID().equalsIgnoreCase(ID));

      boolean isSameCpf = creatCustomerImplList
              .stream()
              .anyMatch(c -> c.getCustomerCpf().equalsIgnoreCase(cpf));

        if (isSameID && isSameCpf || isSameID || isSameCpf) {
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Cliente com Identidade Nº: %s e CPF Nº %s -> já cadastrado anteriormente.", ID, cpf));
            finalResult = false;
        } else {
            IO.println(String.format(Locale.forLanguageTag("pt-BR"), "Cliente com Identidade Nº: %s e CPF Nº %s -> cadastrado com sucesso!.", ID, cpf));
            finalResult = true;
        }
        return finalResult;
    }

    @Override
    public void deleteCustomer(String customerID) {
       boolean isSameCustomer = creatCustomerImplList
                .stream()
                .anyMatch(c -> c.getCustomerID().equalsIgnoreCase(customerID));

       if (isSameCustomer) {
           creatCustomerImplList.removeIf(c -> c.getCustomerID().equalsIgnoreCase(customerID));
           IO.println("--------------------------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Cliente, identidade N° %s -> deletado com sucesso do sistema.", customerID));
           IO.println("--------------------------------------------------------------------------------------------------------");
       } else {
           IO.println("--------------------------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Identidade: %s -> Inexistente!", customerID));
           IO.println("--------------------------------------------------------------------------------------------------------");
       }

    }


    @Override
    public void changeID(String customerCpf, String newCustomerID) {
        boolean isIDFormat = CustomerUtills.checkingCustomerID(newCustomerID);
        boolean isSameCustomer = creatCustomerImplList
                .stream()
                .anyMatch(c -> c.getCustomerCpf().equalsIgnoreCase(customerCpf));

     if (isSameCustomer) {
         if (isIDFormat) {
             creatCustomerImplList
                     .stream()
                     .filter(c -> c.getCustomerCpf().equalsIgnoreCase(customerCpf))
                     .forEach(c -> c.setCustomerID(newCustomerID));
             IO.println("-------------------------------------------------------------------------------");
             IO.println("Alteração realizada com sucesso!");
             creatCustomerImplList
                     .stream()
                             .filter(c -> c.getCustomerCpf().equalsIgnoreCase(customerCpf))
                                     .forEach(c -> IO.println(String.format(localeBr, "Nova identidade N° %s", c.getCustomerID())));
             IO.println("-------------------------------------------------------------------------------");
         } else {
             IO.println("-------------------------------------------------------------------------------");
             IO.println("Digite um formato válido!");
             IO.println("-------------------------------------------------------------------------------");
         }
     } else {
         IO.println("-------------------------------------------------------------------------------");
         IO.println(String.format(localeBr, "Formato do CPF: %s, inválido ou CPF inexistente!", customerCpf));
         IO.println("-------------------------------------------------------------------------------");
     }

    }

    @Override
    public void changeCpf(String customerID, String newCustomerCpf) {
       boolean isSimilarCustomerID = creatCustomerImplList
                .stream()
                .anyMatch(c -> c.getCustomerID().equalsIgnoreCase(customerID));

       if (isSimilarCustomerID) {
         boolean isFormatCpf = CustomerUtills.checkingCustomerCpf(newCustomerCpf);
           if (isFormatCpf) {
               creatCustomerImplList
                       .stream()
                       .filter(c -> c.getCustomerID().equalsIgnoreCase(customerID))
                       .forEach(c -> c.setCustomerCpf(newCustomerCpf));
               IO.println("---------------------------------------------------------------------");
               IO.println("Alteração realizada com sucesso!");
               creatCustomerImplList
                       .stream()
                       .filter(c -> c.getCustomerID().equalsIgnoreCase(customerID))
                       .forEach(c -> IO.println(String.format(localeBr, "Novo CPF N° -> %s", c.getCustomerCpf())));
               IO.println("---------------------------------------------------------------------");
           } else {
               IO.println("-------------------------------");
               IO.println("Digite um número de CPF válido.");
               IO.println("-------------------------------");
           }
       } else {
           IO.println("------------------------------------------------------------------------");
           IO.println(String.format(localeBr,"Identidade N° %s -> Inválido ou inexistente", customerID));
           IO.println("------------------------------------------------------------------------");
       }
    }

    @Override
    public void changeName(String customerID, String newName) {
      boolean isSimilarCustomerID = creatCustomerImplList
                .stream()
                .anyMatch(c -> c.getCustomerID().equalsIgnoreCase(customerID));

      if (isSimilarCustomerID) {
          creatCustomerImplList
                  .stream()
                  .filter(c -> c.getCustomerID().equalsIgnoreCase(customerID))
                  .forEach(c -> {
                      IO.println("------------------------------------------------------------------------");
                      IO.println("Alteração realizada com sucesso!");
                          c.setCustomerName(newName);

                          creatCustomerImplList
                                  .stream()
                                  .filter(cr -> cr.getCustomerID().equalsIgnoreCase(customerID))
                                  .forEach(cr -> IO.println(String.format(localeBr, "Novo Nome -> %s", cr.getCustomerName())));
                      IO.println("------------------------------------------------------------------------");
                  });
      } else {
          IO.println("------------------------------------------------------------------------");
          IO.println(String.format(localeBr,"Identidade N° %s -> Inválido ou inexistente", customerID));
          IO.println("------------------------------------------------------------------------");
      }
    }

    @Override
    public void changePhone(String customerID, String newCustomerPhone) {
       boolean isSameID = creatCustomerImplList
                .stream()
                .anyMatch(c -> c.getCustomerID().equalsIgnoreCase(customerID));

       if (isSameID) {
           boolean isPhoneFormat = CustomerUtills.checkingCustomerPhone(newCustomerPhone);
           if (isPhoneFormat) {
               creatCustomerImplList
                       .stream()
                       .filter(c -> c.getCustomerID().equalsIgnoreCase(customerID))
                       .forEach(c -> {
                           c.setCustomerPhone(newCustomerPhone);
                           IO.println("------------------------------------------------------------------------------------------------");
                           IO.println(String.format(localeBr, "Telefone N° alterado com sucesso para -> %s", c.getCustomerPhone()));
                           IO.println("------------------------------------------------------------------------------------------------");
                       });
           } else {
               IO.println("------------------------------------------------------------------------------------------------");
               IO.println("Digite um formato de telefone válido!");
               IO.println("------------------------------------------------------------------------------------------------");
           }

       } else {
           IO.println("------------------------------------------------------------------------");
           IO.println(String.format(localeBr,"Identidade N° %s -> Inválido ou inexistente", customerID));
           IO.println("------------------------------------------------------------------------");
       }
    }

    @Override
    public void print() {
        if (!creatCustomerImplList.isEmpty()) {
            IO.println("---------------------------------------------------------------------------------------------------------------------------");
            IO.println("Lista de Clientes cadastrados:");
            creatCustomerImplList
                    .stream()
                    .forEach(c -> IO.println(c));
            IO.println("---------------------------------------------------------------------------------------------------------------------------");
        } else {
            IO.println("---------------------------------------------------------------------------------------------------------------------------");
            IO.println("Não foi cadastrado nenhum cliente -> Impossível mostrar lista de clientes cadastrados.");
            IO.println("---------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
