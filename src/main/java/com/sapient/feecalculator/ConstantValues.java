package com.sapient.feecalculator;

public class ConstantValues {
    public enum FILETYPE {
        CSV(1), XML(2), TEXT(3);
        int type;

        FILETYPE(int type) {
            this.type = type;
        }
    }

    public enum TRANSACTIONFEE {
        FIVE_HUNDRED(500), HUNDRED(100), FIFTY(50), TEN(10);
        private double fees;

        TRANSACTIONFEE(double fees) {
            this.fees = fees;
        }

        public double getFees() {
            return fees;
        }
    }

    public enum TRANSACTIONTYPE {
        BUY("BUY", 1), SELL("SELL", 2), DEPOSIT("DEPOSIT", 3), WITHDRAW("WITHDRAW", 4);
        private int type;
        private String name;

        TRANSACTIONTYPE(String name, int type) {
            this.name = name;
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }

}
