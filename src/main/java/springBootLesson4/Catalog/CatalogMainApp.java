package springBootLesson4.Catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

@SpringBootApplication
public class CatalogMainApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CatalogMainApp.class, args);
    }

    private IProductRepository repository;

    public CatalogMainApp(@Autowired IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String[] args) throws Exception {
        List<Product> products = repository.getProducts();
        System.out.println("Products:");
        for (int i = 0; i < products.size(); i++) {
            products.get(i).info();
        }
    }
}
