package com.buseni.calcappadmin.controller;

import java.util.List;

import com.buseni.calcappadmin.domain.DocumentNotFoundException;
import com.buseni.calcappadmin.domain.Project;
import com.buseni.calcappadmin.domain.User;
import com.buseni.calcappadmin.repo.ProjectRepo;
import com.buseni.calcappadmin.repo.UserRepo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminController
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserRepo userRepo;
    private ProjectRepo projectRepo;
    @Autowired
    UsersController(UserRepo userRepo, ProjectRepo projectRepo){
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @GetMapping("")
    public Page<User> fetchAll (Pageable pageable){
        return userRepo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id){
        return userRepo.findById(id).orElseThrow(() -> new DocumentNotFoundException("Project not found"));
    }

    @GetMapping("/{id}/projects")
    public List<Project> findUserProjects(@PathVariable("id") ObjectId id){
        return projectRepo.findByUserId(id);
    }



   

    
}