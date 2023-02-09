package com.example.nutritioncalculator.dailyintake;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@AllArgsConstructor
public class DailyIntakeController {

    private final DailyIntakeService dailyIntakeService;

    @GetMapping("/getDailyIntake")
    public String/*List<DailyIntake>*/ getDailyIntakes(Model model){

        /*List<DailyIntake> list = dailyIntakeService.getAllDailyIntake();*/
        model.addAttribute("allDailyIntakes", dailyIntakeService.getAllDailyIntake());
        return "test";
    }


}
