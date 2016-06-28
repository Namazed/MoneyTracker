package com.namazed.moneytracker;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TransactionAdapter extends ArrayAdapter<Transaction> {
    List<Transaction> mTransactions;

    public TransactionAdapter(Context context, List<Transaction> transactions) {
        super(context, 0, transactions);
        mTransactions = transactions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Transaction transaction = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView tvTitle = (TextView) convertView.findViewById(R.id.title);
        TextView tvSum = (TextView) convertView.findViewById(R.id.sum);
        TextView tvDate = (TextView) convertView.findViewById(R.id.date);

        tvTitle.setText(transaction.title);
        tvSum.setText(transaction.sum);
        tvDate.setText(transaction.date);//todo может быть неверно.

        return convertView;
    }
}
