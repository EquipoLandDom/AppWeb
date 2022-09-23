package com.Project.AppWeb.Repositories;

import com.Project.AppWeb.Entities.MoneyMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyMovementRepository extends JpaRepository<MoneyMovement, Integer> {
}
