package br.com.checkout;

import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

public class Checkout {

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

    private CreateCustomerInterface customer;
    private CreateProductsInterface products;
    private UsersInterface users;

    private int itemNumber;
    private double total;

}
