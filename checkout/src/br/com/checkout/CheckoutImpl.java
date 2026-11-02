package br.com.checkout;

import br.com.checkout.checkoutdefault.CheckoutDefault;
import br.com.checkoutinterface.CheckoutInterface;
import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

//TODO parei aqui nesta classe.
public class CheckoutImpl extends CheckoutDefault implements CheckoutInterface {

    private CreateCustomerInterface customer;
    private CreateProductsInterface products;
    private UsersInterface users;

    @Override
    public void registerProducts(String code) {

        double localProductPrice = products.findProduct(code);
        products.minusProduct(code, 1);
        total(localProductPrice);

    }

    @Override
    public void deletOneProductOfTheRegister(String code, String userLogin, String userPassword) {

    }

    @Override
    public void total(double productPrice) {

        double totalLocal = getTotal() + productPrice;
        setTotal(totalLocal);
        System.out.println(getTotal());

    }

    @Override
    public void resetAfterRegisterTheTotal() {

    }
}
