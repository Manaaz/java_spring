package myWebApp;

public class Product {
    String id ;
    String title;
    double cost;

    public Product(String id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String productToString() {
        return "id: " + id + ", title: " + title + ", cost: " + cost;
    }
}
