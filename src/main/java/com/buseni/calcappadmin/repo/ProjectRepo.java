package com.buseni.calcappadmin.repo;

import java.util.List;

import com.buseni.calcappadmin.domain.Project;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ProjectRepo
 */
public interface ProjectRepo extends MongoRepository<Project, String> {

	List<Project> findByUserId(ObjectId id);

	List<Project> findByType(String type);

	List<Project> findByTitleIgnoreCaseContaining(String title);
  
    
}