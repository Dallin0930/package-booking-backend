package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.modle.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {
    List<Luggage> findPackagesByStatus(String status);
}
