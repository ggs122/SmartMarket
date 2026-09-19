package br.com.stockofproducts;

import br.com.stockofproducts.stockdefault.StockDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateProducts extends StockDefault {


    private boolean isCode;
    private boolean isCountryFormat;
    private boolean isCodeFactory;
    private Locale localeBr = Locale.forLanguageTag("pt_BR");

    private CreateProducts(String countryFormat, String codeFactory, String code, String name, double price, long amount) {
        super(countryFormat, codeFactory, code, name, price, amount);
    }

    static List<CreateProducts> createdProductsList = new ArrayList<>();

    @Override
    public void createProduct(String countryFormat, String codeFactory, String code, String name, double price, long amount) {
        isCountryFormat = countryFormat.matches("[0-9]{3}");
        isCodeFactory = codeFactory.matches("[0-9]{6}");
        isCode = code.matches("[0-9]{6}");

        if (isCountryFormat) {
            if (isCodeFactory) {
                if (isCode && isSimilarProduct(code, name)) {
                    CreateProducts createProducts = new CreateProducts(countryFormat, codeFactory, code, name, price, amount);
                    createdProductsList.add(createProducts);

                } else {
                    IO.println("Código do produto inaválido!");
                }

            } else {
                IO.println("Código da empresa inválido!");
            }

        } else {
            IO.println("Código do país inválido!");
        }
    }

    private boolean isSimilarProduct(String code, String name) {
        boolean isSimilarProduct;

       isSimilarProduct = createdProductsList
                .stream()
                .anyMatch(c -> c.code.equalsIgnoreCase(code) && c.name.equalsIgnoreCase(name));

       if (isSimilarProduct) {
           IO.println(String.format(localeBr, "Produto: Cod.: %s | % -> Encontrado no sistema.", code, name));
       } else {
           IO.println(String.format(localeBr, "Produto: Cod.: %s | % -> Inexistente!", code, name));
       }

       return isSimilarProduct;
    }

    @Override
    public void findProduct(String code) {

    }

    @Override
    public void changeProductName(String code, String name) {

    }

    @Override
    public void changeProductPrice(String code, double price) {

    }

    @Override
    public void changeProductAmount(String code, long amount) {

    }

    @Override
    public void deleteProduct(String code) {

    }

    @Override
    public void printProduct() {
        createdProductsList
                .stream()
                .forEach(c -> IO.println(c));
    }
}
