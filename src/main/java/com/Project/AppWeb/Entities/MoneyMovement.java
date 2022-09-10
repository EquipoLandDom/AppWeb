package com.Project.AppWeb.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Movements")
public class MoneyMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mount", nullable = false)
    private long mount;
    private String concept;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee user;
    @ManyToOne
    @JoinColumn(name = "id_enterprise")
    private Enterprise enterprise;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

    public MoneyMovement() {
    }

    public MoneyMovement(long mount, String concept, Employee user, Enterprise enterprise, Date createAt, Date updateAt) {
        this.mount = mount;
        this.concept = concept;
        this.user = user;
        this.enterprise = enterprise;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMount() {
        return mount;
    }

    public void setMount(long mount) {
        this.mount = mount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
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