package vn.edu.iuh.fit.Tesst;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.connection.ConnectionDB;

public class Test {
    public static void main(String[] args) {
        EntityManager em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();

        tran.begin();
        try {
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
    }
}
