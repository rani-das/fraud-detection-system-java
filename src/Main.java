import models.Transaction;
import models.FraudResult;
import service.TransactionProcessor;
import service.StatisticsService;
import util.FileReaderUtil;


import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Transaction> transactions =
                FileReaderUtil.readTransactions("data/transactions.csv");

        TransactionProcessor processor = new TransactionProcessor();
        StatisticsService stats = new StatisticsService();
        for (Transaction t : transactions) {

            FraudResult result = processor.process(t);

            System.out.println(
                    "Transaction " + t.getTransactionId() +
                    " RiskScore=" + result.getRiskScore() +
                    " Status=" + result.getStatus()
            );
            stats.updateStats(result.getStatus());
        }
        stats.printReport();
    }
}