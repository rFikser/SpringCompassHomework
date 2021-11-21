package ru.compass.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.compass.logic.Compass;

import java.util.Map;

@RestController
public class Controller {
    private static final Compass compass = Compass.getInstance();


    @PostMapping (value = "/setSides", consumes = "application/json")
    public void setSides(@RequestBody Map<String, String> range){
        compass.setRange(range);
    }

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public Map<String, String> getSide(@RequestBody Map<String,Integer> degree) {
        return compass.getSide(degree.get("Degree"));
    }


}
