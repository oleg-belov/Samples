package com.oleg.belov.spring_framework.ioc.bean.profiles.highschool;

import java.util.ArrayList;
import java.util.List;

import com.oleg.belov.spring_framework.ioc.bean.profiles.Food;
import com.oleg.belov.spring_framework.ioc.bean.profiles.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService {
	
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<Food>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));

        return lunchSet;
    }
}
