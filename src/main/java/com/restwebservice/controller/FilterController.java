package com.restwebservice.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilterController {

    @GetMapping("/filter1")
    public MappingJacksonValue getUserDetails1(){
        List<UserDetails> details = UserDetails.getUserDetails();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userID","userName");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userDetails",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(details);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/filter2")
    public MappingJacksonValue getUserDetails2(){
        List<UserDetails> details = UserDetails.getUserDetails();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userID","panNum");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userDetails",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(details);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}


//@JsonIgnoreProperties(value = {"userName"})
@JsonFilter("userDetails")
class UserDetails {
    //@JsonIgnore
    private int userID;
    private String userName;
    private String panNum;

    public UserDetails(int userID, String userName, String panNum) {
        this.userID = userID;
        this.userName = userName;
        this.panNum = panNum;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPanNum() {
        return panNum;
    }

    public void setPanNum(String panNum) {
        this.panNum = panNum;
    }

    public static List<UserDetails> getUserDetails(){
        return Arrays.asList(new UserDetails(1,"Omar","123456"),
                new UserDetails(2,"Ahmed","123456"),
                new UserDetails(3,"Menna","123456"),
                new UserDetails(4,"Sara","123456"));
    }
}
