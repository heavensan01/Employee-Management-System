package com.example.ems.entity;

import jakarta.persistence.*;

@Entity
public class Department {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false, unique=true) private String name;
    public Department(){}
    public Department(String name){this.name=name;}
    public Long getId(){return id;} public String getName(){return name;}
    public void setId(Long id){this.id=id;} public void setName(String n){name=n;}
}
