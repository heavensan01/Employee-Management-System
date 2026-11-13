package com.example.ems.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Payroll {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false) private Employee employee;
    @Column(name="payroll_month", nullable=false) private String month;
    private BigDecimal basicSalary;
    private BigDecimal allowances;
    private BigDecimal deductions;
    private BigDecimal netSalary;
    public Payroll(){}
    public Long getId(){return id;} public Employee getEmployee(){return employee;}
    public String getMonth(){return month;} public BigDecimal getBasicSalary(){return basicSalary;}
    public BigDecimal getAllowances(){return allowances;} public BigDecimal getDeductions(){return deductions;}
    public BigDecimal getNetSalary(){return netSalary;}
    public void setId(Long v){id=v;} public void setEmployee(Employee v){employee=v;}
    public void setMonth(String v){month=v;} public void setBasicSalary(BigDecimal v){basicSalary=v;}
    public void setAllowances(BigDecimal v){allowances=v;} public void setDeductions(BigDecimal v){deductions=v;}
    public void setNetSalary(BigDecimal v){netSalary=v;}
}
