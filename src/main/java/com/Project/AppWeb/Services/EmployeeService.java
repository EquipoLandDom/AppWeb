package com.Project.AppWeb.Services;

import com.Project.AppWeb.Entities.Employee;
import com.Project.AppWeb.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repositoryEmployee;

    public ArrayList<Employee> getEmployees() {
        return (ArrayList<Employee>) repositoryEmployee.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return repositoryEmployee.findById(id).get();
    }

    public Employee saveEmployee(Employee employee) {
        return repositoryEmployee.save(employee);
    }

    public boolean deleteEmployee(Integer id) {
        try {
            repositoryEmployee.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
