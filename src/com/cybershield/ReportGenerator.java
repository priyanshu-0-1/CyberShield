package com.cybershield;

import com.cybershield.enums.IncidentStatus;
import com.cybershield.enums.Severity;
import com.cybershield.enums.ThreatType;

import java.util.List;

public class ReportGenerator {

    public static void generateReport(
            List<Incident> incidents) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       CYBERSHIELD SECURITY REPORT");
        System.out.println("========================================");

        if (incidents.isEmpty()) {
            System.out.println("\nNo incidents available for analysis.");
            return;
        }

        int total = incidents.size();

        int low = 0;
        int medium = 0;
        int high = 0;
        int critical = 0;

        int reported = 0;
        int triaged = 0;
        int investigating = 0;
        int contained = 0;
        int resolved = 0;
        int closed = 0;

        int totalRiskScore = 0;

        System.out.println();
        System.out.println("Total Incidents: " + total);

        for (Incident incident : incidents) {

            totalRiskScore += incident.getRiskScore();

            switch (incident.getSeverity()) {

                case LOW:
                    low++;
                    break;

                case MEDIUM:
                    medium++;
                    break;

                case HIGH:
                    high++;
                    break;

                case CRITICAL:
                    critical++;
                    break;
            }

            switch (incident.getStatus()) {

                case REPORTED:
                    reported++;
                    break;

                case TRIAGED:
                    triaged++;
                    break;

                case INVESTIGATING:
                    investigating++;
                    break;

                case CONTAINED:
                    contained++;
                    break;

                case RESOLVED:
                    resolved++;
                    break;

                case CLOSED:
                    closed++;
                    break;
            }
        }

        double averageRisk =
                (double) totalRiskScore / total;

        System.out.println(
                "Average Risk Score: "
                        + String.format("%.2f", averageRisk)
        );

        System.out.println();
        System.out.println("----------- SEVERITY DISTRIBUTION -----------");
        System.out.println("LOW: " + low);
        System.out.println("MEDIUM: " + medium);
        System.out.println("HIGH: " + high);
        System.out.println("CRITICAL: " + critical);

        System.out.println();
        System.out.println("----------- STATUS DISTRIBUTION -----------");
        System.out.println("REPORTED: " + reported);
        System.out.println("TRIAGED: " + triaged);
        System.out.println("INVESTIGATING: " + investigating);
        System.out.println("CONTAINED: " + contained);
        System.out.println("RESOLVED: " + resolved);
        System.out.println("CLOSED: " + closed);

        System.out.println();
        System.out.println("----------- THREAT DISTRIBUTION -----------");

        for (ThreatType threat : ThreatType.values()) {

            int count = 0;

            for (Incident incident : incidents) {

                if (incident.getThreatType() == threat) {
                    count++;
                }
            }

            if (count > 0) {
                System.out.println(threat + ": " + count);
            }
        }

        System.out.println();
        System.out.println("----------- INCIDENT SUMMARY -----------");

        for (Incident incident : incidents) {
            System.out.println(
                    "#" + incident.getId()
                            + " | "
                            + incident.getTitle()
                            + " | "
                            + incident.getSeverity()
                            + " | "
                            + incident.getStatus()
                            + " | Risk: "
                            + incident.getRiskScore()
            );
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("             END OF REPORT");
        System.out.println("========================================");
    }
}
