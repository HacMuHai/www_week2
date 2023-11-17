package vn.edu.iuh.fit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.glassfish.jersey.internal.inject.Custom;
import vn.edu.iuh.fit.backend.connection.ConnectionDB;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;


public class InsertData {
    public static void main(String[] args) {

        EntityManager em = ConnectionDB.getConnection().getEntityManagerFactory().createEntityManager();
        EntityTransaction  tran = em.getTransaction();

        try {
            tran.begin();
            Faker faker = new Faker();
            Device device = faker.device();
            Random random = new Random();
            for (int i = 1; i <= 30; i++) {

                //Product
                Product product = new Product(faker.lorem().paragraph(1),device.manufacturer(),device.modelName(), ProductStatus.values()[random.nextInt(0,3)],faker.starCraft().unit());
                em.persist(product);

                //ProductPrice
                ProductPrice productPrice =new ProductPrice();
                for (int j = 0; j < 3; j++) {
                    productPrice = new ProductPrice(LocalDateTime.of(2022,4,j+1,4,5,0,0),
                            "",faker.random().nextDouble(20,50),product);
                    em.persist(productPrice);

                    ProductImage productImage = new ProductImage("","",product);
                    em.persist(productImage);
                }


                //Employee
                Employee employee = new Employee(faker.name().fullName(),faker.date().birthday().toLocalDateTime(),
                        faker.internet().emailAddress(), faker.address().fullAddress(), random.nextLong(1111111111L,9999999999L)+"", EmployeeStatus.ACTIVE);
                em.persist(employee);

                //Customer
                Customer customer =  new Customer(faker.name().fullName(), faker.address().fullAddress(),
                        random.nextLong(1111111111L,9999999999L)+"", faker.internet().emailAddress());
                em.persist(customer);

                //Order
                Order order = new Order(faker.date().birthday(1,2).toLocalDateTime(),customer,employee);
                em.persist(order);

                //OrderDetail
                OrderDetail orderDetail = new OrderDetail(order,product,productPrice.getPrice(),faker.random().nextInt(1,20),  "");
                em.persist(orderDetail);
            }

            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
    }
}
