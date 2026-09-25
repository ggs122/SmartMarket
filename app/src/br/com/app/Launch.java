package br.com.app;

import br.com.createproductsinterface.CreateProductsInterface;

import java.util.ServiceLoader;

public class Launch {

    static void main(String[] args) {



       var createProducts1 = ServiceLoader.load(CreateProductsInterface.class).findFirst().orElse(null);
       createProducts1.setUpCompanyDataAtTheSystemLevel("057", "053256");
       createProducts1.createProduct("002659", "Arroz Raroz - 5Kg", 23.00, 55);
       createProducts1.createProduct("000260", "Miojo - Nissim - Pac.", 4.50, 25);
       createProducts1.createProduct("000261", "Massa de Macarrão - Talharim - 500kg", 7.50, 110);
       createProducts1.createProduct("000261", "Massa de Macarrão - Talharim - 500kg", 7.50, 110);
       createProducts1.printProduct();
       createProducts1.changeProductName("000261", "Macarrão Talharim - 500g");
       createProducts1.printProduct();
       createProducts1.changeProductPrice("000261", 8.50);
       createProducts1.printProduct();
       createProducts1.deleteProduct("000261");
       createProducts1.printProduct();
       createProducts1.minusProduct("000260", 25);
       createProducts1.printProduct();
       createProducts1.minusProduct("000260", 1);
       createProducts1.printProduct();
       createProducts1.changeProductAmount("002659", 60);
       createProducts1.printProduct();


    }

}
