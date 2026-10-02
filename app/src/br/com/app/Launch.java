package br.com.app;

import br.com.createcustomerinterface.CreateCustomerInterface;
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
       createProducts1.printProduct();
       createProducts1.printProduct();
       createProducts1.changeProductAmount("002659", 60);
       createProducts1.printProduct();
       createProducts1.addAditionalProductsAtTheSystemLevel("000260", 50);
       createProducts1.printProduct();
       createProducts1.addAditionalProductsAtTheSystemLevel("000260", 50);
       createProducts1.addAditionalProductsAtTheSystemLevel("000261", 50);
       createProducts1.printProduct();

       var createCustomer1 = ServiceLoader.load(CreateCustomerInterface.class).findFirst().orElse(null);
       createCustomer1.createCustomer("30.159.598-5", "105.265.897-50", "Marcelo Souza Soares", "(21)965987845");
       createCustomer1.createCustomer("30.159.598-5", "105.265.897-50", "Marcelo Souza Soares", "(21)965987845");
       createCustomer1.createCustomer("22.951.895-6", "501.562.798-60", "Thais Lima de Souza", "(21)956898754");
       createCustomer1.print();


    }

}
