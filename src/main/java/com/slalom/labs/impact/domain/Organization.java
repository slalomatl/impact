package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
@Entity
public class Organization {

    @Id
    @Column (name = "organization_id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private String presentedName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organization", orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Team> teams;

    protected Organization() {}

    public Organization(String name, String presentedName, List<Team> teams) {
        this.name = name;
        this.presentedName = presentedName;
        this.teams = teams;
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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
