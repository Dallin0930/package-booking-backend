package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.modle.Luggage;
import com.oocl.packagebooking.repository.LuggageRepository;
import com.oocl.packagebooking.service.LuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuggageController {
    @Autowired
    LuggageService luggageService;

    @Autowired
    LuggageRepository luggageRepository;

    @PostMapping("/order/LuggageStore/{id}")
    public Luggage addOrder(@PathVariable("id")Long id, @RequestBody Luggage luggage){
        return luggageService.addOrder(id,luggage);
    }

}
