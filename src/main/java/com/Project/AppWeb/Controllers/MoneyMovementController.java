package com.Project.AppWeb.Controllers;

/*import com.Project.AppWeb.Entities.MoneyMovement;
import com.Project.AppWeb.Services.MoneyMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class MoneyMovementController {

    @Autowired
    MoneyMovementService serviceMovement;

    @GetMapping()
    public List<MoneyMovement> getMovements(){
        return serviceMovement.getMovements();
    }

    @PostMapping()
    public MoneyMovement saveMovement(@RequestBody MoneyMovement movement){
        return serviceMovement.saveMovement(movement);
    }

    @GetMapping("/{id}")
    public MoneyMovement getMovementById(@PathVariable("id")Integer id){
        return serviceMovement.getMovementById(id);
    }

    @PatchMapping("/{id}")
    public MoneyMovement updateMovement(@PathVariable("id") Integer id, @RequestBody MoneyMovement movement){
        MoneyMovement movementU = serviceMovement.getMovementById(id);
        movementU.setMount(movement.getMount());
        movementU.setConcept(movement.getConcept());
        movementU.setCreateAt(movement.getCreateAt());
        movementU.setEnterprise(movement.getEnterprise());
        movementU.setUser(movement.getUser());

        return serviceMovement.saveMovement(movementU);
    }

    @DeleteMapping()
    public String deleteMovement(@PathVariable("") Integer id){
        boolean ok = serviceMovement.deleteMovement(id);
        if (ok){
            return "the employee eliminated successful " + id;
        }else {
            return "it can't delete " + id;
        }
    }
}*/
