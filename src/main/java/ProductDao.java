import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    List<Product> products = new ArrayList<>();
    Session session = null;

    public ProductDao(List<Product> products) {
        this.products = products;
    }

    public ProductDao(Session session) {
        if(session == null) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();

            this.session = factory.getCurrentSession();
            this.session.beginTransaction();
        } else {
            this.session = session;
        }
    }

    public Product findById(int id) {
        Product product = session.get(Product.class, id);
        return product;
    }

    public List<Product> findAll() {
        return session.createQuery("from Product").getResultList();
    }

    void deleteById(int id) {
        if (findById(id)  == null) {
            System.out.println("id: " + id + " not found");
        }  else {
            session.createQuery("delete from Product where id = " + id).executeUpdate();
        }
    }

    Product saveOrUpdate(Product product) {

        Product productSQL = findById(product.getId());

        if (productSQL == null) {
            productSQL = saveProduct(product);
        } else {
            productSQL = updateProduct(product);
        }

        return productSQL;

    }

    Product saveProduct(Product product) {

        session.save(product);
        session.getTransaction().commit();

        return findById(product.getId());

    }

    Product updateProduct(Product product) {
        Product productSQL = session.get(Product.class, product.getId());
        productSQL.setTitle(product.getTitle());
        productSQL.setPrice(product.getPrice());
        session.getTransaction().commit();
        System.out.println(productSQL);
        return productSQL;
    }

}
