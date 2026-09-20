package br.com.stockofproducts;

import br.com.createproductsinterface.CreateProductsInterface;
import br.com.stockofproducts.stockdefault.StockDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateProductsImpl extends StockDefault implements CreateProductsInterface {


    private boolean isCode;
    private boolean isCountryFormat;
    private boolean isCodeFactory;
    private Locale localeBr = Locale.forLanguageTag("pt_BR");

    private CreateProductsImpl(String countryFormat, String codeFactory, String code, String name, double price, long amount) {
        super(countryFormat, codeFactory, code, name, price, amount);
    }

    public CreateProductsImpl(){}

    static List<CreateProductsImpl> createdProductsList = new ArrayList<>();

    @Override
    public void createProduct(String countryFormat, String codeFactory, String code, String name, double price, long amount) {
        isCountryFormat = countryFormat.matches("[0-9]{3}");
        isCodeFactory = codeFactory.matches("[0-9]{6}");
        isCode = code.matches("[0-9]{6}");
        if (isCountryFormat) {
            if (isCodeFactory) {
                if (isCode && isSimilarProduct(code) == false) {
                    if (price > 0) {
                        if (amount > 0) {
                            CreateProductsImpl createProducts = new CreateProductsImpl(countryFormat, codeFactory, code, name, price, amount);
                            createdProductsList.add(createProducts);
                        } else {
                            IO.println("-----------------------------------------------------------------------------------------------");
                            IO.println(String.format(localeBr, "Quantidade de produtos %d -> deve ser maior do que zero.", amount));
                            IO.println("-----------------------------------------------------------------------------------------------");
                        }
                    } else {
                        IO.println("-----------------------------------------------------------------------------------------------");
                        IO.println(String.format(localeBr, "O valor %.2f, do produto deve ser maior do que zero", price));
                        IO.println("-----------------------------------------------------------------------------------------------");
                    }

                } else {
                    IO.println("-----------------------------------------------------------------------------------------------");
                    IO.println("Código do produto inaválido para cadastrar!");
//                    IO.println("-----------------------------------------------------------------------------------------------");
                }

            } else {
                IO.println("-----------------------------------------------------------------------------------------------");
                IO.println("Código da empresa inválido!");
                IO.println("-----------------------------------------------------------------------------------------------");
            }

        } else {
            IO.println("-----------------------------------------------------------------------------------------------");
            IO.println("Código do país inválido!");
            IO.println("-----------------------------------------------------------------------------------------------");
        }
    }

    private boolean isSimilarProduct(String code) {
        boolean isSimilarProduct;

       isSimilarProduct = createdProductsList
                .stream()
                .anyMatch(c -> c.getCode().equalsIgnoreCase(code));

       if (isSimilarProduct) {
//           IO.println("-----------------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Produto: Cod.: %s -> Já existente no sistema.\nImpossível cadastrar!", code));
       } else {
           IO.println("-----------------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Produto: Cod.: %s -> Cadastrado com sucesso!", code));
           IO.println("-----------------------------------------------------------------------------------------------");
       }

       return isSimilarProduct;
    }

    @Override
    public void findProduct(String code) {
       boolean isSameProduct = createdProductsList
                .stream()
                .anyMatch(p -> p.getCode().equalsIgnoreCase(code));

       if (isSameProduct) {
           IO.println("---------------------------------------------------------------------------------------------------------------------------------");
           createdProductsList
                   .stream()
                   .filter(p -> p.getCode().equalsIgnoreCase(code))
                   .forEach(p -> IO.println(p));
           IO.println("---------------------------------------------------------------------------------------------------------------------------------");
       } else {
           IO.println(String.format(localeBr, "Código de produto %s: Inválido -> Produto não encontrado!", code));
       }

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
        IO.println("---------------------------------------------------------------------------------------------------------------------------------");
        IO.println("> ESTOQUE DE PRODUTOS <");
        if (!createdProductsList.isEmpty()) {
            createdProductsList
                    .stream()
                    .forEach(c -> IO.println(c));
        }
        IO.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
}
