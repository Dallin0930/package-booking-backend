package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.modle.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {
}
