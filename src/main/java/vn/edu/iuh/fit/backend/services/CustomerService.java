package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
       customerRepository = new CustomerRepository();
    }

    public List<Customer> getAll(){
        return customerRepository.getAll();
    }

    public Optional<Customer> findCusFirst(){
        return customerRepository.findCusFirst();
    }
    public Optional<Customer> findByID(long id){
        return customerRepository.getOneById(id);
    }

    public boolean insert(Customer c){
        return customerRepository.insert(c);
    }

    public boolean updateCustomer(Customer c){
       return customerRepository.update(c);
    }

}
