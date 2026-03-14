package service;

import models.Transaction;
import models.FraudResult;
import repository.TransactionRepository;
import java.util.List;

public class TransactionProcessor {

    private TransactionRepository repository = new TransactionRepository();
    private FraudRuleEngine engine = new FraudRuleEngine();
    public FraudResult process(Transaction transaction) {

        List<Transaction> history = repository.getUserTransactions(transaction.getUserId());

        FraudResult result = engine.evaluate(transaction, history);

        repository.addTransaction(transaction);
        if(result.getStatus().equals("FRAUD")){
        System.out.println("ALERT: Fraud detected for user " + transaction.getUserId());
     }

        return result;
    }
}