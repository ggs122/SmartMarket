package br.com.stockofproducts;

import br.com.createproductsinterface.CreateProductsInterface;
import br.com.stockofproducts.stockdefault.StockDefault;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class CreateProductsImpl extends StockDefault implements CreateProductsInterface {


    private boolean isCode;
    private boolean isCountryFormat;
    private boolean isCodeFactory;
    private List<CreateProductsImpl> setUpCompanyDataAtTheSystemLevel;
    private Locale localeBr = Locale.forLanguageTag("pt-BR");
    private NumberFormat priceFormated = NumberFormat.getCurrencyInstance(localeBr);

    private CreateProductsImpl(String countryFormat, String codeFactory) {
        super(countryFormat, codeFactory);
    }

    private CreateProductsImpl(String countryFormat, String codeFactory, String code, String name, double price, long amount) {
        super(countryFormat, codeFactory, code, name, price, amount);
    }

    public CreateProductsImpl(){}

    static List<CreateProductsImpl> createdProductsList = new ArrayList<>();

    @Override
    public void createProduct(String code, String name, double price, long amount) {

      boolean isfactoryDataLevel = setUpCompanyDataAtTheSystemLevel
                .stream()
                .anyMatch(s -> s.getCountryFormat() != null && s.getCodeFactory() != null);

        isCode = code.matches("[0-9]{6}");
                if (isCode && isSimilarProduct(code) == false) {
                    if (price > 0) {
                        if (amount > 0) {
                            if (isfactoryDataLevel) {
                                setUpCompanyDataAtTheSystemLevel
                                        .forEach(s -> {
                                            CreateProductsImpl createProducts = new CreateProductsImpl(s.getCountryFormat(), s.getCodeFactory(), code, name, price, amount);
                                            createdProductsList.add(createProducts);
                                        });
                            } else {
                                IO.println("Códigos do país e da empresa ainda não foram cadastrados, favor cadastre!");
                            }

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
    }

    @Override
    public void setUpCompanyDataAtTheSystemLevel(String countryFormat, String codeFactory) {
        isCountryFormat = countryFormat.matches("[0-9]{3}");
        isCodeFactory = codeFactory.matches("[0-9]{6}");
        if (isCountryFormat) {
            if (isCodeFactory) {
                if (getCountryFormat() == null && getCodeFactory() == null) {
                    CreateProductsImpl createSetUpCompanyData = new CreateProductsImpl(countryFormat, codeFactory);
                    setUpCompanyDataAtTheSystemLevel = List.of(createSetUpCompanyData);
                } else {
                    IO.println("-----------------------------------------------------------------------------------------------");
                    IO.println(String.format(localeBr, "O código do país e da empresa já foram cadastrados, anteriormente.\nImpossível cadastrar com País: [%s] e Empresa: [%s]", countryFormat, codeFactory));
                    IO.println("-----------------------------------------------------------------------------------------------");
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
    public void changeProductName(String code, String newProductName) {
       boolean isProduct = createdProductsList
                .stream()
                .anyMatch(p -> p.getCode().equalsIgnoreCase(code));

       if (isProduct) {
           createdProductsList
                   .stream()
                   .filter(p -> p.getCode().equalsIgnoreCase( code))
                   .forEach(p -> p.setName(newProductName));
           IO.println("-----------------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Produto Cód.: %s -> Nome alterado para: %s", code, newProductName));
           IO.println("-----------------------------------------------------------------------------------------------");
       } else {
           IO.println("-----------------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Produto Cód: %s -> Não encontrado!!", code));
           IO.println("-----------------------------------------------------------------------------------------------");
       }

    }

    @Override
    public void changeProductPrice(String code, double newProductPrice) {
      boolean isProduct = createdProductsList
                .stream()
                .anyMatch(p -> p.getCode().equalsIgnoreCase(code));

      if (isProduct) {
          createdProductsList
                  .stream()
                  .filter(p -> p.getCode().equalsIgnoreCase(code))
                  .forEach(p -> p.setPrice(newProductPrice));
          IO.println("-----------------------------------------------------------------------------------------------");
          IO.println(String.format(localeBr, "Produto Cód.: %s -> Preço alterado para: %s", code, priceFormated.format(newProductPrice)));
          IO.println("-----------------------------------------------------------------------------------------------");
      } else {
          IO.println("-----------------------------------------------------------------------------------------------");
          IO.println(String.format(localeBr, "Produto Cód: %s -> Não encontrado!!", code));
          IO.println("-----------------------------------------------------------------------------------------------");
      }
    }

    @Override
    public void changeProductAmount(String code, long amount) {
      boolean isSameProduct = createdProductsList
                .stream()
                .anyMatch(p -> p.getCode().equalsIgnoreCase(code));
      if (isSameProduct) {
          createdProductsList
                  .stream()
                  .filter(p -> p.getCode().equalsIgnoreCase(code))
                  .forEach(p -> {
                      p.setAmount(amount);
                      IO.println("-----------------------------------------------------------------------------------------------");
                      IO.println(String.format(localeBr, "Produto Cód.: %s -> Quantidade alterada para: %d, com sucesso!", code, amount));
                      IO.println("-----------------------------------------------------------------------------------------------");
                  });
      } else {
          IO.println("-----------------------------------------------------------------------------------------------");
          IO.println(String.format(localeBr, "Produto Cód: %s -> Não encontrado!!", code));
          IO.println("-----------------------------------------------------------------------------------------------");
      }

    }

    @Override
    public void deleteProduct(String code) {
     boolean isSimilarProduct = createdProductsList
              .removeIf(p -> p.getCode().equalsIgnoreCase(code));

     if (isSimilarProduct) {
         IO.println("-----------------------------------------------------------------------------------------------");
         IO.println(String.format(localeBr, "Produto Cód.: %s -> Removido do estoque com sucesso!", code));
         IO.println("-----------------------------------------------------------------------------------------------");
     } else {
         IO.println("-----------------------------------------------------------------------------------------------");
         IO.println(String.format(localeBr, "Produto Cód: %s -> Não encontrado!!", code));
         IO.println("-----------------------------------------------------------------------------------------------");
     }
    }

    @Override
    public void addAditionalProductsAtTheSystemLevel(String code, long amount) {
      boolean isSameProduct = createdProductsList
                .stream()
                .anyMatch(p -> p.getCode().equalsIgnoreCase(code));
      if (isSameProduct) {
          createdProductsList
                  .stream()
                  .filter(p -> p.getCode().equalsIgnoreCase(code))
                  .forEach(p -> {
                      long newAmount = p.getAmount() + amount;
                      p.setAmount(newAmount);
                      IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
                      IO.println(String.format(localeBr, "Produto: [%s], Código: [%s] -> Adicionado a quantidade de [%d], produto(s) com sucesso!", p.getName(), p.getCode(), amount));
                      IO.println(String.format(localeBr, "Nova quantidade em estoque: [%d] produto(s).", p.getAmount()));
                      IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
                  });
      } else {
          IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
          IO.println(String.format(localeBr, "Código de produto: %s -> inexistente, impossível adicionar a quantidade de [%d] produto(s).", code, amount));
          IO.println("--------------------------------------------------------------------------------------------------------------------------------------");
      }

    }


    public void minusProduct(String code, long amount) {
       boolean isSameProduct = createdProductsList
                .stream()
                .anyMatch(p -> p.getCode().equalsIgnoreCase(code));

      long productAmount = createdProductsList
               .stream()
               .filter(p -> p.getCode().equalsIgnoreCase(code))
               .mapToLong(p -> p.getAmount())
               .sum();

       if (isSameProduct) {
           if (amount > 0) {
               if (productAmount >= amount) {
                   createdProductsList
                           .stream()
                           .filter(p -> p.getCode().equalsIgnoreCase(code))
                           .forEach(p -> {
                               long newAmount = p.getAmount() - amount;
                               p.setAmount(newAmount);
                               IO.println("-------------------------------------------------------------------------------------------------------------------");
                               IO.println(String.format(localeBr, "Produto Cód.: %s -> Retirada a quantidade de: %d, produtos do estoque.\nRestam: %d deste produto ainda em estoque.", code, amount, newAmount));
                               IO.println("-------------------------------------------------------------------------------------------------------------------");
                           });
               } else {
                   IO.println("-------------------------------------------------------------------------------------------------------------------");
                   IO.println(String.format(localeBr, "Produto Cód: %s -> Quantidade solicitada: [%d], insuficiente no estoque", code, amount));
                   IO.println("-------------------------------------------------------------------------------------------------------------------");
               }
           } else {
               IO.println("-------------------------------------------------------------------------------------------------------------------");
               IO.println(String.format(localeBr, "Produto Cód: %s -> Quantidade %d, deve ser maior do que zero", code, amount));
               IO.println("-------------------------------------------------------------------------------------------------------------------");
           }
       } else {
           IO.println("-------------------------------------------------------------------------------------------------------------------");
           IO.println(String.format(localeBr, "Produto Cód: %s -> Não encontrado!!", code));
           IO.println("-------------------------------------------------------------------------------------------------------------------");
       }
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
