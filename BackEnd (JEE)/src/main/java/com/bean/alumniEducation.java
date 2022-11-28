package com.bean;

import jakarta.persistence.*;

@Entity
@Table
public class alumniEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEdu;

    @ManyToOne
    private alumni alumni;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private int passingYear;

    @Column(nullable = false)
    private int joiningYear;

    @Column
    private String collegeName;

    @Column
    private String address;

    public alumniEducation() {
    }

    public alumniEducation(alumni alumni,String degree, int passingYear, int joiningYear, String collegeName, String address) {
        this.alumni = alumni;
        this.degree = degree;
        this.passingYear = passingYear;
        this.joiningYear = joiningYear;
        this.collegeName = collegeName;
        this.address = address;
    }

    public int getId() {
        return idEdu;
    }

    public void setId(int id) {
        this.idEdu = id;
    }

    public alumni getAlumni() {
        return alumni;
    }

    public void setAlumni(alumni alumni) {
        this.alumni = alumni;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }

    public int getJoiningYear() {
        return joiningYear;
    }

    public void setJoiningYear(int joiningYear) {
        this.joiningYear = joiningYear;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "alumniEducation{" +
                "id=" + idEdu +
                ", alumni=" + alumni +
                ", degree='" + degree + '\'' +
                ", passingYear=" + passingYear +
                ", joiningYear=" + joiningYear +
                ", collegeName='" + collegeName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
