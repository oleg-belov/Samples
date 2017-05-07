package com.oleg.belov.spring_framework.spel.spring.exp.lang.bean;

public class Customer {


    private String name;
    private Product product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public String getSuperName() {
        return "Superman";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
