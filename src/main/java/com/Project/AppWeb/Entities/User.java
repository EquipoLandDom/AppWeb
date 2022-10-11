package com.Project.AppWeb.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Profile")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true)
    private String email;
    @Column(name = "image")
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee", referencedColumnName = "id")
    private Employee user;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    public User() {
    }

    public User(int id, String name, String email, String image, String phone, Employee user, Date createAt) {
        this.id = id;
        this.email = email;
        this.image = image;
        this.user = user;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Employee getUser() {
        return user;
    }
    public void setUser(Employee user) {
        this.user = user;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}