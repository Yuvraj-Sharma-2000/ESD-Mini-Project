package com.bean;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table
public class alumniOrganisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrg;

    @ManyToOne
    private alumni alumni;

    @ManyToOne
    private Organisation organisation;

    @Column
    private String position;

    @Column(nullable = false)
    private Date joiningDate;

    @Column(nullable = false)
    private Date leavingDate;

    public alumniOrganisation() {
    }

    public alumniOrganisation(alumni alumni,Organisation organisation ,String position, Date joiningDate, Date leavingDate) {
        this.organisation = organisation;
        this.alumni = alumni;
        this.position = position;
        this.joiningDate = joiningDate;
        this.leavingDate = leavingDate;
    }

    public int getId() {
        return idOrg;
    }

    public void setId(int id) {
        this.idOrg = id;
    }

    public com.bean.alumni getAlumni() {
        return alumni;
    }

    public void setAlumni(com.bean.alumni alumni) {
        this.alumni = alumni;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }
}
