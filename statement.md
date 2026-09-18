# CyberShield - Project Statement

## Problem Statement

Cybersecurity incidents need to be recorded, assessed, investigated, and tracked systematically. Without a structured incident management process, important information such as threat type, severity, risk level, investigation status, and resolution progress can become difficult to manage.

CyberShield provides a command-line Java application for organizing cybersecurity incident information and managing the incident lifecycle.

## Scope

The scope of CyberShield includes:

- User authentication
- Role-based access control
- Cybersecurity incident creation
- Incident searching and viewing
- Threat classification
- Severity classification
- Risk assessment
- Incident lifecycle management
- Security reports and analytics
- CSV-based data persistence
- Input validation and error handling

The project is implemented as a Java command-line application using core Java concepts and does not require an external database or third-party libraries.

## Target Users

CyberShield is designed for:

- System administrators
- Security analysts
- Incident managers
- Security monitoring personnel
- Users requiring read-only access to incident information

## High-Level Features

### 1. Authentication

Users authenticate using a username and password before accessing the system.

### 2. Role-Based Access Control

The application supports:

- ADMIN
- SECURITY_ANALYST
- INCIDENT_MANAGER
- VIEWER

Different roles receive different permissions.

### 3. Incident Management

The system allows authorized users to:

- Create incidents
- View incidents
- Search incidents by ID
- Update incident severity
- Track incident information

### 4. Threat & Risk Assessment

Incidents can be categorized using predefined threat types.

Risk is calculated using:

**Risk Score = Impact × Likelihood × Asset Criticality**

Each factor is evaluated from 1 to 5.

### 5. Incident Lifecycle

Incidents progress through:

**REPORTED → TRIAGED → INVESTIGATING → CONTAINED → RESOLVED → CLOSED**

The application restricts invalid lifecycle progression.

### 6. Security Reports

The system generates summaries containing:

- Total incidents
- Average risk score
- Severity distribution
- Status distribution
- Threat distribution
- Individual incident summaries

### 7. Data Persistence

Incident information is stored in a CSV file so that records remain available after the application is restarted.

## Expected Outcome

The expected outcome is a modular Java application that demonstrates the practical use of Programming in Java concepts while providing a structured workflow for cybersecurity incident management.

The project demonstrates authentication, object-oriented design, collections, enums, file handling, validation, exception handling, role-based permissions, risk calculation, lifecycle management, and reporting.