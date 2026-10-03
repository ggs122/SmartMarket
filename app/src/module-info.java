import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;

module app {

    requires createproductsInterface;
    requires createcustomerinterface;
    requires stockofproducts;

    uses CreateProductsInterface;
    uses CreateCustomerInterface;

}