package com.abonitatibus3.civpicker.repositories;

import com.abonitatibus3.civpicker.domain.Leader;
import org.springframework.data.repository.CrudRepository;

public interface LeaderRepository extends CrudRepository<Leader, Long> {

    Leader findByName(String name);
}
