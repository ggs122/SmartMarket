package br.com.createproductsinterface;

public interface CreateProductsInterface {

    void createProduct(String countryFormat, String codeFactory, String code, String name, double price, long amount);
    void findProduct(String code);
    void changeProductName(String code, String newProductName);
    void changeProductPrice(String code, double price);
    void changeProductAmount(String code, long amount);
    void deleteProduct(String code);
    void printProduct();

}
