package com.example.nutritioncalculator.food;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/addFood")
    public Food addFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @PostMapping("/addFoods")
    public List<Food> addFoods(@RequestBody List<Food> foods) {
        return foodService.saveFoods(foods);
    }

    @GetMapping("/getFoods")
    public List<Food> findAllFoods() {
        return foodService.getFoods();
    }

    @GetMapping("/getFoodId/{id}")
    public Food findFoodById(@PathVariable int id) {
        return foodService.getFoodById(id);
    }

    @GetMapping("/getFoodName/{name}")
    public Food findFoodByName(@PathVariable String name) {
        return foodService.getFoodByName(name);
    }

    @PutMapping("/updateFood")
    public Food updateFood(@RequestBody Food food) {
        return foodService.updateFood(food);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFood(@PathVariable int id) {
        return foodService.deleteFood(id);
    }

    @GetMapping("/menuFood")
    public String showAllFood(Model model){
        model.addAttribute("foods", foodService.getFoods());
        return "menuFood";
    }



}
