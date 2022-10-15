package sales;

import buyers.Buyer;
import products.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_product")
    private int id_product;

    @Column(name = "id_buyer")
    private int id_buyer;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "sum")
    private int sum;

    @OneToMany(mappedBy = "products")
    private List<Product> products;

    @OneToMany(mappedBy = "buyers")
    private List<Buyer> buyers;

    public Sales() {
    }

    public int getId() {
        return id;
    }

    public int getBuyer() {
        return id_buyer;
    }

    @Override
    public String toString() {
        return "sale [" + id + " " + id_buyer + " " + id_product + " " + quantity + " " + sum + "]";
    }
}