package com.cybershield;

import com.cybershield.enums.IncidentStatus;
import com.cybershield.enums.Severity;
import com.cybershield.enums.ThreatType;

import java.util.ArrayList;
import java.util.List;

public class IncidentManager {

    private final List<Incident> incidents;
    private int nextId;

    public IncidentManager() {

        incidents = FileStorage.loadIncidents();

        nextId = 1;

        for (Incident incident : incidents) {

            if (incident.getId() >= nextId) {
                nextId = incident.getId() + 1;
            }
        }
    }

    public Incident createIncident(
            String title,
            ThreatType threatType,
            Severity severity,
            int riskScore,
            String reportedBy) {

        Incident incident = new Incident(
                nextId,
                title,
                threatType,
                severity,
                IncidentStatus.REPORTED,
                riskScore,
                reportedBy
        );

        incidents.add(incident);
        nextId++;

        FileStorage.saveIncidents(incidents);

        return incident;
    }

    public List<Incident> getAllIncidents() {
        return incidents;
    }

    public Incident findIncidentById(int id) {

        for (Incident incident : incidents) {

            if (incident.getId() == id) {
                return incident;
            }
        }

        return null;
    }

    public boolean updateStatus(
            int id,
            IncidentStatus newStatus) {

        Incident incident = findIncidentById(id);

        if (incident == null) {
            return false;
        }

        incident.setStatus(newStatus);

        FileStorage.saveIncidents(incidents);

        return true;
    }

    public boolean updateSeverity(
            int id,
            Severity newSeverity) {

        Incident incident = findIncidentById(id);

        if (incident == null) {
            return false;
        }

        incident.setSeverity(newSeverity);

        FileStorage.saveIncidents(incidents);

        return true;
    }
}
