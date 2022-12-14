package com.hilquiascamelo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@PrimaryKeyJoinColumn(name="idUsers")
public class Employee extends Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double wage;
    private Date hiringDate;
    private Integer department;

    public Employee() {
    }

    public Employee( Double wage, Date hiringDate, Integer department) {
        this.wage = wage;
        this.hiringDate = hiringDate;
        this.department = department;
    }


    public Double wage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public Date hiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Integer department() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

}