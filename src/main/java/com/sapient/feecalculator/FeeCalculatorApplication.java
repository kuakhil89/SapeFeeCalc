package com.sapient.feecalculator;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.feecalculator.ConstantValues.FILETYPE;

@SpringBootApplication		
public class FeeCalculatorApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FeeCalculatorApplication.class, args);
		List<TransactionPojo> transactions = ReadTransaction.readFile(FILETYPE.TEXT, "inputData.txt");
        TransactionFeeCalculator calculator = new TransactionFeeCalculator();
        calculator.addTransaction(transactions);
        calculator.displayTransactionReport();
	}

}
