package buyers;

import products.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "buyer_product_id")
    private int buyer_product_id;

    //@OneToMany(mappedBy = "product")
    //private List<Product> products;

    public Buyer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Buyer [" + id + " " + name + "]";
    }

//    public List<Product> getProducts() {
//
//
//
//        return products;
//    }
}
