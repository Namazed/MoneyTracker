package com.namazed.moneytracker;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionsFragment extends Fragment {

    private ListView mListView;
    private TransactionAdapter mTransactionAdapter;
    List<Transaction> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        List<Transaction> adapterData = getDataList();
        mTransactionAdapter = new TransactionAdapter(getActivity(), adapterData);

        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setAdapter(mTransactionAdapter);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private List<Transaction> getDataList() {
        data.add(new Transaction("Tel", 2000, new Date().toString()));
        data.add(new Transaction("T-Shirts", 1000, new Date().toString()));
        data.add(new Transaction("Jeans", 3000, new Date().toString()));

        return data;
    }
}
