import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;

module app {

    requires createproductsInterface;
    requires createcustomerinterface;

    uses CreateProductsInterface;
    uses CreateCustomerInterface;

}