package com.abonitatibus3.civpicker.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Civilization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "civilization")
    private Set<Leader> leaders;

    public Civilization() {
        this.leaders = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Leader> getLeaders() {
        return leaders;
    }

    public void setLeaders(Set<Leader> leaders) {
        this.leaders = leaders;
    }

    public void addLeader(Leader leader) {
        this.leaders.add(leader);
    }
}
