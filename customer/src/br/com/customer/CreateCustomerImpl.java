package br.com.customer;

public class CreateCustomerImpl extends CustomerDefault{


    protected CreateCustomerImpl(int customerId, String customerID, String customerCpf, String customerName, String customerPhone) {
        super(customerId, customerID, customerCpf, customerName, customerPhone);
    }

    @Override
    public void createCustomer(String cutomerID, String customercpf, String customerName, String customerPhone) {

    }

    @Override
    public void deleteCustomer(String customerID) {

    }

    @Override
    public void changeID(String customerCpf) {

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

    }
}
