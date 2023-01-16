package com.example.quan_ly_nhan_vien.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee implements Comparable<Employee> {
    @Id
    private int employeeCode;
    private String name;
    private int age;
    private double salary;
    @ManyToOne
    private Branch branch;

    public Employee() {
    }

    public Employee(int employeeCode, String name, int age, double salary, Branch branch) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public int compareTo(Employee o) {
        return this.employeeCode - o.employeeCode;
    }

}
