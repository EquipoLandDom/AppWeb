package com.Project.AppWeb.Repositories;

import com.Project.AppWeb.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<User, Integer> {

}
