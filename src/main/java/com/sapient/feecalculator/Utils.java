package com.sapient.feecalculator;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sapient.feecalculator.ConstantValues.TRANSACTIONTYPE;

public class Utils {

    public static Double parseMarketValue(String marketValue) {
        try {
            return Double.parseDouble(marketValue);
        } catch (Exception ignored) {
            return (double) 0;
        }
    }

    public static Boolean getPriority(String priority) {
        if (priority != null) {
            priority = priority.trim();
            return priority.equals("Y") || priority.equals("y");
        } else {
            return false;
        }
    }

    public static Date parseDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date convertedCurrentDate = sdf.parse(date);
            return convertedCurrentDate;
        } catch (Exception ignored) {
            return null;
        }
    }

    public static Integer parseTransactionType(String type) {
        switch (type) {
            case "BUY":
                return TRANSACTIONTYPE.BUY.getType();
            case "SELL":
                return TRANSACTIONTYPE.SELL.getType();
            case "DEPOSIT":
                return TRANSACTIONTYPE.DEPOSIT.getType();
            case "WITHDRAW":
                return TRANSACTIONTYPE.WITHDRAW.getType();
        }
        return null;
    }

    public static String getTypeName(Integer transactionType) {
        if (transactionType == TRANSACTIONTYPE.BUY.getType()) {
            return TRANSACTIONTYPE.BUY.getName() + "\t";
        } else if (transactionType == TRANSACTIONTYPE.SELL.getType()) {
            return TRANSACTIONTYPE.SELL.getName() + "\t";
        } else if (transactionType == TRANSACTIONTYPE.DEPOSIT.getType()) {
            return TRANSACTIONTYPE.DEPOSIT.getName();
        } else if (transactionType == TRANSACTIONTYPE.WITHDRAW.getType()) {
            return TRANSACTIONTYPE.WITHDRAW.getName();
        }
        return null;
    }

    public static TransactionPojo getTransaction(String[] transactionAttributes) {
        TransactionPojo transaction = new TransactionPojo();
        transaction.setExternalTransactionID(transactionAttributes[0]);
        transaction.setClientId(transactionAttributes[1]);
        transaction.setSecurityId(transactionAttributes[2]);
        transaction.setTransactionType(Utils.parseTransactionType(transactionAttributes[3]));
        transaction.setTransactionDate(Utils.parseDate(transactionAttributes[4]));
        transaction.setMarketValue(Utils.parseMarketValue(transactionAttributes[5]));
        transaction.setPriority(Utils.getPriority(transactionAttributes[6]));
        return transaction;
    }
}
