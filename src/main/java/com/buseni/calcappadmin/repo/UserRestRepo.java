package com.buseni.calcappadmin.repo;

import com.buseni.calcappadmin.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/**
 * ProjectRepo
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRestRepo extends MongoRepository<User, String> {
  
    
}