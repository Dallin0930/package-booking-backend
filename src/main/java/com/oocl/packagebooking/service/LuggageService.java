package com.oocl.packagebooking.service;

import com.oocl.packagebooking.modle.Luggage;
import com.oocl.packagebooking.modle.LuggageStroe;
import com.oocl.packagebooking.repository.LuggageRepository;
import com.oocl.packagebooking.repository.LuggageStorerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LuggageService {

    @Autowired
    LuggageRepository luggageRepository;
    @Autowired
    LuggageStorerepository luggageStorerepository;

    public Luggage addOrder(long id, Luggage luggage) {
        LuggageStroe luggageStroe=luggageStorerepository.findById(id).orElse(null);
        luggage.setLuggageStroe(luggageStroe);
        luggage.setTime(new Date().getTime());
        luggage.setStatus("No Picked");
        return luggageRepository.save(luggage);
    }
}

