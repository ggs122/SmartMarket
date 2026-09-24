package br.com.stockofproducts.stockdefault;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public abstract class StockDefault {

    private long id;
    private static long staticId = 10000;
    private String code;
    private String name;
    private double price;
    private long amount;

    private String countryFormat;
    private String codeFactory;

    private Locale localeBr = Locale.forLanguageTag("pt-BR");

    private NumberFormat nf = NumberFormat.getCurrencyInstance(localeBr);

    protected StockDefault(String countryFormat, String codeFactory, String code, String name, double price, long amount) {
        this.id = staticId;
        StockDefault.staticId++;
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.countryFormat = countryFormat;
        this.codeFactory = codeFactory;
    }

    protected StockDefault(String countryFormat, String codeFactory) {
        this.countryFormat = countryFormat;
        this.codeFactory = codeFactory;
    }

    public StockDefault() {}

    protected long getId() {
        return id;
    }

    protected String getCode() {
        return code;
    }

    protected String getName() {
        return name;
    }

    protected double getPrice() {
        return price;
    }

    protected long getAmount() {
        return amount;
    }

    protected String getCountryFormat() {
        return countryFormat;
    }

    protected String getCodeFactory() {
        return codeFactory;
    }

    protected void setCountryFormat(String countryFormat) {
        this.countryFormat = countryFormat;
    }

    protected void setCodeFactory(String codeFactory) {
        this.codeFactory = codeFactory;
    }

    protected void setCode(String code) {
        this.code = code;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    protected void setAmount(long amount) {
        this.amount = amount;
    }

    public abstract void createProduct(String countryFormat, String codeFactory, String code, String name, double price, long amount);
    public abstract void findProduct(String code);
    public abstract void changeProductName(String code, String newProductName);
    public abstract void changeProductPrice(String code, double price);
    public abstract void changeProductAmount(String code, long amount);
    public abstract void deleteProduct(String code);
    public abstract void printProduct();

    @Override
    public String toString() {
        String priceString = nf.format(price);
        return String.format(localeBr, "ID: %d | Cod.: %s | Prod.: %-100s | Preço: %-15s | Qtde: %d", id, code, name, priceString, amount);
    }
}
