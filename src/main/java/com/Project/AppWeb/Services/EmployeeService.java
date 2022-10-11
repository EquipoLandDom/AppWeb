package com.Project.AppWeb.Services;

import com.Project.AppWeb.Entities.Employee;
import com.Project.AppWeb.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteEmployeeById(Integer id) {
        repositoryEmployee.deleteById(id);
    }

    public List<Employee> findByIdEnterprise(Integer id) {
        return repositoryEmployee.findByIdEnterprise(id);
    }
}
