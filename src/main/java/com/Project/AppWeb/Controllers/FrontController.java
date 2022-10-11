package com.Project.AppWeb.Controllers;

import com.Project.AppWeb.Entities.Employee;
import com.Project.AppWeb.Entities.Enterprise;
import com.Project.AppWeb.Services.EmployeeService;
import com.Project.AppWeb.Services.EnterpriseService;
import com.Project.AppWeb.Services.MoneyMovementService;
import com.Project.AppWeb.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FrontController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MoneyMovementService moneyMovementService;

    //Authentication
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "index";
    }
    @GetMapping("/enterprises")
    public String listEnterprises(Model model) {
        model.addAttribute("enterprises", enterpriseService.getEnterprises());
        return "Enterprises"; //Return template HTML
    }
    @GetMapping("/enterprises/new")
    public String enterpriseForm(Model model) {
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "Enterprise_Form";
    }
    @PostMapping("/enterprises")
    public String saveEnterprise(@ModelAttribute("enterprise") Enterprise enterprise) {
        enterpriseService.saveEnterprise(enterprise);
        return "redirect:/enterprises";
    }
    @GetMapping("/enterprises/edit/{id}")
    public String formEnterpriseEdit (@PathVariable Integer id, Model model) {
        model.addAttribute("enterprise", enterpriseService.getEnterpriseById(id));
        return "Edit_Enterprise";
    }
    @PostMapping("/enterprises/{id}")
    public String updateEnterprise(@PathVariable Integer id, @ModelAttribute("enterprise")
            Enterprise enterprise, Model model) {
        Enterprise enterpriseEx = enterpriseService.getEnterpriseById(id);
        enterpriseEx.setId(id);
        enterpriseEx.setName(enterprise.getName());
        enterpriseEx.setDirection(enterprise.getDirection());
        enterpriseEx.setPhone(enterprise.getPhone());
        enterpriseEx.setNIT(enterprise.getNIT());
        enterpriseEx.setCreatedAt(enterprise.getCreatedAt());
        enterpriseEx.setUpdatedAt(enterprise.getUpdatedAt());

        enterpriseService.saveEnterprise(enterpriseEx);
        return "redirect:/enterprises";
    }
    @GetMapping("/enterprises/{id}")
    public String deleteEnterprise(@PathVariable Integer id) {
        enterpriseService.deleteEnterpriseById(id);
        return "redirect:/enterprises";
    }

    //Employees

    /*@GetMapping("/Enterprise/{id}/Employees")
    public List<Employee> findEnterprise(@PathVariable Integer id) {
        return employeeService.findByIdEnterprise(id);
    }*/

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "Employees"; //Return template HTML
    }
    @GetMapping("/employees/new")
    public String employeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "Employee_Form";
    }
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/edit/{id}")
    public String formEmployeeEdit (@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "Edit_Employee";
    }
    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute("employee")
    Employee employee, Model model) {
        Employee employee1 = employeeService.getEmployeeById(id);
        employee1.setId(id);
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setRol(employee.getRol());
        employee1.setEnterprise(employee.getEnterprise());
        employee1.setCreateAt(employee.getCreateAt());

        employeeService.saveEmployee(employee1);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    //Movements
}