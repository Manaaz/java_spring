package springBootLesson4.Catalog;

import java.util.List;

public interface IProductRepository {

    List<Product> products = null;
    List<Product> getProducts();

}
