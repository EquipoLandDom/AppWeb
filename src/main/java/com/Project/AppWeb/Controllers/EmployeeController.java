package com.Project.AppWeb.Controllers;

import com.Project.AppWeb.Entities.Employee;
import com.Project.AppWeb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class EmployeeController {

    @Autowired
    EmployeeService serviceEmployee;

    @GetMapping
    public List<Employee> getEmployees(){
        return serviceEmployee.getEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return serviceEmployee.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id")Integer id){
        return serviceEmployee.getEmployeeById(id);
    }

    @PatchMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
        Employee user = serviceEmployee.getEmployeeById(id);
        user.setName(employee.getName());
        user.setEmail(employee.getEmail());
        user.setEnterprise(employee.getEnterprise());
        user.setRol(employee.getRol());

        return serviceEmployee.saveEmployee(user);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        boolean ok = serviceEmployee.deleteEmployee(id);
        if (ok){
            return "the employee eliminated successful " + id;
        }else {
            return "it can't delete " + id;
        }
    }
}
