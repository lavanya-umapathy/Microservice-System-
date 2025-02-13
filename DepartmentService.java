package com.example.demo_department.service;

import com.example.demo_department.entity.Department;
import com.example.demo_department.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    // Create a new department
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    // Get all departments
   /* public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }*/

    // Get a department by ID
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepo.findById(departmentId);
    }

    // Update a department
    public Department updateDepartment(Department department) {
        return departmentRepo.save(department);
    }

    // Delete a department by ID
    public void deleteDepartment(Long departmentId) {
        departmentRepo.deleteById(departmentId);
    }
}