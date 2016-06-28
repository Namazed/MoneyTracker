package com.namazed.moneytracker;


public class Transaction {
    public String title;
    public String sum;
    public String date;

    public Transaction(String title, int sum, String date) {
        this.title = title;
        this.sum = Integer.toString(sum);
        this.date = date;
    }
}
