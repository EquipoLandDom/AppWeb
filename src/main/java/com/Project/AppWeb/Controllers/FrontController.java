package com.Project.AppWeb.Controllers;

import com.Project.AppWeb.Entities.Enterprise;
import com.Project.AppWeb.Services.EmployeeService;
import com.Project.AppWeb.Services.EnterpriseService;
import com.Project.AppWeb.Services.MoneyMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FrontController {

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MoneyMovementService moneyMovementService;

    @GetMapping("/Enterprises")
    public String listStudents(Model model) {
        model.addAttribute("enterprises", enterpriseService.getEnterprises());
        return "Enterprises"; //Return template HTML
    }

    @GetMapping("/Enterprises/New")
    public String enterpriseForm(Model model) {
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "Enterprise_Form";
    }

    @PostMapping("/Enterprises/New")
    public String saveEnterprise(Enterprise enterprise, RedirectAttributes redirect) {
        enterpriseService.saveEnterprise(enterprise);
        redirect.addFlashAttribute("msgExito", "adding successfully");
        return "redirect:/Enterprises";
    }
}