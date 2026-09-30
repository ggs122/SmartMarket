package br.com.createcustomerinterface;

public interface CreateCustomerInterface {

    void createCustomer(String cutomerID, String customercpf, String customerName, String customerPhone);
    void deleteCustomer(String customerID);
    void changeID(String customerCpf);
    void changeCpf(String customerID);
    void changeName(String ID);
    void changePhone(String ID);
    void print();

}
