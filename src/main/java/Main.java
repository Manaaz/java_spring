
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import products.Product;
import products.ProductDao;
import buyers.Buyer;
import buyers.BuyerDao;
import sales.SaleDao;
import session.SessionFactoryUtils;

public class Main {
    public static void main(String[] args) {
        // CRUD
        Session session = null;

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();

        try {

//            ProductDao productDao = new ProductDao(sessionFactoryUtils);
//
//            List<Product> allProducts = productDao.findAll();///session.createQuery("from Product").getResultList();
//            System.out.println("test1 getall: " + allProducts);
//
//            Product product = productDao.findById(1);
//            System.out.println("test2 find by id = 1: " + product);
//
//            System.out.println("test3 delete by id = 3");
//            productDao.deleteById(3);
//            allProducts = productDao.findAll();
//            System.out.println("test3 getall: " + allProducts);
//
//            product = new Product();
//            product.setTitle("my test product");
//            product.setPrice(333);
//            product = productDao.saveOrUpdate(product);
//            System.out.println("test4 save product 3");
//            allProducts = productDao.findAll();
//            System.out.println("test4 getall: " + allProducts);
//
//
//
//
//            System.out.println("/////////////////////////////////////////");
//
//            BuyerDao buyersDao = new BuyerDao(sessionFactoryUtils);
//
//            List<Buyer> allBuyers = buyersDao.findAll();///session.createQuery("from Product").getResultList();
//            System.out.println("test1 getall: " + allBuyers);
//
//            Buyer buyer = buyersDao.findById(1);
//            System.out.println("test2 find by id = 1: " + buyer);
//
//            System.out.println("test3 delete by id = 3");
//            buyersDao.deleteById(3);
//            allBuyers = buyersDao.findAll();///session.createQuery("from Product").getResultList();
//            System.out.println("test3 getall: " + allBuyers);
//
//            buyer = buyersDao.addBuyer("test buyer 1");
//             System.out.println("test4 save buyer " + buyer);
//            allBuyers = buyersDao.findAll();
//            System.out.println("test4 getall: " + allBuyers);

//            session = sessionFactoryUtils.getCurrentSession();
//            Buyer b = new BuyerDao(sessionFactoryUtils).findById(1);
//            List<Product> products = b.getProducts();
//            System.out.println(products);

            SaleDao saleDao = new SaleDao(sessionFactoryUtils);
            System.out.println(saleDao.getBuyerProducts(1));
            System.out.println(saleDao.getProductBuyers(1));

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //factory.close();
            sessionFactoryUtils.shutdown();
        }
    }
}
