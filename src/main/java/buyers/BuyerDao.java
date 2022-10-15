package buyers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import session.SessionFactoryUtils;

import java.util.ArrayList;
import java.util.List;

public class BuyerDao {

    Session session = null;
    SessionFactoryUtils sessionFactoryUtils = null;

    public BuyerDao(SessionFactoryUtils sessionFactoryUtils) {
        session = sessionFactoryUtils.getSession();
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Buyer findById(int id) {
        session = sessionFactoryUtils.getSession();
        Buyer buyer = session.get(Buyer.class, id);
        return buyer;
    }

    public List<Buyer> findAll() {
        session = sessionFactoryUtils.getSession();
        return session.createQuery("from Buyer").getResultList();
    }

    public void deleteById(int id) {
        if (findById(id)  == null) {
            System.out.println("id: " + id + " not found");
        }  else {
            session = sessionFactoryUtils.getSession();
            session.createQuery("delete from Buyer where id = " + id);
            session.getTransaction().commit();
        }
    }

    public Buyer saveOrUpdate(Buyer buyer) {

        Buyer buyerSQL = findById(buyer.getId());

        if (buyerSQL == null) {
            buyerSQL = saveBuyer(buyer);
        } else {
            buyerSQL = updateBuyer(buyer);
        }

        return buyerSQL;

    }

    public Buyer saveBuyer(Buyer buyer) {

        session = sessionFactoryUtils.getSession();
        session.save(buyer);
        session.getTransaction().commit();

        return findById(buyer.getId());

    }

    public Buyer updateBuyer(Buyer buyer) {

        session = sessionFactoryUtils.getSession();
        session.saveOrUpdate(buyer);
        session.getTransaction().commit();

        return buyer;

    }

    public Buyer addBuyer(String name) {

        Buyer buyer = new Buyer();
        buyer.setName(name);

        session = sessionFactoryUtils.getSession();
        session.save(buyer);
        session.getTransaction().commit();

        return buyer;

    }

    public List<?> getBuyerProducts(int buyerId) {

        session = sessionFactoryUtils.getSession();
        List<?> list =  session.createQuery("")
                .setParameter("id", buyerId)
                .getResultList();

        return list;

    }

}
