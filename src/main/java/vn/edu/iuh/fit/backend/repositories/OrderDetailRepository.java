package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.backend.connection.ConnectionDB;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepository {
    private final EntityManager em;
    private EntityTransaction tran;

    public OrderDetailRepository(){
        em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
        tran = em.getTransaction();
    }

    public Optional<OrderDetail> getOneById(long id){
        OrderDetail orderDetail = em.find(OrderDetail.class, id);
        return orderDetail == null ? Optional.empty() : Optional.of(orderDetail);
    }

    public List<OrderDetail> getAll(){
        return  em.createNamedQuery("OrderDetail.findAll",OrderDetail.class)
                .getResultList();
    }

    public boolean insert(OrderDetail o){
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

    public boolean update(OrderDetail o){
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

}
