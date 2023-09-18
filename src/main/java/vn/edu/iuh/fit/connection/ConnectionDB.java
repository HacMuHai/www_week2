package vn.edu.iuh.fit.connection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class ConnectionDB {

    private static ConnectionDB connection;
    private EntityManagerFactory emf;

    private ConnectionDB(){
        emf = Persistence.createEntityManagerFactory("www_week2");
    }

    public static ConnectionDB getConnection(){
        if(connection == null)
            connection = new ConnectionDB();
        return  connection;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
