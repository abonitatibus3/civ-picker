package com.abonitatibus3.civpicker.bootstrap;

import com.abonitatibus3.civpicker.domain.Civilization;
import com.abonitatibus3.civpicker.domain.Leader;
import com.abonitatibus3.civpicker.domain.Tag;
import com.abonitatibus3.civpicker.repositories.CivilizationRepository;
import com.abonitatibus3.civpicker.repositories.LeaderRepository;
import com.abonitatibus3.civpicker.services.CivilizationService;
import com.abonitatibus3.civpicker.services.LeaderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final CivilizationRepository civilizationRepository;
    private final LeaderRepository leaderRepository;

    public DataLoader(CivilizationRepository civilizationRepository, LeaderRepository leaderRepository) {
        this.civilizationRepository = civilizationRepository;
        this.leaderRepository = leaderRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        long count = civilizationRepository.count();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        Leader leader = new Leader();
        leader.setDescription("He's dat boy");
        leader.setName("Gilgamesh");
        leader.addTag(Tag.WAR);

        Civilization civ = new Civilization();
        civ.setName("Mesopotamia");
        civ.setDescription("You know");

        leader.setCivilization(civ);
        civ.addLeader(leader);

        civilizationRepository.save(civ);
        leaderRepository.save(leader);

    }
}
