package vn.edu.iuh.fit.Tesst;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.mariadb.jdbc.MariaDbDataSource;
import vn.edu.iuh.fit.connection.ConnectionDB;

import java.util.Collections;

public class Test {
    public static void main(String[] args) {

        EntityManager em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("www_week2", Collections.singletonMap("javax.persistence.jdbc.url", "jdbc:mariadb://localhost:3306/mydb"));
//        EntityManager em = emf.createEntityManager();

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
