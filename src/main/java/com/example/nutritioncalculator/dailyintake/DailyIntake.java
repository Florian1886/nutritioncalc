package com.example.nutritioncalculator.dailyintake;

import com.example.nutritioncalculator.food.Food;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class DailyIntake {
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    @OneToMany
    private List<Food> foods;
}
