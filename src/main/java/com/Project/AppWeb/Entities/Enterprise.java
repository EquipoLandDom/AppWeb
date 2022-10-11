package com.Project.AppWeb.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Enterprises")
public class Enterprise {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;
    @Column(name = "direction", nullable = false, length = 50)
    private String direction;
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Column(name = "NIT", nullable = false, length = 50)
    private String NIT;
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employees;
    @OneToMany(mappedBy = "enterprise")
    private List<MoneyMovement> movements;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }

    public Enterprise() {
    }

    public Enterprise(int id, String name, String direction, String phone, String NIT, List<Employee> employees, List<MoneyMovement> movements, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.direction = direction;
        this.phone = phone;
        this.NIT = NIT;
        this.employees = employees;
        this.movements = movements;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<MoneyMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<MoneyMovement> movements) {
        this.movements = movements;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}