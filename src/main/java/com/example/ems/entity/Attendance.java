package com.example.ems.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Attendance {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) private Employee employee;
    @Column(nullable=false) private LocalDate date;
    @Column(nullable=false) private boolean present;
    public Attendance(){}
    public Long getId(){return id;} public Employee getEmployee(){return employee;}
    public LocalDate getDate(){return date;} public boolean isPresent(){return present;}
    public void setId(Long v){id=v;} public void setEmployee(Employee v){employee=v;}
    public void setDate(LocalDate v){date=v;} public void setPresent(boolean v){present=v;}
}
