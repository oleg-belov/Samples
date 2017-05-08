package com.oleg.belov.spring_framework.aop.adviser.bean;

public class RegionManager {

    private String name;
    private int number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void getInfo() {
        System.out.println("Name = " + name + " number= " + number);
    }

    public void throwException() {
        throw new IllegalArgumentException();
    }

}
