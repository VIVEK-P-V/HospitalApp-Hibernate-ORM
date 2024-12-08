package com.ty.hospitalapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid; // Observation ID
    private String dname; // Doctor's name
    private String rObservation; // Reported observation

    @ManyToOne
    @JoinColumn
    private Encounter encounter; // Associated encounter

    // Getter for oid
    public int getOid() {
        return oid;
    }

    // Setter for oid
    public void setOid(int oid) {
        this.oid = oid;
    }

    // Getter for dname
    public String getDname() {
        return dname;
    }

    // Setter for dname
    public void setDname(String dname) {
        this.dname = dname;
    }

    // Getter for rObservation
    public String getrObservation() {
        return rObservation;
    }

    // Setter for rObservation
    public void setrObservation(String rObservation) {
        this.rObservation = rObservation;
    }

    // Getter for encounter
    public Encounter getEncounter() {
        return encounter;
    }

    // Setter for encounter
    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }
}
