package com.sapient.feecalculator;

import com.sapient.feecalculator.ConstantValues;
import com.sapient.feecalculator.TransactionPojo;
import com.sapient.feecalculator.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TransactionFeeCalculator {

    private List<TransactionPojo> transactionList = new ArrayList<>();

    public void addTransaction(TransactionPojo transaction) {
        transactionList.add(calculateFee(transaction));
    }

    public void addTransaction(List<TransactionPojo> transactions) {
        transactions.forEach(this::addTransaction);
    }

    private TransactionPojo calculateFee(TransactionPojo transaction) {
        if (isIntradayTransaction(transaction)) {
            transaction.setTransactionFees(ConstantValues.TRANSACTIONFEE.TEN.getFees());
        } else {
            if (transaction.getPriority()) {
                transaction.setTransactionFees(ConstantValues.TRANSACTIONFEE.FIVE_HUNDRED.getFees());
            } else {
                if (transaction.getTransactionType() == ConstantValues.TRANSACTIONTYPE.SELL.getType() ||
                        transaction.getTransactionType() == ConstantValues.TRANSACTIONTYPE.WITHDRAW.getType()) {
                    transaction.setTransactionFees(ConstantValues.TRANSACTIONFEE.HUNDRED.getFees());
                } else if (transaction.getTransactionType() == ConstantValues.TRANSACTIONTYPE.BUY.getType() ||
                        transaction.getTransactionType() == ConstantValues.TRANSACTIONTYPE.DEPOSIT.getType()) {
                    transaction.setTransactionFees(ConstantValues.TRANSACTIONFEE.FIFTY.getFees());
                }
            }
        }
        return transaction;
    }

    private boolean isIntradayTransaction(TransactionPojo other) {
        boolean isIntraDayTransaction = false;
        if (transactionList.size() > 0) {
            for (TransactionPojo transaction : transactionList) {
                if (transaction.getClientId().equals(other.getClientId()) &&
                        transaction.getSecurityId().equals(other.getSecurityId()) &&
                        transaction.getTransactionDate().equals(other.getTransactionDate())) {
                    if ((transaction.getTransactionType() == ConstantValues.TRANSACTIONTYPE.BUY.getType() &&
                            other.getTransactionType() == ConstantValues.TRANSACTIONTYPE.SELL.getType()) ||
                            (transaction.getTransactionType() == ConstantValues.TRANSACTIONTYPE.SELL.getType() &&
                                    other.getTransactionType() == ConstantValues.TRANSACTIONTYPE.BUY.getType())) {
                        isIntraDayTransaction = true;
                        transaction.setTransactionFees(ConstantValues.TRANSACTIONFEE.TEN.getFees());
                        break;
                    }
                }
            }
        }
        return isIntraDayTransaction;
    }

    public void displayTransactionReport() {
        transactionList.sort(Comparator.comparing(TransactionPojo::getClientId)
                .thenComparing(TransactionPojo::getTransactionType)
                .thenComparing(TransactionPojo::getTransactionDate)
                .thenComparing(TransactionPojo::getPriority));
        System.out.println("Calculated Fee for the given transaction are as below:-");
        System.out.println("Client Id | Transaction Type | Transaction Date | Priority | Processing Fee    |");
        for (TransactionPojo transaction : transactionList) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println(transaction.getClientId() + "\t| " + Utils.getTypeName(transaction.getTransactionType()) + "\t| " +
            		stringDate(transaction.getTransactionDate()) + "\t| " + (transaction.getPriority() ? "Y\t" : "N\t") + "\t| " +
            		String.format("%.0f", transaction.getTransactionFees())+ "\t|");
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
    
    private static String stringDate(Date date)
    { 
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");  
    	String strDate = dateFormat.format(date);  
    	return strDate;
    }
}
