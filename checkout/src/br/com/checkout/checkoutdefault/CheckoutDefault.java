package br.com.checkout.checkoutdefault;

import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

public abstract class CheckoutDefault {

    public enum paymentTypes {
        CASH,
        CARD,
        PIX,
    }

    public enum cardTypes {
        VISA,
        VISA_CARD,
        AMERICAN_EXPRESS,
        MASTER_CARD;
    }

    private long itemNumber;
    private static long staticItenname;
    private String productName;
    private String productDescription;
    private double productValue;
    private double total;


    protected CheckoutDefault(){}
    protected CheckoutDefault(long itemNumber, String productName, String productDescription, double productValue) {
        this.itemNumber = itemNumber;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productValue = productValue;
    }

    protected long getItemNumber() {
        return itemNumber;
    }

    protected void setItemNumber(long itemNumber) {
        this.itemNumber = itemNumber;
    }

    protected String getProductName() {
        return productName;
    }

    protected void setProductName(String productName) {
        this.productName = productName;
    }

    protected String getProductDescription() {
        return productDescription;
    }

    protected void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    protected double getProductValue() {
        return productValue;
    }

    protected void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    protected double getTotal() {
        return total;
    }

    protected void setTotal(double total) {
        this.total = total;
    }

    protected abstract void registerProducts(String code);
    protected abstract void deletOneProductOfTheRegister(String code, String userLogin, String userPassword);
    protected abstract void total(double productPrice);
    protected abstract void resetAfterRegisterTheTotal();

}
