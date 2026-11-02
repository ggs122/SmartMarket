import br.com.checkout.CheckoutImpl;
import br.com.checkoutinterface.CheckoutInterface;

module checkout {

    requires createcustomerinterface;
    requires createproductsInterface;
    requires usersinterface;
    requires checkoutinterface;

    provides CheckoutInterface with CheckoutImpl;

}