package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
@Entity
public class Service {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String presentedName;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToMany(mappedBy = "service", orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Endpoint> endpoints;
    @OneToMany(mappedBy = "service", cascade = {CascadeType.ALL})
    private List<Contract> contracts;

    protected Service() {}

    public Service(String name, String presentedName, Team team, List<Endpoint> endpoints, List<Contract> contracts) {
        this.name = name;
        this.presentedName = presentedName;
        this.team = team;
        this.endpoints = endpoints;
        this.contracts = contracts;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresentedName() {
        return presentedName;
    }

    public void setPresentedName(String presentedName) {
        this.presentedName = presentedName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
