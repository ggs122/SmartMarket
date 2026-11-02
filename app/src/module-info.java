import br.com.checkoutinterface.CheckoutInterface;
import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.createproductsinterface.CreateProductsInterface;
import br.com.usersinterface.UsersInterface;

module app {

    requires createproductsInterface;
    requires createcustomerinterface;
    requires stockofproducts;
    requires usersinterface;
    requires checkoutinterface;

    uses CreateProductsInterface;
    uses CreateCustomerInterface;
    uses UsersInterface;
    uses CheckoutInterface;




}