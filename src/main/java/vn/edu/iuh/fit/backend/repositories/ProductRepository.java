package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.backend.connection.ConnectionDB;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final EntityManager em;
    private EntityTransaction tran;

    public ProductRepository(){
        em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
        tran = em.getTransaction();
    }


    public List<Product> getAll(){
        return  em.createNamedQuery("Product.findAll",Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
    }

    public Optional<Product> findByID(long id){
        Product product=em.find(Product.class,id);
        return product==null?Optional.empty():Optional.of(product);
    }

    public boolean insert(Product p){
        try{
            tran.begin();
            em.persist(p);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(Product p){
        try{
            tran.begin();
            em.merge(p);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean setStatus(long id){
        try{
            tran.begin();
            int n = em.createNamedQuery("Product.setStatus")
                    .setParameter(1, ProductStatus.TERMINATED)
                    .setParameter(2,id)
                            .executeUpdate();

            tran.commit();
            return n > 0;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public double getPriceById(long proId) {
        return  em.createNamedQuery("Product.getPriceNew",Double.class)
                .setParameter(1,proId)
                .getSingleResult();
    }
}
