package br.com.createproductsinterface;

public interface CreateProductsInterface {

    void createProduct(String code, String name, double price, long amount);
    void setUpCompanyDataAtTheSystemLevel(String countryFormat, String codeFactory);
    void findProduct(String code);
    void changeProductName(String code, String newProductName);
    void changeProductPrice(String code, double price);
    void changeProductAmount(String code, long amount);
    void deleteProduct(String code);
    void addAditionalProductsAtTheSystemLevel(String code, long amount);
    void printProduct();

}
