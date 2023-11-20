package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
       employeeRepository = new EmployeeRepository();
    }

    public List<Employee> getAllEmp(){
        return employeeRepository.getAllEmp();
    }

    public boolean insert(Employee e){
        return employeeRepository.insertEmp(e);
    }

    public boolean updateEmp(Employee e){
       return employeeRepository.updateEmp(e);
    }

    public boolean setStatusEmp(long id){
       return employeeRepository.setStatusEmp(id);
    }
}
