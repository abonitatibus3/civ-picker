package com.abonitatibus3.civpicker.services;

import com.abonitatibus3.civpicker.domain.Civilization;

public interface CivilizationService extends CrudService<Civilization, Long> {

    Civilization findByName(String name);
}
