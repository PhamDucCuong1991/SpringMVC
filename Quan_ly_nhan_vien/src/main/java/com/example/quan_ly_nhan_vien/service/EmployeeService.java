package com.example.quan_ly_nhan_vien.service;

import com.example.quan_ly_nhan_vien.dao.EmployeeDAO;
import com.example.quan_ly_nhan_vien.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public void delete(int id){
        employeeDAO.delete(employeeDAO.findById(id));
    }

    public void edit(Employee employee){
        employeeDAO.edit(employee);
    }

    public void save(Employee employee){
        employeeDAO.save(employee);
    }
    public String removeAccent(String s) {
        //removeAccent - hàm loại bỏ dấu tiếng Việt
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
    }
    public List<Employee> findListByName(String name) {
        name = name.trim();
        name = name.toUpperCase();
        name = removeAccent(name);
        return   employeeDAO.findListEmployeeByName(name);
    }

    public int findIndexById(int id){
        for (Employee employee : getAll()) {
            if (employee.getEmployeeCode()==id){
                return getAll().indexOf(employee);
            }
        }
        return -1;
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : getAll()) {
            if (employee.getEmployeeCode()==id){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> sortBy(String sort){
        return employeeDAO.sortBy(sort);
    }
}
