package com.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlumni;

    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private long contactNumber;

    @OneToOne
    private Student studentId;

    public alumni() {
    }

    public alumni(String email,String password, long contactNumber, Student studentId) {
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
        this.studentId = studentId;
    }

    public int getId() {
        return idAlumni;
    }

    public void setId(int id) {
        this.idAlumni = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Student getStudentId() {
        return studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }
}
