package com.oleg.belov.spring_framework.spel.spring.exp.lang.bean;

import org.springframework.stereotype.Component;

@Component("priceBean")
public class Price {

    private int price;

    public int getWorstPrice() {
        return 999;
    }

    public int getBestPrice() {
        return 100;
    }

}
