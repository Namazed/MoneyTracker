package com.namazed.moneytracker;


public class Transaction {
    public String name;
    public String sum;
    public String date;

    public Transaction(String name, int sum, String date) {
        this.name = name;
        this.sum = Integer.toString(sum);
        this.date = date;
    }
}
