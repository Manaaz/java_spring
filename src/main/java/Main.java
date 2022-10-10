
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        // CRUD
        Session session = null;
        session = factory.getCurrentSession();
        session.beginTransaction();

        try {
            ProductDao productDao = new ProductDao(session);

            List<Product> allProducts = productDao.findAll();///session.createQuery("from Product").getResultList();
            System.out.println("test1 getall: " + allProducts);

            Product product = productDao.findById(1);
            System.out.println("test2 find by id = 1: " + product);

            System.out.println("test3 delete by id = 3");
            productDao.deleteById(3);
            allProducts = productDao.findAll();///session.createQuery("from Product").getResultList();
            System.out.println("test3 getall: " + allProducts);

            product = new Product();
            product.setId(3);
            product.setTitle("my test product 3");
            product.setPrice(333);
            product = productDao.saveOrUpdate(product);
            System.out.println("test4 save product 3");
            allProducts = productDao.findAll();
            System.out.println("test4 getall: " + allProducts);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            session.close();
        }
    }
}
