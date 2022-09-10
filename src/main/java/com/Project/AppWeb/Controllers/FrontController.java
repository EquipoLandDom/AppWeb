/*package com.Project.AppWeb.Controllers;

import com.Project.AppWeb.Entities.Enterprise;
import com.Project.AppWeb.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontController {

    @Autowired
    EnterpriseService service;

    @GetMapping("/")
    public String index(){
        return "Index";
    }
    @GetMapping("/Enterprises")
    public String viewEnterprises(Model model){
        model.addAttribute("enterprises", service.getEnterprises());
        return "Enterprises";
    }
    @RequestMapping("/Enterprises/New")
    public String newEnterprise (Model model){
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "createEnterprise";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEnterprise (@ModelAttribute("enterprise") Enterprise enterprise){
        service.saveEnterprise(enterprise);
        return "redirect:/Enterprises";
    }
}*/