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



    protected abstract void registerProducts(String code);
    protected abstract void deletOneProductOfTheRegister(String code, String userLogin, String userPassword);
    protected abstract void total();
    protected abstract void resetAfterRegister();

}
