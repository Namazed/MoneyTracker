package com.namazed.moneytracker;


import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.activeandroid.query.Select;
import com.melnykov.fab.FloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.fragment_transactions)
public class TransactionsFragment extends Fragment {

    @ViewById(R.id.transactions_list)
    RecyclerView mRecyclerView;

    @ViewById(R.id.fab)
    FloatingActionButton mFab;

    @AfterViews
    void readyApp() {
        mRecyclerView.setHasFixedSize(true); //Только для телефонов, фиксированный размер.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //Сохраняем в менеджере вертикальную ориентацию
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //присвоили view ориентацию, с помощью manager
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mFab.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Transaction>>() {
            @Override
            public Loader<List<Transaction>> onCreateLoader(int i, Bundle bundle) {
                final AsyncTaskLoader<List<Transaction>> transactionsLoader =
                        new AsyncTaskLoader<List<Transaction>>(getActivity()) {
                            @Override
                            public List<Transaction> loadInBackground() {
                                return getDataList();
                            }
                        };
                transactionsLoader.forceLoad();
                return transactionsLoader;
            }

            @Override
            public void onLoadFinished(Loader<List<Transaction>> loader, List<Transaction> transactions) {
                mRecyclerView.setAdapter(new TransactionAdapter(transactions));
            }

            @Override
            public void onLoaderReset(Loader<List<Transaction>> loader) {
            }
        });
    }

    @Click
    void fabClicked() {
        AddTransactionActivity_.intent(getActivity()).start();
    }

    private List<Transaction> getDataList() {
        return new Select().from(Transaction.class).orderBy("date DESC").execute();
    }
}
