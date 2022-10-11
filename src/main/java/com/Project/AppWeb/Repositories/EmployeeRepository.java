package com.Project.AppWeb.Repositories;

import com.Project.AppWeb.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    List<Employee> findByIdEnterprise(Integer id);
}
