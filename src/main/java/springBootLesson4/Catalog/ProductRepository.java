package springBootLesson4.Catalog;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository implements IProductRepository {

    private List<springBootLesson4.Catalog.Product> products = new ArrayList<>();

    public ProductRepository() {

        addProduct(new springBootLesson4.Catalog.Product(1,"Product 1",30));
        addProduct(new springBootLesson4.Catalog.Product(2,"Product 2",50));
        addProduct(new springBootLesson4.Catalog.Product(3,"Product 3",70));

    }

    public springBootLesson4.Catalog.Product findOneById(int id) {
        springBootLesson4.Catalog.Product product = products.get(id);
        return product;
    }

    public String getProductsList() {

        String result = products.toString();
        return result;

    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void delProduct(Product product) {
        this.products.remove(product);
    }


}
