package br.com.createcustomerinterface;

public interface CreateCustomerInterface {

    void createCustomer(String cutomerID, String customercpf, String customerName, String customerPhone);
    void deleteCustomer(String customerID, String userLogin, String userPassword);
    void changeID(String customerCpf, String newCustomerID, String userLogin, String userPassword);
    void changeCpf(String customerID, String newCustomerCpf, String userLogin, String userPassword);
    void changeName(String customerID, String newName, String userLogin, String userPassword);
    void changePhone(String customerID, String newCustomerPhone, String userLogin, String userPassword);
    void print();

}
