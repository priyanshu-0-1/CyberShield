import com.cybershield.RiskAssessment;
import com.cybershield.Incident;
import com.cybershield.enums.*;

public class CyberShieldTest {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       CYBERSHIELD TEST SUITE");
        System.out.println("========================================");

        testRiskCalculation();
        testRiskClassification();
        testInvalidRiskValues();
        testIncidentCreation();

        System.out.println();
        System.out.println("========================================");
        System.out.println("       ALL TESTS COMPLETED");
        System.out.println("========================================");
    }

    private static void testRiskCalculation() {

        int score = RiskAssessment.calculateRiskScore(3, 4, 5);

        if (score == 60) {
            System.out.println("[PASS] Risk calculation");
        } else {
            System.out.println("[FAIL] Risk calculation");
        }
    }

    private static void testRiskClassification() {

        if (RiskAssessment.classifyRisk(10).equals("LOW")
                && RiskAssessment.classifyRisk(30).equals("MEDIUM")
                && RiskAssessment.classifyRisk(60).equals("HIGH")
                && RiskAssessment.classifyRisk(100).equals("CRITICAL")) {

            System.out.println("[PASS] Risk classification");

        } else {

            System.out.println("[FAIL] Risk classification");
        }
    }

    private static void testInvalidRiskValues() {

        int score = RiskAssessment.calculateRiskScore(0, 4, 5);

        if (score == -1) {
            System.out.println("[PASS] Invalid risk input validation");
        } else {
            System.out.println("[FAIL] Invalid risk input validation");
        }
    }

    private static void testIncidentCreation() {

        Incident incident = new Incident(
                1,
                "Test phishing incident",
                ThreatType.PHISHING,
                Severity.HIGH,
                IncidentStatus.REPORTED,
                60,
                "analyst"
        );

        if (incident.getId() == 1
                && incident.getThreatType() == ThreatType.PHISHING
                && incident.getSeverity() == Severity.HIGH
                && incident.getStatus() == IncidentStatus.REPORTED
                && incident.getRiskScore() == 60) {

            System.out.println("[PASS] Incident object creation");

        } else {

            System.out.println("[FAIL] Incident object creation");
        }
    }
}
