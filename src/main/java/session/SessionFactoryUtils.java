package session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import products.Product;
import buyers.Buyer;
import sales.Sales;

public class SessionFactoryUtils {

    private SessionFactory factory;

    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Buyer.class)
                .buildSessionFactory();
    }

    public Session getSession() {
        Session currentSession = factory.getCurrentSession();
        if(!currentSession.getTransaction().isActive()) {
            currentSession.beginTransaction();
        }
        return currentSession;
    }

    public void commitTransaction() {
        Session currentSession = factory.getCurrentSession();
        currentSession.getTransaction().commit();
    }

    public void shutdown() {
        if (factory != null) {
            factory.close();
        }
        if(session.isOpen()) {
            session.close();
        }
    }



    Session session = null;

    public SessionFactoryUtils() {

        org.hibernate.SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Sales.class)
                .buildSessionFactory();

        this.session = factory.getCurrentSession();
        this.session.beginTransaction();

    }

    public Session getCurrentSession() {
        return this.session;
    }

}
