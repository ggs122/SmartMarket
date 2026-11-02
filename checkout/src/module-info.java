

module checkout {

    requires createcustomerinterface;
    requires createproductsInterface;
    requires usersinterface;
    requires checkoutinterface;

    provides br.com.checkoutinterface.CheckoutInterface with br.com.checkout.CheckoutImpl;

}