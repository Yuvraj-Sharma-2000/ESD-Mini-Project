package com.bean;

import jakarta.persistence.*;

@Entity
@Table
public class Organisation {
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 64)
    private String address;

    public Organisation() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organisation(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}