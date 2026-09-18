# CyberShield - Cybersecurity Incident Management System

## Project Overview

CyberShield is a Java-based command-line Cybersecurity Incident Management System designed to help organizations record, assess, investigate, track, and analyze cybersecurity incidents.

The system demonstrates core Java programming concepts including Object-Oriented Programming, classes and objects, enums, collections, file handling, exception handling, input validation, modular design, and role-based access control.

## Problem Statement

Cybersecurity incidents need to be properly recorded and tracked from the time they are reported until they are resolved and closed.

CyberShield provides a structured system for managing incidents, assigning threat types and severity levels, calculating risk, tracking incident lifecycle stages, and generating security reports.

## Objectives

- Provide user authentication.
- Support multiple user roles.
- Create and manage cybersecurity incidents.
- Classify incidents according to threat type and severity.
- Calculate risk using defined risk factors.
- Track incidents through a structured lifecycle.
- Persist incident information using CSV files.
- Generate security reports and analytics.
- Validate user input and handle invalid entries.

## Main Features

### 1. Authentication & User Management

The system supports four roles:

- ADMIN
- SECURITY_ANALYST
- INCIDENT_MANAGER
- VIEWER

Users must authenticate before accessing the system dashboard.

### 2. Incident Management

Users with appropriate permissions can:

- Create incidents
- View all incidents
- Search incidents by ID
- Update incident severity
- Update incident status
- Track incident information

### 3. Threat & Risk Assessment

Supported threat types include:

- PHISHING
- MALWARE
- UNAUTHORIZED_ACCESS
- DATA_BREACH
- DOS_ATTACK
- INSIDER_THREAT
- SUSPICIOUS_ACTIVITY

Risk is calculated using:

**Risk Score = Impact × Likelihood × Asset Criticality**

Each factor has a value from 1 to 5.

Risk classification used by this project:

- 1-20: LOW
- 21-50: MEDIUM
- 51-80: HIGH
- 81-125: CRITICAL

### 4. Investigation & Incident Lifecycle

Incidents follow the lifecycle:

**REPORTED → TRIAGED → INVESTIGATING → CONTAINED → RESOLVED → CLOSED**

The system prevents invalid lifecycle progression.

### 5. Security Reports & Analytics

The report module provides:

- Total number of incidents
- Average risk score
- Severity distribution
- Status distribution
- Threat distribution
- Incident summaries

## Technologies Used

- Java
- Object-Oriented Programming
- Java Collections Framework
- Java Enums
- Java File I/O
- CSV File Storage
- Exception Handling
- Command-Line Interface
- Git and GitHub

## Project Structure

```text
CyberShield/
├── README.md
├── statement.md
├── src/
│   └── com/
│       └── cybershield/
│           ├── Main.java
│           ├── User.java
│           ├── Incident.java
│           ├── AuthService.java
│           ├── UserManager.java
│           ├── IncidentManager.java
│           ├── RiskAssessment.java
│           ├── ReportGenerator.java
│           ├── FileStorage.java
│           ├── InputValidator.java
│           └── enums/
│               ├── Role.java
│               ├── Severity.java
│               ├── ThreatType.java
│               └── IncidentStatus.java
├── data/
│   └── incidents.csv
├── tests/
│   └── CyberShieldTest.java
└── docs/
    ├── diagrams/
    └── screenshots/