package com.namazed.moneytracker;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TransactionAdapter mTransactionAdapter;
    List<Transaction> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);

        List<Transaction> adapterData = getDataList();
        mTransactionAdapter = new TransactionAdapter(adapterData);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.transactions_list);
        //FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        //mRecyclerView.setHasFixedSize(true); //Только для телефонов, фиксированный размер.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //Сохраняем в менеджере вертикальную ориентацию
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //присвоили view ориентацию, с помощью manager
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mTransactionAdapter);
        //fab.attachToRecyclerView(mRecyclerView);
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
