package br.com.checkout;

import br.com.checkout.checkoutdefault.CheckoutDefault;
import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

public class CheckoutImpl extends CheckoutDefault {

    private CreateCustomerInterface customer;
    private CreateProductsInterface products;
    private UsersInterface users;

    @Override
    protected void registerProducts(String code) {
    }

    @Override
    protected void deletOneProductOfTheRegister(String code, String userLogin, String userPassword) {

    }

    @Override
    protected void total() {

    }

    @Override
    protected void resetAfterRegister() {

    }
}
