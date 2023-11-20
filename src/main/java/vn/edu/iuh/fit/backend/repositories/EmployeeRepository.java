package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.connection.ConnectionDB;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private final EntityManager em;
    private EntityTransaction tran;

    public EmployeeRepository(){
        em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
        tran = em.getTransaction();
    }


    public List<Employee> getAllEmp(){
        return  em.createNamedQuery("Employee.findAll",Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }

    public Optional<Employee> findByID(long id){
        Employee employee=em.find(Employee.class,id);
        return employee==null?Optional.empty():Optional.of(employee);
    }

    public Optional<Employee> findEmpFirst(long id){
        Employee employee=em.createNamedQuery("Employee.findEmpFirst",Employee.class).getSingleResult();
        return employee==null?Optional.empty():Optional.of(employee);
    }

    public boolean insertEmp(Employee e){
        try{
            tran.begin();
            em.persist(e);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateEmp(Employee e){
        try{
            tran.begin();
            em.merge(e);
            tran.commit();
            return true;
        }catch (Exception ex){
            tran.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean setStatusEmp(long id){
        try{
            tran.begin();
            int n = em.createNamedQuery("Employee.setStatusEmp")
                    .setParameter(1,EmployeeStatus.TERMINATED)
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
}
