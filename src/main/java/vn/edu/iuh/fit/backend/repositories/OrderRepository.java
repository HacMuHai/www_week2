package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.connection.ConnectionDB;
import vn.edu.iuh.fit.backend.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private final EntityManager em;
    private EntityTransaction tran;

    public OrderRepository(){
        em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
        tran = em.getTransaction();
    }

    public Optional<Order> getOneById(long id){
        TypedQuery<Order> query = em.createNamedQuery("Order.findOneById", Order.class);
        query.setParameter(1,id);
        Order order = query.getSingleResult();

        return order == null ? Optional.empty() : Optional.of(order);
    }

    public List<Order> getAll(){
        return  em.createNamedQuery("Order.findAll",Order.class)
                .getResultList();
    }

    public boolean insert(Order o){
        try{
            tran.begin();
            em.persist(o);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(Order o){
        try{
            tran.begin();
            em.merge(o);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public  List<OrderDetail> getOrderDetailByOrderID(long id){
        return em.createNamedQuery("Order.getOrderDetailById",OrderDetail.class)
                .setParameter(1,id)
                .getResultList();
    }

    public List<Order> getOrderByCustomerId(long id) {
        return em.createNamedQuery("Order.getOrderByCustomerId",Order.class)
                .setParameter(1,id)
                .getResultList();
    }

    public List<Order> getOrderByEmployeeId(long id) {
        return em.createNamedQuery("Order.getOrderByEmployeeId",Order.class)
                .setParameter(1,id)
                .getResultList();
    }
}
