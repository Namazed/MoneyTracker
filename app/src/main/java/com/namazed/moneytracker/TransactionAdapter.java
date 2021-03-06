package com.namazed.moneytracker;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.CardViewHolder> {
    List<Transaction> mTransactions;

    public TransactionAdapter(List<Transaction> transactions) {
        mTransactions = transactions;
    }

    //TransactionAdapter
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Transaction transaction = mTransactions.get(position);
        holder.title.setText(transaction.title);
        holder.sum.setText(transaction.sum);
        holder.date.setText(transaction.date.toString());
    }

    @Override
    public int getItemCount() {
        return mTransactions.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;
        protected TextView sum;
        protected TextView date;

        public CardViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.name);
            sum = (TextView) itemView.findViewById(R.id.sum);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
