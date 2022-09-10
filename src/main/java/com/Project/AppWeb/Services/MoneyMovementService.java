package com.Project.AppWeb.Services;

import com.Project.AppWeb.Entities.MoneyMovement;
import com.Project.AppWeb.Repositories.MoneyMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoneyMovementService {

    @Autowired
    MoneyMovementRepository repositoryMovement;

    public ArrayList<MoneyMovement> getMovements() {
        return (ArrayList<MoneyMovement>) repositoryMovement.findAll();
    }

    public MoneyMovement getMovementById(Integer id) {
        return repositoryMovement.findById(id).get();
    }

    public MoneyMovement saveMovement(MoneyMovement movement) {
        return repositoryMovement.save(movement);
    }

    public boolean deleteMovement(Integer id) {
        try {
            repositoryMovement.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
