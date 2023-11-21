package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;

    public  ProductService() {

        productRepository = new ProductRepository();
    }

    public List<Product> getAll(){
        return  productRepository.getAll();
    }

    public Optional<Product> findByID(long id){
        return productRepository.findByID(id);
    }

    public boolean insert(Product p){
        return productRepository.insert(p);
    }

    public boolean update(Product p){
        return productRepository.update(p);
    }

    public boolean setStatus(long id){
        return productRepository.setStatus(id);
    }

    public double getPrice(long proId){
        return  productRepository.getPriceById(proId);
    }

}
