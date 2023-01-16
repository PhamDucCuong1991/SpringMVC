package com.example.quan_ly_nhan_vien.service;

import com.example.quan_ly_nhan_vien.dao.BranchDAO;
import com.example.quan_ly_nhan_vien.model.Branch;
import com.example.quan_ly_nhan_vien.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BranchService {
    @Autowired
    BranchDAO branchDAO;

    public List<Branch> getAll() {
        return branchDAO.getAll();
    }

    public Branch findBranchById(int id){
        return branchDAO.findBranchById(id);
    }
}
