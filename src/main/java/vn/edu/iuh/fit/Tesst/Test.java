package vn.edu.iuh.fit.Tesst;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.connection.ConnectionDB;


public class Test {
    public static void main(String[] args) {

        EntityManager em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();

        EntityTransaction  tran = em.getTransaction();

        try {
            tran.begin();
            System.out.println("Complete");
            tran.commit();
        } catch (Exception e) {
            System.out.println("Lỗi");
            e.printStackTrace();
            tran.rollback();
        }
    }
}
