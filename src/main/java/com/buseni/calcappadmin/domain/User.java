package com.buseni.calcappadmin.domain;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User
 */

@Document("users")

public class User {

    @Id
    private String id;
    private String email;
    private String password;    
     @CreatedDate
    private Date createdAt;
   
   @LastModifiedDate
    private Date updatedAt;

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

    /**
    * @return the createdAt
    */
    public Date getCreatedAt() {
        return createdAt;
    }
 
    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
 /**
  * @return the updatedAt
  */
 public Date getUpdatedAt() {
     return updatedAt;
 }
 
 /**
  * @param updatedAt the updatedAt to set
  */
 public void setUpdatedAt(Date updatedAt) {
     this.updatedAt = updatedAt;
 }
}