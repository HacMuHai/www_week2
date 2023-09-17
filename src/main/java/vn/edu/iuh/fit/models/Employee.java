package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name",length = 150,nullable = false)
    private String fullName;
    @Column(name = "dob")
    private LocalDateTime dob;
    @Column(name = "email",length = 150,nullable = true)
    private String email;
    @Column(name = "address",length = 250,nullable = false)
    private String address;
    @Column(name = "phone",length = 15,nullable = false)
    private String phone;
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;


    public Employee() {
    }

    public Employee(long id) {
        this.id = id;
    }

    public Employee(long id, String fullName, LocalDateTime dob, String email, String address, String phone, EmployeeStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
