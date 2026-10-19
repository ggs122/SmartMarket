import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

module app {

    requires createproductsInterface;
    requires createcustomerinterface;
    requires stockofproducts;
    requires usersinterface;

    uses CreateProductsInterface;
    uses CreateCustomerInterface;
    uses UsersInterface;


}