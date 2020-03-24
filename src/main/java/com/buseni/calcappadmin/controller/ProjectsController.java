package com.buseni.calcappadmin.controller;

import com.buseni.calcappadmin.domain.DocumentNotFoundException;
import com.buseni.calcappadmin.domain.Project;
import com.buseni.calcappadmin.repo.ProjectRepo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AdminController
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectsController {

    private ProjectRepo projectRepo;
    @Autowired
    ProjectsController(ProjectRepo projectRepo){
        this.projectRepo = projectRepo;
    }

    @GetMapping("")
    public Page<Project> fetchAll (@AuthenticationPrincipal Jwt jwt, @RequestParam(name="type", required = false) String type, 
    @SortDefault.SortDefaults({
        @SortDefault(sort = "title", direction = Sort.Direction.DESC),
        @SortDefault(sort = "createdAt", direction = Sort.Direction.DESC)
    })Pageable pageable){
        
            System.out.println(jwt.getClaims());
       ObjectId userId = jwt.getClaim("userId");
       
        if(null != type && !"".equals(type)){
            return projectRepo.findByType(type, pageable);
        }else{
            return projectRepo.findByUserId(userId, pageable);
        }
        
    }

    @GetMapping("/{id}")
    @PostAuthorize("@owner.apply(returnObject, principal.claims['userId'])")
    public Project findById(@PathVariable("id") String id){
        return projectRepo.findById(id).orElseThrow(() -> new DocumentNotFoundException("Project not found"));
    }

    // @GetMapping("/")
    // public Page<Project> findByType(@RequestParam("type") String type, Pageable pageable){
    //     return projectRepo.findByType(type, pageable);
    // }
    @GetMapping("/search")
    public Page<Project> findByTitle(@RequestParam("title") String title,  Pageable pageable){
        return projectRepo.findByTitleIgnoreCaseContaining(title, pageable);
    }



   

    
}