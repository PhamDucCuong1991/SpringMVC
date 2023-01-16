package com.example.quan_ly_nhan_vien.dao;


import com.example.quan_ly_nhan_vien.model.Employee;
import com.example.quan_ly_nhan_vien.service.EmployeeService;
import com.mysql.cj.xdevapi.Collection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Transactional
public class EmployeeDAO {

    @Autowired
    EntityManager entityManager;

    @Autowired
    EmployeeService employeeService;

    //
    public List<Employee> getAll() {
        String sql = "Select p from Employee p";
        List<Employee> employees = entityManager.createQuery(sql).getResultList();
        return employees;
    }

    public List<Employee> sortBy(String sort) {
        List<Employee> employees = getAll();
        switch (sort) {
            case "id":
                employees.sort(Comparator.comparing(Employee::getEmployeeCode));
                break;
            case "name":
                employees.sort(Comparator.comparing(Employee::getName));
                break;
            case "age":
                employees.sort(Comparator.comparing(Employee::getAge));
                break;
            case "salary":
                employees.sort(Comparator.comparing(Employee::getSalary));
                break;
        }
        return employees;
    }

    //
    public void save(Employee employee) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(employee);
        txn.commit();
    }

    public void delete(Employee employee) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(employee);
        txn.commit();
    }

    //
    public void edit(Employee employee) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(employee);
        txn.commit();
    }

    public Employee findById(int id) {
        String sql = "Select p from Employee p where p.employeeCode = " + id;
        Employee employee = (Employee) entityManager.createQuery(sql).getSingleResult();
        return employee;
    }

    public List<Employee> findListEmployeeByName(String name) {
        List<Employee> newList = new ArrayList<>();
        String sql = "Select p from Employee p";
        List<Employee> employees = entityManager.createQuery(sql).getResultList();
        for (Employee employee : employees) {
            if (employeeService.removeAccent(employee.getName()).toUpperCase().contains(name)) {
                newList.add(employee);
            }
        }
        return newList;
    }
}
