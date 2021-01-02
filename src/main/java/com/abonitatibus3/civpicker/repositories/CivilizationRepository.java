package com.abonitatibus3.civpicker.repositories;

import com.abonitatibus3.civpicker.domain.Civilization;
import org.springframework.data.repository.CrudRepository;

public interface CivilizationRepository extends CrudRepository<Civilization, Long> {

    Civilization findByName(String name);
}
