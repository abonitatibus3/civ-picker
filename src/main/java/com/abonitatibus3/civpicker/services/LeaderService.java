package com.abonitatibus3.civpicker.services;

import com.abonitatibus3.civpicker.domain.Leader;

public interface LeaderService extends CrudService<Leader, Long> {

    Leader findByName(String name);

}
