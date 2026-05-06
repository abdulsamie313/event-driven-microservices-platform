package com.company.platform.userservice.model;

public class UserResponse {

    private Long id;

    private String name;

    private String email;

    public UserResponse(){

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }






}
