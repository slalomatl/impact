package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ted on 3/24/16.
 */
@Entity
public class TestCase {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "contract_revision_id")
    private ContractRevision contractRevision;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String exitCondition;
    private String summary;
    private String stackTrace;
    private String logs;

    public TestCase() { }

    public TestCase(ContractRevision contractRevision, Test test, Date date,
                    String exitCondition, String summary, String stackTrace, String logs) {
        this.contractRevision = contractRevision;
        this.test = test;
        this.date = date;
        this.exitCondition = exitCondition;
        this.summary = summary;
        this.stackTrace = stackTrace;
        this.logs = logs;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExitCondition() {
        return exitCondition;
    }

    public void setExitCondition(String exitCondition) {
        this.exitCondition = exitCondition;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }
}
