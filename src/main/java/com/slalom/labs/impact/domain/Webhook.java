package com.slalom.labs.impact.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ted on 3/10/16.
 */
@Entity
public class Webhook {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
    private String url;
    private String secret;
    private boolean skipSslValidation;
    private boolean fireOnTestStarted;
    private boolean fireOnTestPassed;
    private boolean fireOnTestFailed;
    private boolean fireOnContractExpired;
    private boolean fireOnContractChanged;

    public Webhook() { }

    public Webhook(Contract contract, String url, String secret,
                   boolean skipSslValidation, boolean fireOnTestStarted,
                   boolean fireOnTestPassed, boolean fireOnTestFailed,
                   boolean fireOnContractExpired, boolean fireOnContractChanged) {
        this.contract = contract;
        this.url = url;
        this.secret = secret;
        this.skipSslValidation = skipSslValidation;
        this.fireOnTestStarted = fireOnTestStarted;
        this.fireOnTestPassed = fireOnTestPassed;
        this.fireOnTestFailed = fireOnTestFailed;
        this.fireOnContractExpired = fireOnContractExpired;
        this.fireOnContractChanged = fireOnContractChanged;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public boolean isSkipSslValidation() {
        return skipSslValidation;
    }

    public void setSkipSslValidation(boolean skipSslValidation) {
        this.skipSslValidation = skipSslValidation;
    }

    public boolean isFireOnTestStarted() {
        return fireOnTestStarted;
    }

    public void setFireOnTestStarted(boolean fireOnTestStarted) {
        this.fireOnTestStarted = fireOnTestStarted;
    }

    public boolean isFireOnTestPassed() {
        return fireOnTestPassed;
    }

    public void setFireOnTestPassed(boolean fireOnTestPassed) {
        this.fireOnTestPassed = fireOnTestPassed;
    }

    public boolean isFireOnTestFailed() {
        return fireOnTestFailed;
    }

    public void setFireOnTestFailed(boolean fireOnTestFailed) {
        this.fireOnTestFailed = fireOnTestFailed;
    }

    public boolean isFireOnContractExpired() {
        return fireOnContractExpired;
    }

    public void setFireOnContractExpired(boolean fireOnContractExpired) {
        this.fireOnContractExpired = fireOnContractExpired;
    }

    public boolean isFireOnContractChanged() {
        return fireOnContractChanged;
    }

    public void setFireOnContractChanged(boolean fireOnContractChanged) {
        this.fireOnContractChanged = fireOnContractChanged;
    }
}
