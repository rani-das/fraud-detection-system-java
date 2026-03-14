package models;

public class Transaction {

    private int transactionId;
    private int userId;
    private double amount;
    private String location;
    private String time;

    public Transaction(int transactionId, int userId, double amount, String location, String time) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.location = location;
        this.time = time;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }
}