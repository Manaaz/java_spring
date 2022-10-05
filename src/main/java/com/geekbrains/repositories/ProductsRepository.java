package com.geekbrains.repositories;

import com.geekbrains.entites.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {

    private List<Product> products = new ArrayList<>();

    public ProductsRepository() {

        addProduct(new Product(1,"Product 1",30));
        addProduct(new Product(2,"Product 2",50));
        addProduct(new Product(3,"Product 3",70));

    }

    public Product findOneById(int id) {
        Product product = products.get(id);
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
