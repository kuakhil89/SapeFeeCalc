package com.sapient.feecalculator;

import com.sapient.feecalculator.ConstantValues.FILETYPE;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface ReadTransaction {

    List<TransactionPojo> read(String filesPath) throws IOException;

    static List<TransactionPojo> readFile(FILETYPE fileType, String filesPath) throws IOException {
        switch (fileType) {
            case TEXT:
                return textTrxReader().read(filesPath);
            case CSV:
                return csvTrxReader().read(filesPath);
            case XML:
                return xmlTrxReader().read(filesPath);

            default:
                return null;
        }
    }

    static ReadTransaction textTrxReader() {
        return transactionFile -> {
            List<TransactionPojo> list = new ArrayList<>();
            String line = "";
            String cvsFileSplitBy = ",";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(ReadTransaction.class.getClassLoader().getResourceAsStream(transactionFile)));) {
            	//reading file line by line
                while ((line = br.readLine()) != null) {
                    String[] transactionAttributes = line.split(cvsFileSplitBy);
                    TransactionPojo transaction = Utils.getTransaction(transactionAttributes);
                    list.add(transaction);
                }
                return list;
            }
        };
    }
    static ReadTransaction xmlTrxReader() {
        throw new RuntimeException("future implementation required");
    }

    static ReadTransaction csvTrxReader() {
        throw new RuntimeException("future implementation required");
    }
}
