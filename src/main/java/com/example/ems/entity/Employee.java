package com.example.ems.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    private String phone;
    private String address;
    private BigDecimal salary;
    @ManyToOne private Department department;
    @ManyToOne private Designation designation;

    public Employee(){}
    public Long getId(){return id;} public String getName(){return name;}
    public String getEmail(){return email;} public String getPhone(){return phone;}
    public String getAddress(){return address;} public BigDecimal getSalary(){return salary;}
    public Department getDepartment(){return department;} public Designation getDesignation(){return designation;}
    public void setId(Long v){id=v;} public void setName(String v){name=v;} public void setEmail(String v){email=v;}
    public void setPhone(String v){phone=v;} public void setAddress(String v){address=v;}
    public void setSalary(BigDecimal v){salary=v;} public void setDepartment(Department v){department=v;}
    public void setDesignation(Designation v){designation=v;}
}
