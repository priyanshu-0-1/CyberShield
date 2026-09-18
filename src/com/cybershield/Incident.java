package com.cybershield;

import com.cybershield.enums.IncidentStatus;
import com.cybershield.enums.Severity;
import com.cybershield.enums.ThreatType;

public class Incident {

    private int id;
    private String title;
    private ThreatType threatType;
    private Severity severity;
    private IncidentStatus status;
    private int riskScore;
    private String reportedBy;

    public Incident(int id, String title, ThreatType threatType,
                    Severity severity, IncidentStatus status,
                    int riskScore, String reportedBy) {

        this.id = id;
        this.title = title;
        this.threatType = threatType;
        this.severity = severity;
        this.status = status;
        this.riskScore = riskScore;
        this.reportedBy = reportedBy;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ThreatType getThreatType() {
        return threatType;
    }

    public Severity getSeverity() {
        return severity;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {

        return "ID: " + id +
                " | Title: " + title +
                " | Threat: " + threatType +
                " | Severity: " + severity +
                " | Status: " + status +
                " | Risk Score: " + riskScore +
                " | Reported By: " + reportedBy;
    }
}
