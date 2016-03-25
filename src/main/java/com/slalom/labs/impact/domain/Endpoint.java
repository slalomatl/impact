package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
@Entity
public class Endpoint {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @OneToMany(mappedBy = "endpoint", cascade = {CascadeType.ALL})
    private List<Contract> contracts;
    @OneToMany(mappedBy = "endpoint", cascade = {CascadeType.ALL})
    private List<Test> tests;
    private String path;
    private String description;
    private String notes;

    protected Endpoint() {}

    public Endpoint(Service service, String path, List<Contract> contracts,
                    List<Test> tests,String description, String notes) {
        this.service = service;
        this.path = path;
        this.contracts = contracts;
        this.tests = tests;
        this.description = description;
        this.notes = notes;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
