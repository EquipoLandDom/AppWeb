package com.Project.AppWeb.Services;

import com.Project.AppWeb.Entities.Enterprise;
import com.Project.AppWeb.Repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    EnterpriseRepository repositoryEnterprise;

    public List<Enterprise> getEnterprises(){
        return repositoryEnterprise.findAll();
    }

    public Enterprise getEnterpriseById(Integer id){
        return repositoryEnterprise.findById(id).get();
    }

    public Enterprise saveEnterprise (Enterprise enterprise){
        return repositoryEnterprise.save(enterprise);
    }

    public boolean deleteEnterprise(Integer id){
        try{
            repositoryEnterprise.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
