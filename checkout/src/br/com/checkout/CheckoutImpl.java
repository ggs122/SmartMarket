package br.com.checkout;

import br.com.checkout.checkoutdefault.CheckoutDefault;
import br.com.checkoutinterface.CheckoutInterface;
import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

import java.util.ServiceLoader;

//TODO parei aqui nesta classe.
public class CheckoutImpl extends CheckoutDefault implements CheckoutInterface {

    private CreateCustomerInterface customer = ServiceLoader.load(CreateCustomerInterface.class).findFirst().orElseThrow();
    private CreateProductsInterface products = ServiceLoader.load(CreateProductsInterface.class).findFirst().orElseThrow();
    private UsersInterface users = ServiceLoader.load(UsersInterface.class).findFirst().orElseThrow();

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
