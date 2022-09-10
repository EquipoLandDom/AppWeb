package com.Project.AppWeb.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_enterprise")
    private Enterprise enterprise;
    @Enumerated(EnumType.STRING)
    private RoleNames rol;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Profile profile;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;

    public Employee() {
    }

    public Employee(String name, String email, Enterprise enterprise, RoleNames rol, Profile profile, Date createAt, Date updateAt) {
        this.name = name;
        this.email = email;
        this.enterprise = enterprise;
        this.rol = rol;
        this.profile = profile;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public RoleNames getRol() {
        return rol;
    }

    public void setRol(RoleNames rol) {
        this.rol = rol;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
