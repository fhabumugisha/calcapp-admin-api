package com.buseni.calcappadmin.repo;

import java.util.List;

import com.buseni.calcappadmin.domain.Project;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ProjectRepo
 */
public interface ProjectRepo extends MongoRepository<Project, String> {

	List<Project> findByUserId(ObjectId id);

	Page<Project> findByType(String type, Pageable pageable);

	Page<Project> findByTitleIgnoreCaseContaining(String title, Pageable pageable);
  
    
}