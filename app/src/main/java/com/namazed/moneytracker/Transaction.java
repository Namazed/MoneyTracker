package com.namazed.moneytracker;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "Transactions")
public class Transaction extends Model {
    @Column(name = "Title")
    public String title;
    @Column(name = "Sum")
    public String sum;
    @Column(name = "Date")
    public Date date;

    /**
     * This is required by active android
     */
    public Transaction() {
    }

    public Transaction(String title, String sum) {
        this.title = title;
        this.sum = sum;
        date = new Date();
    }
}
