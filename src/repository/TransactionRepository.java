package repository;

import models.Transaction;
import java.util.*;

public class TransactionRepository {

    private Map<Integer, List<Transaction>> transactionHistory = new HashMap<>();

    public void addTransaction(Transaction transaction) {

        int userId = transaction.getUserId();

        transactionHistory
                .computeIfAbsent(userId, k -> new ArrayList<>())
                .add(transaction);
    }

    public List<Transaction> getUserTransactions(int userId) {
        return transactionHistory.getOrDefault(userId, new ArrayList<>());
    }
}