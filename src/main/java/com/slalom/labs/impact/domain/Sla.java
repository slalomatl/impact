package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ted on 3/24/16.
 */
@Entity
public class Sla {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne()
    @JoinColumn(name = "contract_revision_id")
    private ContractRevision contractRevision;
    private long maxResponseTimeMs;

    public Sla() { }

    public Sla(ContractRevision contractRevision, long maxResponseTimeMs) {
        this.contractRevision = contractRevision;
        this.maxResponseTimeMs = maxResponseTimeMs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContractRevision getContractRevision() {
        return contractRevision;
    }

    public void setContractRevision(ContractRevision contractRevision) {
        this.contractRevision = contractRevision;
    }

    public long getMaxResponseTimeMs() {
        return maxResponseTimeMs;
    }

    public void setMaxResponseTimeMs(long maxResponseTimeMs) {
        this.maxResponseTimeMs = maxResponseTimeMs;
    }
}
