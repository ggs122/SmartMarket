module app {

    requires createproductsInterface;
    requires createcustomerinterface;
    requires stockofproducts;
    requires usersinterface;
    requires checkoutinterface;

    uses br.com.createproductsinterface.CreateProductsInterface;
    uses br.com.createcustomerinterface.CreateCustomerInterface;
    uses br.com.usersinterface.UsersInterface;
    uses br.com.checkoutinterface.CheckoutInterface;




}