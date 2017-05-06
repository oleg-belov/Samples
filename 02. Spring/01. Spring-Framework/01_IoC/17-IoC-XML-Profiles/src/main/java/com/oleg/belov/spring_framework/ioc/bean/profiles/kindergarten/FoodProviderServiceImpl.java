package com.oleg.belov.spring_framework.ioc.bean.profiles.kindergarten;

import java.util.ArrayList;
import java.util.List;

import com.oleg.belov.spring_framework.ioc.bean.profiles.Food;
import com.oleg.belov.spring_framework.ioc.bean.profiles.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService {

	public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<Food>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));

        return lunchSet;
    }
}
