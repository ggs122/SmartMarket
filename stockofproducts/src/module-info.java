import br.com.stockofproducts.CreateProductsImpl;
import br.com.createproductsinterface.CreateProductsInterface;

module stockofproducts {

    exports br.com.stockofproducts;

    requires createproductsInterface;

    requires users;

    provides CreateProductsInterface with CreateProductsImpl;

}