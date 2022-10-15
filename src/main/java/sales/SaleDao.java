package sales;

import org.hibernate.Session;
import session.SessionFactoryUtils;

import java.util.List;

public class SaleDao {

    Session session = null;
    SessionFactoryUtils sessionFactoryUtils = null;

    public SaleDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Sales findById(int id) {
        session = sessionFactoryUtils.getSession();
        Sales sale = session.get(Sales.class, id);
        return sale;
    }

    public List<Sales> findAll() {
        session = sessionFactoryUtils.getSession();
        List<Sales> sales = session.createQuery("from sale").getResultList();
        sessionFactoryUtils.commitTransaction();
        return sales;
    }

    public void deleteById(int id) {

        if (findById(id)  == null) {
            System.out.println("id: " + id + " not found");
        }  else {
            session = sessionFactoryUtils.getSession();
            session.createQuery("delete from Sale where id = " + id);
            session.getTransaction().commit();
        }

    }

    public Sales saveOrUpdate(Sales sale) {

        session = sessionFactoryUtils.getSession();
        Sales saleSQL = findById(sale.getId());

        if (saleSQL == null) {
            saleSQL = saveSale(sale);
        } else {
            saleSQL = updateSale(sale);
        }

        return saleSQL;

    }

    public Sales saveSale(Sales sale) {

        session = sessionFactoryUtils.getSession();
        session.save(sale);
        session.getTransaction().commit();

        return findById(sale.getId());

    }

    public Sales updateSale(Sales sale) {

        session = sessionFactoryUtils.getSession();
        session.saveOrUpdate(sale);
        session.getTransaction().commit();

        return findById(sale.getId());

    }

    public List<?> getBuyerProducts(int buyerId) {

        session = sessionFactoryUtils.getSession();
        List<?> list =  session.createQuery("SELECT sales.id_product, sales.id_buyer, sales.quantity, sales.sum FROM sales " +
                        "WHERE sales.id_buyer =: id ")
                .setParameter("id", buyerId)
                .getResultList();

        return list;

    }

    public List<?> getProductBuyers(int productId) {

        session = sessionFactoryUtils.getSession();
        List<?> list =  session.createQuery("SELECT sales.id_product, sales.id_buyer, sales.quantity, sales.sum FROM sales " +
                        "WHERE sales.id_product =: id ")
                .setParameter("id", productId)
                .getResultList();

        return list;

    }
}
