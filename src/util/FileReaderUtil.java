package util;

import models.Transaction;
import java.io.*;
import java.util.*;

public class FileReaderUtil {

    public static List<Transaction> readTransactions(String filePath) throws Exception {

        List<Transaction> transactions = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            int user = Integer.parseInt(parts[1]);
            double amount = Double.parseDouble(parts[2]);
            String location = parts[3];
            String time = parts[4];

            transactions.add(new Transaction(id, user, amount, location, time));
        }

        reader.close();

        return transactions;
    }
}