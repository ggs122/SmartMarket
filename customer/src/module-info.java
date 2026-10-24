import br.com.createcustomerinterface.CreateCustomerInterface;
import br.com.customer.CreateCustomerImpl;

module customer {
    requires createcustomerinterface;
    requires users;

    provides CreateCustomerInterface with CreateCustomerImpl;

}