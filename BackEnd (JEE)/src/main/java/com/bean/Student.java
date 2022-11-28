package com.bean;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idStu;

    @Column(nullable = false)
    private Integer rollNumber;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(length = 128)
    private String photographPath;

    @Column(nullable = false, precision = 10)
    private float cgpa;

    @Column(nullable = false)
    private Integer totalCredits;

    @Column
    private Integer graduationYear;

    @Column(length = 20)
    private String domain;

    @Column(length = 20)
    private String specialisation;

    @Column
    private Integer placementId;

    public Student(Integer rollNumber, String firstName, String lastName, String email, String photographPath, float cgpa, Integer totalCredits, Integer graduationYear, String domain, String specialisation, Integer placementId) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photographPath = photographPath;
        this.cgpa = cgpa;
        this.totalCredits = totalCredits;
        this.graduationYear = graduationYear;
        this.domain = domain;
        this.specialisation = specialisation;
        this.placementId = placementId;
    }

    public Student() {

    }

    public Integer getId() {
        return idStu;
    }

    public void setId(Integer id) {
        this.idStu = id;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

}