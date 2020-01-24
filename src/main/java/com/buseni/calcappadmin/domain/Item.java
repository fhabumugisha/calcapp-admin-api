package com.buseni.calcappadmin.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Item
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Item {

    /**
     *
     */
    @Id
    private String id;
    private String description;
    private String title;
    private BigDecimal amount;

    public Item(String id,String title, String description,BigDecimal amount){
        this.id =id;
        this.title = title;
        this.description = description;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
}