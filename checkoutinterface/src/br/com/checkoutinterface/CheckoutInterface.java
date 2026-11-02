package br.com.checkoutinterface;

public interface CheckoutInterface {

    void registerProducts(String code);
    void deletOneProductOfTheRegister(String code, String userLogin, String userPassword);
    void total(double productPrice);
    void resetAfterRegisterTheTotal();
}
