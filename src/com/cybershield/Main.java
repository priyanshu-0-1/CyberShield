package com.cybershield;

import com.cybershield.enums.IncidentStatus;
import com.cybershield.enums.Severity;
import com.cybershield.enums.ThreatType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        IncidentManager incidentManager = new IncidentManager();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("              CYBERSHIELD");
            System.out.println(" Cybersecurity Incident Management System");
            System.out.println("========================================");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("\nEnter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    System.out.print("Username: ");
                    String username = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    User user = authService.login(username, password);

                    if (user != null) {

                        System.out.println();
                        System.out.println("Login successful!");
                        System.out.println("Welcome, " + user.getUsername());
                        System.out.println("Role: " + user.getRole());

                        showDashboard(user, scanner, incidentManager);

                    } else {

                        System.out.println();
                        System.out.println("Invalid username or password.");
                    }

                    break;

                case "2":

                    running = false;
                    System.out.println("\nThank you for using CyberShield.");
                    break;

                default:

                    System.out.println("\nInvalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showDashboard(
            User user,
            Scanner scanner,
            IncidentManager incidentManager) {

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("           CYBERSHIELD DASHBOARD");
            System.out.println("========================================");
            System.out.println("Logged in as: " + user.getUsername());
            System.out.println("Role: " + user.getRole());
            System.out.println();

            System.out.println("1. Incident Management");
            System.out.println("2. Threat & Risk Assessment");
            System.out.println("3. Investigation & Incident Lifecycle");
            System.out.println("4. Security Reports & Analytics");
            System.out.println("5. Logout");

            System.out.print("\nEnter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    incidentManagementMenu(
                            user,
                            scanner,
                            incidentManager
                    );
                    break;

                case "2":
                    if (user.getRole().name().equals("ADMIN")
                            || user.getRole().name().equals("SECURITY_ANALYST")) {

                        riskAssessmentMenu(scanner);

                    } else {

                        System.out.println(
                                "\nAccess denied. You do not have permission "
                                        + "to use Risk Assessment."
                        );
                    }
                    break;

                case "3":
                    if (user.getRole().name().equals("ADMIN")
                            || user.getRole().name().equals("SECURITY_ANALYST")
                            || user.getRole().name().equals("INCIDENT_MANAGER")) {

                        investigationMenu(
                                scanner,
                                incidentManager
                        );

                    } else {

                        System.out.println(
                                "\nAccess denied. You do not have permission "
                                        + "to use Investigation."
                        );
                    }
                    break;

                case "4":
                    ReportGenerator.generateReport(
                            incidentManager.getAllIncidents()
                    );
                    break;

                case "5":
                    loggedIn = false;
                    System.out.println("\nLogged out successfully.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }


    private static void investigationMenu(
            Scanner scanner,
            IncidentManager incidentManager) {

        boolean insideMenu = true;

        while (insideMenu) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("     INVESTIGATION & INCIDENT LIFECYCLE");
            System.out.println("========================================");
            System.out.println();

            System.out.println("1. View Incident Lifecycle");
            System.out.println("2. Advance Incident Status");
            System.out.println("3. Back to Dashboard");

            System.out.print("\nEnter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    System.out.println();
                    System.out.println("Incident Lifecycle:");
                    System.out.println(
                            "REPORTED -> TRIAGED -> INVESTIGATING"
                    );
                    System.out.println(
                            "-> CONTAINED -> RESOLVED -> CLOSED"
                    );
                    break;

                case "2":

                    updateIncidentStatus(
                            scanner,
                            incidentManager
                    );
                    break;

                case "3":

                    insideMenu = false;
                    break;

                default:

                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }
    }

    private static void riskAssessmentMenu(Scanner scanner) {

        boolean insideMenu = true;

        while (insideMenu) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       THREAT & RISK ASSESSMENT");
            System.out.println("========================================");
            System.out.println();
            System.out.println("Risk Score = Impact × Likelihood × Asset Criticality");
            System.out.println("Each factor must be between 1 and 5.");
            System.out.println();
            System.out.println("1. Calculate Risk Score");
            System.out.println("2. Back to Dashboard");

            System.out.print("\nEnter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    int impact = readRiskFactor(
                            scanner,
                            "Impact"
                    );

                    int likelihood = readRiskFactor(
                            scanner,
                            "Likelihood"
                    );

                    int assetCriticality = readRiskFactor(
                            scanner,
                            "Asset Criticality"
                    );

                    RiskAssessment.displayRiskAssessment(
                            impact,
                            likelihood,
                            assetCriticality
                    );

                    break;

                case "2":
                    insideMenu = false;
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }
    }

    private static int readRiskFactor(
            Scanner scanner,
            String factorName) {

        return InputValidator.readInt(
                scanner,
                factorName + " (1-5): ",
                1,
                5
        );
    }

    private static void incidentManagementMenu(
            User user,
            Scanner scanner,
            IncidentManager incidentManager) {

        boolean insideMenu = true;

        while (insideMenu) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("        INCIDENT MANAGEMENT");
            System.out.println("========================================");
            System.out.println();

            System.out.println("1. Create Incident");
            System.out.println("2. View All Incidents");
            System.out.println("3. Search Incident");
            System.out.println("4. Update Incident Status");
            System.out.println("5. Update Incident Severity");
            System.out.println("6. Back to Dashboard");

            System.out.print("\nEnter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    if (user.getRole().name().equals("ADMIN")
                            || user.getRole().name().equals("SECURITY_ANALYST")) {

                        createIncident(
                                user,
                                scanner,
                                incidentManager
                        );

                    } else {

                        System.out.println(
                                "\nAccess denied. Only ADMIN and "
                                        + "SECURITY_ANALYST can create incidents."
                        );
                    }

                    break;

                case "2":

                    viewAllIncidents(incidentManager);
                    break;

                case "3":

                    searchIncident(
                            scanner,
                            incidentManager
                    );
                    break;

                case "4":

                    if (user.getRole().name().equals("ADMIN")
                            || user.getRole().name().equals("INCIDENT_MANAGER")) {

                        updateIncidentStatus(
                                scanner,
                                incidentManager
                        );

                    } else {

                        System.out.println(
                                "\nAccess denied. Only ADMIN and "
                                        + "INCIDENT_MANAGER can update status."
                        );
                    }

                    break;

                case "5":

                    if (user.getRole().name().equals("ADMIN")
                            || user.getRole().name().equals("INCIDENT_MANAGER")) {

                        updateIncidentSeverity(
                                scanner,
                                incidentManager
                        );

                    } else {

                        System.out.println(
                                "\nAccess denied. Only ADMIN and "
                                        + "INCIDENT_MANAGER can update severity."
                        );
                    }

                    break;

                case "6":
                    insideMenu = false;
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice. Please try again."
                    );
            }
        }
    }

    private static void createIncident(
            User user,
            Scanner scanner,
            IncidentManager incidentManager) {

        System.out.println();
        System.out.println("----------- CREATE INCIDENT -----------");

        System.out.print("Incident title: ");
        String title = scanner.nextLine();

        if (title.trim().isEmpty()) {
            System.out.println("Incident title cannot be empty.");
            return;
        }

        System.out.println();
        System.out.println("Threat Types:");

        ThreatType[] threats = ThreatType.values();

        for (int i = 0; i < threats.length; i++) {
            System.out.println((i + 1) + ". " + threats[i]);
        }

        int threatChoice;

        try {
            System.out.print("Select threat type: ");
            threatChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        if (threatChoice < 1 || threatChoice > threats.length) {
            System.out.println("Invalid threat type.");
            return;
        }

        ThreatType threatType = threats[threatChoice - 1];

        System.out.println();
        System.out.println("Severity:");

        Severity[] severities = Severity.values();

        for (int i = 0; i < severities.length; i++) {
            System.out.println((i + 1) + ". " + severities[i]);
        }

        int severityChoice;

        try {
            System.out.print("Select severity: ");
            severityChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        if (severityChoice < 1 || severityChoice > severities.length) {
            System.out.println("Invalid severity.");
            return;
        }

        Severity severity = severities[severityChoice - 1];

        System.out.println();
        System.out.println("----------- RISK FACTORS -----------");

        int impact = readRiskFactor(
                scanner,
                "Impact"
        );

        int likelihood = readRiskFactor(
                scanner,
                "Likelihood"
        );

        int assetCriticality = readRiskFactor(
                scanner,
                "Asset Criticality"
        );

        int riskScore = RiskAssessment.calculateRiskScore(
                impact,
                likelihood,
                assetCriticality
        );

        String riskClassification =
                RiskAssessment.classifyRisk(riskScore);

        System.out.println();
        System.out.println("Calculated Risk Score: " + riskScore);
        System.out.println("Risk Classification: " + riskClassification);

        Incident incident = incidentManager.createIncident(
                title,
                threatType,
                severity,
                riskScore,
                user.getUsername()
        );

        System.out.println();
        System.out.println("Incident created successfully!");
        System.out.println(incident);
    }

    private static void viewAllIncidents(
            IncidentManager incidentManager) {

        System.out.println();
        System.out.println("----------- ALL INCIDENTS -----------");

        if (incidentManager.getAllIncidents().isEmpty()) {
            System.out.println("No incidents found.");
            return;
        }

        for (Incident incident : incidentManager.getAllIncidents()) {
            System.out.println(incident);
        }
    }

    private static void searchIncident(
            Scanner scanner,
            IncidentManager incidentManager) {

        System.out.print("\nEnter incident ID: ");

        int id = Integer.parseInt(scanner.nextLine());

        Incident incident = incidentManager.findIncidentById(id);

        if (incident == null) {
            System.out.println("Incident not found.");
        } else {
            System.out.println();
            System.out.println("Incident found:");
            System.out.println(incident);
        }
    }

    private static void updateIncidentStatus(
            Scanner scanner,
            IncidentManager incidentManager) {

        System.out.print("\nEnter incident ID: ");

        int id;

        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid incident ID.");
            return;
        }

        Incident incident = incidentManager.findIncidentById(id);

        if (incident == null) {
            System.out.println("Incident not found.");
            return;
        }

        IncidentStatus currentStatus = incident.getStatus();

        System.out.println();
        System.out.println("Current status: " + currentStatus);

        IncidentStatus[] statuses = IncidentStatus.values();

        int currentIndex = currentStatus.ordinal();

        System.out.println();
        System.out.println("Allowed next stages:");

        boolean hasNextStage = false;

        for (int i = currentIndex + 1; i < statuses.length; i++) {
            System.out.println((i - currentIndex) + ". " + statuses[i]);
            hasNextStage = true;
        }

        if (!hasNextStage) {
            System.out.println("Incident is already CLOSED.");
            return;
        }

        System.out.print("\nSelect next stage: ");

        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        int selectedIndex = currentIndex + choice;

        if (choice < 1 || selectedIndex >= statuses.length) {
            System.out.println("Invalid lifecycle stage.");
            return;
        }

        IncidentStatus newStatus = statuses[selectedIndex];

        incidentManager.updateStatus(id, newStatus);

        System.out.println();
        System.out.println("Incident lifecycle updated successfully.");
        System.out.println(
                "Status: " + currentStatus + " -> " + newStatus
        );
    }

    private static void updateIncidentSeverity(
            Scanner scanner,
            IncidentManager incidentManager) {

        System.out.print("\nEnter incident ID: ");

        int id = Integer.parseInt(scanner.nextLine());

        Incident incident = incidentManager.findIncidentById(id);

        if (incident == null) {
            System.out.println("Incident not found.");
            return;
        }

        System.out.println();
        System.out.println("Current severity: " + incident.getSeverity());
        System.out.println();
        System.out.println("Available severities:");

        Severity[] severities = Severity.values();

        for (int i = 0; i < severities.length; i++) {
            System.out.println((i + 1) + ". " + severities[i]);
        }

        System.out.print("Select new severity: ");

        int severityChoice = Integer.parseInt(scanner.nextLine());

        if (severityChoice < 1 || severityChoice > severities.length) {
            System.out.println("Invalid severity.");
            return;
        }

        Severity newSeverity = severities[severityChoice - 1];

        incidentManager.updateSeverity(id, newSeverity);

        System.out.println("Incident severity updated successfully.");
    }
}
