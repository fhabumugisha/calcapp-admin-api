package com.buseni.calcappadmin.repo;

import com.buseni.calcappadmin.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ProjectRepo
 */
public interface UserRepo extends MongoRepository<User, String> {
  
    
}