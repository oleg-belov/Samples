package com.oleg.belov.spring_framework.ioc.spring.exp.lang.bean;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class UserGroup {

    @Value("#{ systemProperties['user.name'] + ' company' }")
    private String name;
    private List<User> users;
    private User owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}
