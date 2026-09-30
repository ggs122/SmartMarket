import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.customer.CreateCustomerImpl;

module customer {
    requires createcustomerinterface;

    provides CreateCustomerInterface with CreateCustomerImpl;

}