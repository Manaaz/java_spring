package products;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import session.SessionFactoryUtils;

public class ProductDao {

    Session session = null;
    SessionFactoryUtils sessionFactoryUtils = null;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Product findById(int id) {
        session = sessionFactoryUtils.getSession();
        Product product = session.get(Product.class, id);
        return product;
    }

    public List<Product> findAll() {
        session = sessionFactoryUtils.getSession();
        List<Product> products = session.createQuery("from Product").getResultList();
        sessionFactoryUtils.commitTransaction();
        return products;
    }

    public void deleteById(int id) {

        if (findById(id)  == null) {
            System.out.println("id: " + id + " not found");
        }  else {
            session = sessionFactoryUtils.getSession();
            session.createQuery("delete from Product where id = " + id);
            session.getTransaction().commit();
        }

    }

    public Product saveOrUpdate(Product product) {

        session = sessionFactoryUtils.getSession();
        Product productSQL = findById(product.getId());

        if (productSQL == null) {
            productSQL = saveProduct(product);
        } else {
            productSQL = updateProduct(product);
        }

        return productSQL;

    }

    public Product saveProduct(Product product) {

        session = sessionFactoryUtils.getSession();
        session.save(product);
        session.getTransaction().commit();

        return findById(product.getId());

    }

    public Product updateProduct(Product product) {

        session = sessionFactoryUtils.getSession();
        session.saveOrUpdate(product);
        session.getTransaction().commit();

        return findById(product.getId());

    }

    public Product addProduct(String title, int price) {

        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);

        session = sessionFactoryUtils.getSession();
        session.save(product);
        session.getTransaction().commit();

        return product;

    }

}
