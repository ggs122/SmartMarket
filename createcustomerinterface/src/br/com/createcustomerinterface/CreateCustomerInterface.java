package br.com.createcustomerinterface;

public interface CreateCustomerInterface {

    void createCustomer(String cutomerID, String customercpf, String customerName, String customerPhone);
    void deleteCustomer(String customerID);
    void changeID(String customerCpf, String newID);
    void changeCpf(String customerID, String newCustomerCpf);
    void changeName(String ID, String newName);
    void changePhone(String ID, String newCustomerPhone);
    void print();

}
