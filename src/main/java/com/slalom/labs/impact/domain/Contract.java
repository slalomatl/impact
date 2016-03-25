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
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastEdited;
    @OneToMany(mappedBy = "contract", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ContractRevision> revisions;
    @OneToMany(mappedBy = "contract", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Webhook> webhooks;

    protected Contract() {}

    public Contract(Service service, Endpoint endpoint, Date dateCreated,
                    Date dateLastEdited, List<ContractRevision> revisions,
                    List<Webhook> webhooks) {
        this.service = service;
        this.dateCreated = dateCreated;
        this.dateLastEdited = dateLastEdited;
        this.endpoint = endpoint;
        this.revisions = revisions;
        this.webhooks = webhooks;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    public List<ContractRevision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<ContractRevision> revisions) {
        this.revisions = revisions;
    }

    public List<Webhook> getWebhooks() {
        return webhooks;
    }

    public void setWebhooks(List<Webhook> webhooks) {
        this.webhooks = webhooks;
    }
}
