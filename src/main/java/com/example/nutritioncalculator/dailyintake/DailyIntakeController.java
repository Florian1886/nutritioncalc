package com.example.nutritioncalculator.dailyintake;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequiredArgsConstructor
public class DailyIntakeController {

    private final DailyIntakeService dailyIntakeService;

    @GetMapping("/getDailyIntake")
    public String getDailyIntakes(Model model){

        model.addAttribute("allDailyIntakes", dailyIntakeService.getAllDailyIntake());
        return "test";
    }


}
