package br.com.stockofproducts.stockdefault;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.Locale;

public abstract class StockDefault {

    private long id;
    private static long staticId = 10000;
    private String code;
    private String name;
    private String categories;
    private double price;
    private long amount;
    private LocalDateTime createdAt;

    private String countryFormat;
    private String codeFactory;

    private Locale localeBr = Locale.forLanguageTag("pt-BR");

    private NumberFormat nf = NumberFormat.getCurrencyInstance(localeBr);

    protected StockDefault(String countryFormat, String codeFactory, String code, String name, String categories, double price, long amount, LocalDateTime createdAt) {
        this.id = staticId;
        StockDefault.staticId++;
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.createdAt = createdAt;
        this.countryFormat = countryFormat;
        this.codeFactory = codeFactory;
        this.categories = categories;
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

    protected String getCategories(){
        return categories;
    }

    protected double getPrice() {
        return price;
    }

    protected long getAmount() {
        return amount;
    }

    protected LocalDateTime getCreatedAt(){
        return createdAt;
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

    public abstract void createProduct(String code, String name, String categories, double price, long amount);
    public abstract void findProduct(String code);
    public abstract void changeProductName(String code, String newProductName);
    public abstract void changeProductPrice(String code, double price);
    public abstract void changeProductAmount(String code, long amount);
    public abstract void deleteProduct(String code);
    public abstract  void addAditionalProductsAtTheSystemLevel(String code, long amount);
    public abstract void minusProduct(String code, long amount);
    public abstract void printProduct();

    @Override
    public String toString() {
        String priceString = nf.format(price);
        LocalDateTime localDateTimeAdd = getCreatedAt().now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String createdAtFormated = localDateTimeAdd.format(formatter.withLocale(localeBr));
        return String.format(localeBr, "ID: %d | Cod.: %s%s%s | Prod.: %-100s | Preço: %-15s | Qtde: %-7d | Add. estoque em: %s", id, countryFormat, codeFactory, code, name, priceString, amount, createdAtFormated);
    }
}
