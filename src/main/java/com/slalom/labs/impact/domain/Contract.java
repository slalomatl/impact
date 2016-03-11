package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ted on 3/10/16.
 */
@Entity
public class Contract {

    @Id
    @Column(name = "contract_id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "endpoint_id")
    private Endpoint endpoint;
    @Basic(optional = false)
    @Column(name = "date_created", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "date_last_edited", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastEdited;
//    @OneToMany(mappedBy = "contract", orphanRemoval = true, cascade = CascadeType.ALL)
//    private List<ContractImpl> contractImpls

    protected Contract() {}

    public Contract(Service consumer, Endpoint endpoint, Date dateCreated, Date dateLastEdited) {
        this.service = consumer;
        this.dateCreated = dateCreated;
        this.dateLastEdited = dateLastEdited;
        this.endpoint = endpoint;
    }

    public Service getConsumer() {
        return service;
    }

    public void setConsumer(Service consumer) {
        this.service = consumer;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastEdited() {
        return dateLastEdited;
    }

    public void setDateLastEdited(Date dateLastEdited) {
        this.dateLastEdited = dateLastEdited;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
