package com.hilquiascamelo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="manager")
@PrimaryKeyJoinColumn(name="idUsers")
public class Manager extends Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double wage;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date hiringDate;
    private Integer department;

    public Manager() {
    }

    public Manager(Double wage) {
        this.wage = wage;
    }

    public Manager(Double wage, Date hiringDate, Integer department) {
        this.wage = wage;
        this.hiringDate = hiringDate;
        this.department = department;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Manager)) return false;
        if (!super.equals(object)) return false;
        Manager manager = (Manager) object;
        return wage.equals(manager.wage);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), wage);
    }

}