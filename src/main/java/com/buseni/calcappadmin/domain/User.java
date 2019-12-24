package com.buseni.calcappadmin.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * User
 */

@Document("users")

public class User {

    @Id
    private String id;
    private String email;
    private String password;    
   

   public User(String id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
 
    }
  
   /**
    * @return the id
    */
   public String getId() {
       return id;
   }
   /**
    * @param id the id to set
    */
   public void setId(String id) {
       this.id = id;
   }

   /**
    * @return the email
    */
   public String getEmail() {
       return email;
   }
   /**
    * @param email the email to set
    */
   public void setEmail(String email) {
       this.email = email;
   }

   /**
    * @return the password
    */
   public String getPassword() {
       return password;
   }

   /**
    * @param password the password to set
    */
   public void setPassword(String password) {
       this.password = password;
   }

  
}