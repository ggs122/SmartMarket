package br.com.stockofproducts;



public final class CreateProductsUtills {

    private CreateProductsUtills() {}

    private enum Categories {
        PASTA("MASSAS"),
        CEREALS("CEREAIS"),
        GRAINS("GRÃOS"),
        BEVERAGES("BEBIDAS"),
        MEATS("CARNES"),
        DAIRY_PRODUCTS("LATICÍNIOS"),
        INEXISTENT("INEXIXTENTE");


        private String description;

        Categories(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }
    }

    public static String returnStringByEnum(String choose) {

        return switch (choose) {
          case "MASSAS" -> Categories.PASTA.getDescription();

          case "CEREAIS" -> Categories.CEREALS.getDescription();

          case "GRÃOS" -> Categories.GRAINS.getDescription();

          case "BEBIDAS" -> Categories.BEVERAGES.getDescription();

          case "CARNES" -> Categories.MEATS.getDescription();

          case "LATICÍNIOS" -> Categories.DAIRY_PRODUCTS.getDescription();

          default -> Categories.INEXISTENT.getDescription();
        };
    }
}
