package com.buseni.calcappadmin.domain;

public enum EnumCategory {
    INCOME("Income"),  EXPENSES("Expenses"),OTHER("Other");
    private String category;

    private  EnumCategory(String category) {
        this.category = category;

    }

    public  String  getCategory(){
        return this.category;
    }
}