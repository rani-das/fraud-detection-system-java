# Fraud Detection System (Java)

A rule-based fraud detection system that analyzes banking transactions
and identifies suspicious or fraudulent activities using transaction patterns.

## Project Overview

This project simulates a banking fraud detection system.

The system processes transaction data and detects potential fraud
based on multiple rules such as:

- Large transaction amounts
- Frequent transactions in a short time
- Unusual transaction time
- Location change anomalies

Each transaction is analyzed and assigned a **risk score** and a **status**:
NORMAL, SUSPICIOUS, or FRAUD.

## System Architecture

Transaction Input (CSV File)
        |
        v
Transaction Processor
        |
        v
Fraud Rule Engine
        |
        v
Risk Score Calculation
        |
        v
Fraud Result (NORMAL / SUSPICIOUS / FRAUD)
        |
        v
Statistics Report

### Main Components

models
- Transaction
- FraudResult

repository
- Stores transaction history

service
- FraudRuleEngine (fraud rules)
- TransactionProcessor (process transactions)
- StatisticsService (tracks statistics)

util
- FileReaderUtil (reads CSV file)

##Fraud Detection Rules

1. Large Transaction Rule
If transaction amount > 50,000 → Risk Score +40

2. High Frequency Rule
If a user performs 5 or more transactions quickly → Risk Score +30

3. Night Transaction Rule
Transactions between 02:00–03:59 → Risk Score +10

4. Location Anomaly Rule
If current transaction location is different from the previous transaction → Risk Score +25

Risk Score Classification

0 – 29   → NORMAL
30 – 59  → SUSPICIOUS
60+      → FRAUD

## How to Run

1. Clone the repository

git clone https://github.com/yourusername/fraud-detection-system-java.git

2. Navigate to the project folder

cd fraud-detection-system-java

3. Compile the project

javac src/Main.java

4. Run the program

java -cp src Main

## Sample Dataset

Transactions are stored in the file:

data/transactions.csv

## Example Output

Transaction 1 RiskScore=0 Status=NORMAL
Transaction 2 RiskScore=40 Status=SUSPICIOUS
Transaction 3 RiskScore=70 Status=FRAUD

===== FRAUD DETECTION REPORT =====
Total Transactions: 7
Fraud Transactions: 1
Suspicious Transactions: 2
Normal Transactions: 4

## Technologies Used

- Java
- Object-Oriented Programming
- HashMap Data Structure
- File Handling
- CSV Data Processing