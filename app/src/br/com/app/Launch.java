package br.com.app;

import br.com.createproductsinterface.CreateProductsInterface;

import java.util.ServiceLoader;

public class Launch {

    static void main(String[] args) {



       var createProducts1 = ServiceLoader.load(CreateProductsInterface.class).findFirst().orElse(null);
       createProducts1.createProduct("057", "172653", "002659", "Arroz Raroz - 5Kg", 23.00, 55);
       createProducts1.createProduct("057", "172653", "000260", "Miojo - Nissim - Pac.", 4.50, 25);
       createProducts1.createProduct("057", "172653","000261", "Massa de Macarrão - Talharim - 500kg", 7.50, 110);
        createProducts1.createProduct("057", "172653","000261", "Massa de Macarrão - Talharim - 500kg", 7.50, 110);
       createProducts1.printProduct();


    }

}
