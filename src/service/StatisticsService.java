package service;

public class StatisticsService {

    private int totalTransactions = 0;
    private int fraudCount = 0;
    private int suspiciousCount = 0;
    private int normalCount = 0;

    // update statistics after each transaction
    public void updateStats(String status) {

        totalTransactions++;

        if (status.equals("FRAUD")) {
            fraudCount++;
        }
        else if (status.equals("SUSPICIOUS")) {
            suspiciousCount++;
        }
        else {
            normalCount++;
        }
    }

    // print final statistics
    public void printReport() {

        System.out.println("\n===== FRAUD DETECTION REPORT =====");

        System.out.println("Total Transactions: " + totalTransactions);
        System.out.println("Fraud Transactions: " + fraudCount);
        System.out.println("Suspicious Transactions: " + suspiciousCount);
        System.out.println("Normal Transactions: " + normalCount);
    }
}