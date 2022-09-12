package com.Project.AppWeb.Controllers;

import com.Project.AppWeb.Entities.Enterprise;
import com.Project.AppWeb.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/")
@CrossOrigin("*")
public class EnterpriseController {

    @Autowired
    EnterpriseService serviceEnterprise;

    @GetMapping(value = "/Enterprises")
    public List<Enterprise> getEnterprises(){
        return serviceEnterprise.getEnterprises();
    }

    @PostMapping(value = "/SaveC")
    public Enterprise saveEnterprise(@RequestBody Enterprise enterprise){
        return serviceEnterprise.saveEnterprise(enterprise);
    }

    @GetMapping(value = "/FindC/{id}")
    public Enterprise getEnterpriseById(@PathVariable("id")Integer id){
        return serviceEnterprise.getEnterpriseById(id);
    }

    @PatchMapping(value = "/PatchC/{id}")
    public Enterprise updateEnterprise(@PathVariable("id") Integer id, @RequestBody Enterprise enterprise){
        Enterprise company = serviceEnterprise.getEnterpriseById(id);
        company.setName(enterprise.getName());
        company.setDirection(enterprise.getDirection());
        company.setPhone(enterprise.getPhone());
        company.setNIT(enterprise.getNIT());
        company.setUpdateAt(enterprise.getUpdateAt());

        return serviceEnterprise.saveEnterprise(company);
    }

    @DeleteMapping(value = "/deleteC/{id}")
    public String deleteEnterprise(@PathVariable("id") int id){
        boolean ok = serviceEnterprise.deleteEnterprise(id);
        if (ok){
            return "the enterprise eliminated successful " + id;
        }else {
            return "it can't delete " + id;
        }
    }
}
