package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.modle.Luggage;
import com.oocl.packagebooking.repository.LuggageRepository;
import com.oocl.packagebooking.service.LuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LuggageController {
    @Autowired
    LuggageService luggageService;

    @Autowired
    LuggageRepository luggageRepository;


    @GetMapping("/packages")
    public List<Luggage> getAllPackages(@RequestParam(defaultValue = "") String status) {
        if(status.equals("")) {
            return luggageService.getAllPackages();
        } else {
            return luggageService.getPackagesByStatus(status);
        }
    }

    @PostMapping("/order/LuggageStore/{id}")
    public Luggage addOrder(@PathVariable("id")Long id, @RequestBody Luggage luggage){
        return luggageService.addOrder(id,luggage);
    }

    @PatchMapping("/orders/{id}")
    public Luggage updateStatus(@PathVariable Long id){
        return  luggageService.updateStatus(id);
    }
}
