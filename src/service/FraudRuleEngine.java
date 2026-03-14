package service;

import models.Transaction;
import models.FraudResult;
import java.util.List;

public class FraudRuleEngine {

    public FraudResult evaluate(Transaction transaction, List<Transaction> history) {

        int riskScore = 0;

        // Rule 1: Large transaction
        if (transaction.getAmount() > 50000) {
            riskScore += 40;
        }

        // Rule 2: Many transactions quickly
        if (history.size() == 4) {
            riskScore += 30;
        }

        // Rule 3: Night transaction
        if (transaction.getTime().startsWith("02") || transaction.getTime().startsWith("03")) {
            riskScore += 10;
        }
        // Rule 4: Location anomaly detection
        if (!history.isEmpty()) {

            Transaction lastTransaction = history.get(history.size() - 1);

            String previousLocation = lastTransaction.getLocation();
            String currentLocation = transaction.getLocation();

            if (!previousLocation.equals(currentLocation)) {

                riskScore += 25;

                System.out.println(
                        "Location anomaly detected: "
                        + previousLocation + " -> " + currentLocation
                );
            }
        }
        String status;

        if (riskScore >= 50) {
            status = "FRAUD";
        } else if (riskScore >= 10) {
            status = "SUSPICIOUS";
        } else {
            status = "NORMAL";
        }

        return new FraudResult(riskScore, status);
    }
}