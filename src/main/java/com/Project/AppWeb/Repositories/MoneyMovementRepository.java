package com.Project.AppWeb.Repositories;

import com.Project.AppWeb.Entities.MoneyMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MoneyMovementRepository extends JpaRepository<MoneyMovement, Integer> {

    ArrayList<MoneyMovement> findByEnterprise(Integer id);
    ArrayList<MoneyMovement> findByEmployee(Integer id);

    Long mountsByEnterprise(Integer Id);
    Long mountsByEmployee(Integer Id);
    Integer idByEmail(String email);

}
