package com.buseni.calcappadmin.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("projects")
public class Project  {

    @Id
    private String id;
    private String type;
    private String title;

    private String description;

    private BigDecimal totalAmount;

    private List<Item> items;
    private List<Category> categories;

    @CreatedDate
    private Date createdAt;
   
   @LastModifiedDate
    private Date updatedAt;

  
    private ObjectId userId;

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setType(String type) {
        this.type = type;
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
/**
 * @return the userId
 */
public ObjectId getUserId() {
    return userId;
}

/**
 * @param userId the userId to set
 */
public void setUserId(ObjectId userId) {
    this.userId = userId;
}

}