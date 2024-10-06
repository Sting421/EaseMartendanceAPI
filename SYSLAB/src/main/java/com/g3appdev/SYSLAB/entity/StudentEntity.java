package com.g3appdev.SYSLAB.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name = "Students")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String fname;

    @Column
    private String lname;

    @Column
    private String program;

    @Column
    private String yearlevel;

    @Column
    private boolean isDeleted; // Added @Column for consistency

    @OneToOne(mappedBy = "student")
    @JsonBackReference
    private SeatEntity seat;


    public StudentEntity(int id, String fname, String lname, String program, SeatEntity seat) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.program = program;
        this.seat = seat;
    
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getProgram() {
        return program;
    }

    public String getYearlevel() {
        return yearlevel;
    }

    public boolean isDeleted() {
        return isDeleted;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYearlevel(String yearlevel) {
        this.yearlevel = yearlevel;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

   
}
