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

    //TODO -> Parei aqui.
    @Override
    public void changeID(String customerCpf) {
     boolean isSameCustomer = creatCustomerImplList
                .stream()
                .anyMatch(c -> c.getCustomerCpf().equalsIgnoreCase(customerCpf));

     if (isSameCustomer) {
//         creatCustomerImplList
//                 .stream()
//                 .filter(c -> c.getCustomerCpf().equalsIgnoreCase(customerCpf))
//                 .forEach(c -> c.set));
     }

    }

    @Override
    public void changeCpf(String customerID) {

    }

    @Override
    public void changeName(String ID) {

    }

    @Override
    public void changePhone(String ID) {

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
