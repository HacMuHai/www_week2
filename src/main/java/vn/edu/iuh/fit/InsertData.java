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
import java.util.ArrayList;
import java.util.List;
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
            List<ProductPrice> productPrices = new ArrayList<>();
            List<Order> orders = new ArrayList<>();
            List<Employee> employees = new ArrayList<>();
            for (int i = 1; i <= 30; i++) {

                //Product
                Product product = new Product(faker.lorem().paragraph(1),device.manufacturer(),device.modelName(), ProductStatus.ACTIVE,faker.starCraft().unit());
                em.persist(product);

                //ProductPrice
                ProductPrice productPrice=new ProductPrice();
                for (int j = 0; j < 3; j++) {
                    productPrice = new ProductPrice(LocalDateTime.of(2022,4,j+1,4,5,0,0),
                            "",faker.random().nextDouble(20,50),product);
                    em.persist(productPrice);

                    ProductImage productImage = new ProductImage("","",product);
                    em.persist(productImage);
                }
                productPrices.add(productPrice);

                //Employee
                Employee employee = new Employee(faker.name().fullName(),faker.date().birthday().toLocalDateTime(),
                        faker.internet().emailAddress(), faker.address().fullAddress(), random.nextLong(1111111111L,9999999999L)+"", EmployeeStatus.ACTIVE);
                em.persist(employee);
                employees.add(employee);

            }

            for (int i = 1; i <= 30; i++) {

                //Customer
                Customer customer = new Customer(faker.name().fullName(), faker.address().fullAddress(),
                        random.nextLong(1111111111L, 9999999999L) + "", faker.internet().emailAddress());
                em.persist(customer);

                //Order
                int empId = random.nextInt(0, 25);
                for (int j = 1; j <= 4; j++) {
                    Employee employee = employees.get(empId + j - 1);
                    Order order = new Order(faker.date().birthday(1, 2).toLocalDateTime(), customer, employee);
                    System.out.println(order);
                    em.persist(order);

                    int iId = random.nextInt(0, 25);
                    for (int k = 1; k <= 4; k++) {
                        ProductPrice productPrice = productPrices.get(iId + k - 1);

                        //OrderDetail
                        OrderDetail orderDetail = new OrderDetail(order, productPrice.getProduct(), productPrice.getPrice(), faker.random().nextInt(1, 20), "");
                        em.persist(orderDetail);
                    }
                }
            }

            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        }
    }
}
