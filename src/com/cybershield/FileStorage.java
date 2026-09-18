package com.cybershield;

import com.cybershield.enums.IncidentStatus;
import com.cybershield.enums.Severity;
import com.cybershield.enums.ThreatType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {

    private static final String INCIDENT_FILE = "data/incidents.csv";

    public static void saveIncidents(List<Incident> incidents) {

        File file = new File(INCIDENT_FILE);

        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {

            writer.println(
                    "id,title,threat,severity,status,riskScore,reportedBy"
            );

            for (Incident incident : incidents) {

                writer.println(
                        incident.getId() + "," +
                        clean(incident.getTitle()) + "," +
                        incident.getThreatType() + "," +
                        incident.getSeverity() + "," +
                        incident.getStatus() + "," +
                        incident.getRiskScore() + "," +
                        clean(incident.getReportedBy())
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving incidents: " + e.getMessage()
            );
        }
    }

    public static List<Incident> loadIncidents() {

        List<Incident> incidents = new ArrayList<>();

        File file = new File(INCIDENT_FILE);

        if (!file.exists()) {
            return incidents;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;

            // Skip CSV header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 7) {
                    continue;
                }

                try {

                    int id = Integer.parseInt(data[0]);

                    String title = data[1];

                    ThreatType threatType =
                            ThreatType.valueOf(data[2]);

                    Severity severity =
                            Severity.valueOf(data[3]);

                    IncidentStatus status =
                            IncidentStatus.valueOf(data[4]);

                    int riskScore =
                            Integer.parseInt(data[5]);

                    String reportedBy = data[6];

                    Incident incident = new Incident(
                            id,
                            title,
                            threatType,
                            severity,
                            status,
                            riskScore,
                            reportedBy
                    );

                    incidents.add(incident);

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Skipping invalid incident record."
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading incidents: " + e.getMessage()
            );
        }

        return incidents;
    }

    private static String clean(String value) {

        if (value == null) {
            return "";
        }

        return value
                .replace(",", " ")
                .replace("\n", " ")
                .replace("\r", " ");
    }
}
