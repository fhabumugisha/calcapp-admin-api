package com.buseni.calcappadmin.repo;

import java.util.List;

import com.buseni.calcappadmin.domain.Project;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
/**
 * ProjectRepo
 */
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectRestRepo extends MongoRepository<Project, String> {

	List<Project> findByUserId(@Param("id") ObjectId id);

	List<Project> findByType(@Param("type") String type);

	List<Project> findByTitleIgnoreCaseContaining(@Param("title") String title);
  
    
}