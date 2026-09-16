package br.com.stockofproducts.stockdefault;

import java.util.Locale;

public abstract class StockDefault {

    private long id;
    private static long staticId = 10000;
    private String code;
    private String name;
    private double price;
    private long amount;

    private final String countryFormat;
    private final String codeFactory;

    private Locale localeBr = Locale.forLanguageTag("pt-BR");

    public StockDefault(String countryFormat, String codeFactory, String code, String name, double price, long amount) {
        this.id = staticId;
        StockDefault.staticId++;
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.countryFormat = countryFormat;
        this.codeFactory = codeFactory;
    }

    public abstract void createProduct(String countryFormat, String codeFactory, String code, String name, double price, long amount);
    public abstract void findProduct(String code);
    public abstract void changeProductName(String code, String name);
    public abstract void changeProductPrice(String code, double price);
    public abstract void changeProductAmount(String code, long amount);
    public abstract void deleteProduct(String code);
    public abstract void printProduct();

    @Override
    public String toString() {
        return String.format(localeBr, "ID: %d | Cod.: %s | Prod.: %s | Preço: %.2f | Qtde: %d", id, code, name, price, amount);
    }
}
