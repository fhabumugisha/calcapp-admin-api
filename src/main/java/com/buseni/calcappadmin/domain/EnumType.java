package com.buseni.calcappadmin.domain;

public enum EnumType {
    BUDGET("Budget"), PURCHASE("Cost"), OTHER("Other");

    private String type;

    private  EnumType(String type) {
        this.type = type;

    }

    public  String  getType(){
        return type;
    }

    }
