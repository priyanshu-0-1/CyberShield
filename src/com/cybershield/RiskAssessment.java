package com.cybershield;

public class RiskAssessment {

    public static int calculateRiskScore(
            int impact,
            int likelihood,
            int assetCriticality) {

        if (!isValidFactor(impact)
                || !isValidFactor(likelihood)
                || !isValidFactor(assetCriticality)) {

            return -1;
        }

        return impact * likelihood * assetCriticality;
    }

    public static String classifyRisk(int riskScore) {

        if (riskScore < 1 || riskScore > 125) {
            return "INVALID";
        }

        if (riskScore <= 20) {
            return "LOW";
        }

        if (riskScore <= 50) {
            return "MEDIUM";
        }

        if (riskScore <= 80) {
            return "HIGH";
        }

        return "CRITICAL";
    }

    private static boolean isValidFactor(int value) {
        return value >= 1 && value <= 5;
    }

    public static void displayRiskAssessment(
            int impact,
            int likelihood,
            int assetCriticality) {

        int score = calculateRiskScore(
                impact,
                likelihood,
                assetCriticality
        );

        if (score == -1) {
            System.out.println(
                    "Invalid values. Each factor must be between 1 and 5."
            );
            return;
        }

        System.out.println();
        System.out.println("----------- RISK ASSESSMENT -----------");
        System.out.println("Impact: " + impact);
        System.out.println("Likelihood: " + likelihood);
        System.out.println("Asset Criticality: " + assetCriticality);
        System.out.println("Risk Score: " + score);
        System.out.println("Risk Classification: " + classifyRisk(score));
    }
}
