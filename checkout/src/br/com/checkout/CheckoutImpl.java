package br.com.checkout;

import br.com.checkout.checkoutdefault.CheckoutDefault;
import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

//TODO parei aqui nesta classe.
public class CheckoutImpl extends CheckoutDefault {

    private CreateCustomerInterface customer;
    private CreateProductsInterface products;
    private UsersInterface users;

    @Override
    protected void registerProducts(String code) {

        double localProductPrice = products.findProduct(code);
        products.minusProduct(code, 1);
        total(localProductPrice);

    }

    @Override
    protected void deletOneProductOfTheRegister(String code, String userLogin, String userPassword) {

    }

    @Override
    protected void total(double productPrice) {

        double totalLocal = getTotal() + productPrice;
        setTotal(totalLocal);
        System.out.println(getTotal());

    }

    @Override
    protected void resetAfterRegisterTheTotal() {

    }
}
