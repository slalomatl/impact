package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
@Entity
public class Team {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
    private String name;
    private String presentedName;
//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<Endpoint> endpoints;
//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<Contract> contracts;

    protected Team() {}

//    public Team(Organization organization, String name, String presentedName,
//                List<Endpoint> endpoints, List<Contract> contracts) {
//        this.organization = organization;
//        this.name = name;
//        this.presentedName = presentedName;
//        this.endpoints = endpoints;
//        this.contracts = contracts;
//    }

    public Team(Organization organization, String name, String presentedName) {
        this.organization = organization;
        this.name = name;
        this.presentedName = presentedName;
//        this.endpoints = endpoints;
//        this.contracts = contracts;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getPresentedName() {
        return presentedName;
    }

    public void setPresentedName(String presentedName) {
        this.presentedName = presentedName;
    }
}
