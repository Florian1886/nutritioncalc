package com.example.nutritioncalculator.dailyintake;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DailyIntakeRepository extends JpaRepository<DailyIntake, Integer> {

    Optional<DailyIntake> findByDate(LocalDate date);
}
