package springBootLesson4.Catalog;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private int idProduct;
    private String titleProduct;
    private int costProduct;

    //Standard getters and setters
    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "idProduct");
        COLUMN_MAPPINGS.put("title", "titleProduct");
        COLUMN_MAPPINGS.put("cost", "costProduct");
    }

    public Product(int idProduct, String titleProduct, int costProduct) {
        this.idProduct = idProduct;
        this.titleProduct = titleProduct;
        this.costProduct = costProduct;
    }

    public void info() {
        System.out.println("id:" + idProduct + " title:" + titleProduct + " cost:" + costProduct);
    }
}
