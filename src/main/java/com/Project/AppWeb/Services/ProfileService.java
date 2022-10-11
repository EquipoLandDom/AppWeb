package com.Project.AppWeb.Services;

import com.Project.AppWeb.Entities.User;
import com.Project.AppWeb.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

}
