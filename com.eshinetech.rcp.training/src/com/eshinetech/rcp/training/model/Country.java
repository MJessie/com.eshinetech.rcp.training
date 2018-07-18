package com.eshinetech.rcp.training.model;

import java.util.ArrayList;
import java.util.List;

/**
 * class  desc：
 * @author WuChengRui  
 * @date 2018-6-26  
 */
public class Country {
    private String name;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List getCountryList() {
        List list = new ArrayList<>();
        list.add(new Country("中国"));
        list.add(new Country("美国"));
        list.add(new Country("日本"));
        return list;
    }
}