package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.connection.ConnectionDB;
import vn.edu.iuh.fit.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private final EntityManager em;
    private EntityTransaction tran;

    public CustomerRepository(){
        em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
        tran = em.getTransaction();
    }

    public Optional<Customer> getOneById(long id){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findOneById", Customer.class);
        query.setParameter(1,id);
        Customer emp = query.getSingleResult();

        return emp == null ? Optional.empty() : Optional.of(emp);
    }

    public Optional<Customer> findCusFirst(long id){
        Customer customer=em.createNamedQuery("Customer.findCusFirst",Customer.class).getSingleResult();
        return customer==null?Optional.empty():Optional.of(customer);
    }

    public List<Customer> getAll(){
        return  em.createNamedQuery("Customer.findAll",Customer.class)
                .getResultList();
    }


    public boolean insert(Customer c){
        try{
            tran.begin();
            em.persist(c);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(Customer c){
        try{
            tran.begin();
            em.merge(c);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }
}
