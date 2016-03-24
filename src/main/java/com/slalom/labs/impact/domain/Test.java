package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by ted on 3/10/16.
 */
@Entity
public class Test {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "endpoint_id")
    private Endpoint endpoint;
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStarted;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCompleted;
    @Min(0)@Max(1)
    private float percentPassed;
    @Min(0)@Max(100)
    private float deltaPassed;
    String status;

    public Test() { }

    public Test(Endpoint endpoint, Date dateStarted, Date dateCompleted,
                float percentPassed, float deltaPassed, String status) {
        this.endpoint = endpoint;
        this.dateStarted = dateStarted;
        this.dateCompleted = dateCompleted;
        this.percentPassed = percentPassed;
        this.deltaPassed = deltaPassed;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public float getPercentPassed() {
        return percentPassed;
    }

    public void setPercentPassed(float percentPassed) {
        this.percentPassed = percentPassed;
    }

    public float getDeltaPassed() {
        return deltaPassed;
    }

    public void setDeltaPassed(float deltaPassed) {
        this.deltaPassed = deltaPassed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
