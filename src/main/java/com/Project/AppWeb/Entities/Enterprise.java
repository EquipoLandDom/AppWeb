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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

    public Enterprise() {
    }

    public Enterprise(String name, String direction, String phone, String NIT, List<Employee> employees, List<MoneyMovement> movements, Date createAt, Date updateAt) {
        this.name = name;
        this.direction = direction;
        this.phone = phone;
        this.NIT = NIT;
        this.employees = employees;
        this.movements = movements;
        this.createAt = createAt;
        this.updateAt = updateAt;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}