package br.com.createproductsinterface;

import java.time.LocalDateTime;

public interface CreateProductsInterface {

    void createProduct(String code, String name, String categories, double price, long amount);
    void setUpCompanyDataAtTheSystemLevel(String countryFormat, String codeFactory);
    void findProduct(String code);
    void changeProductName(String code, String newProductName, String userLogin, String userPassWord);
    void changeProductPrice(String code, double newProductPrice, String userLogin, String userPassWord);
    void changeProductAmount(String code, long amount, String userLogin, String userPassword);
    void deleteProduct(String code, String userLogin, String userPassWord);
    void addAditionalProductsAtTheSystemLevel(String code, long amount, String userLogin, String userPassword);
    void printProduct();

}
