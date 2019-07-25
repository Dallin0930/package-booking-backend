package com.oocl.packagebooking.service;

import com.oocl.packagebooking.modle.Luggage;
import com.oocl.packagebooking.modle.LuggageStroe;
import com.oocl.packagebooking.repository.LuggageRepository;
import com.oocl.packagebooking.repository.LuggageStorerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class LuggageService {

    @Autowired
    LuggageRepository luggageRepository;
    @Autowired
    LuggageStorerepository luggageStorerepository;

    @Transactional
    public Luggage addOrder(long id, Luggage luggage) {
        LuggageStroe luggageStroe=luggageStorerepository.findById(id).orElse(null);
        luggage.setLuggageStroe(luggageStroe);
        luggage.setTime(new Date().getTime());
        luggage.setStatus("No Picked");
        return luggageRepository.save(luggage);
    }

    @Transactional
    public Luggage updateStatus(Long id) {
        Luggage luggage=luggageRepository.findById(id).orElse(null);
        luggage.setStatus("picked");
        LuggageStroe luggageStroe= luggage.getLuggageStroe();
        return luggageRepository.save(luggage);
    }

    public List<Luggage> getAllPackages() {
        return luggageRepository.findAll();
    }

    public List<Luggage> getPackagesByStatus(String status) {
        return luggageRepository.findPackagesByStatus(status);
    }
}


