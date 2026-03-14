package models;

public class FraudResult {

    private int riskScore;
    private String status;

    public FraudResult(int riskScore, String status) {
        this.riskScore = riskScore;
        this.status = status;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getStatus() {
        return status;
    }
}