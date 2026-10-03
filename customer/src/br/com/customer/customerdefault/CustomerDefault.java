package br.com.customer.customerdefault;

import java.util.Locale;

public abstract class CustomerDefault {

    private long customerId = customerIdStatic;
    protected static long customerIdStatic = 1000;
    private String customerID;
    private String customerCpf;
    private String customerName;
    private String customerPhone;

    private Locale localeBr = Locale.forLanguageTag("pt-BR");

    protected CustomerDefault(long customerId, String customerID, String customerCpf, String customerName, String customerPhone) {
        this.customerId = customerId;
        this.customerID = customerID;
        this.customerCpf = customerCpf;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    protected CustomerDefault() {}

    protected String getCustomerID() {
        return customerID;
    }

    protected void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    protected String getCustomerCpf() {
        return customerCpf;
    }

    protected void setCustomerCpf(String customerCpf) {
        this.customerCpf = customerCpf;
    }

    protected String getCustomerName() {
        return customerName;
    }

    protected void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    protected String getCustomerPhone() {
        return customerPhone;
    }

    protected void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public abstract void createCustomer(String cutomerID, String customercpf, String customerName, String customerPhone);
    public abstract void deleteCustomer(String customerID);
    public abstract void changeID(String customerCpf, String newID);
    public abstract void changeCpf(String customerID, String newCustomerCpf);
    public abstract void changeName(String ID, String newName);
    public abstract void changePhone(String ID, String newCustomerPhone);
    public abstract void print();

    @Override
    public String toString() {
        return String.format(localeBr, "Id: %d | Identidade N°: %s | CPF N°: %s | Nome %-35s | Tell N° %s", customerId, customerID, customerCpf, customerName, customerPhone);
    }
}




