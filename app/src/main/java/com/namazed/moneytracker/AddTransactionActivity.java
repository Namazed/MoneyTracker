package com.namazed.moneytracker;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_add_transaction)
public class AddTransactionActivity extends AppCompatActivity {

    @ViewById(R.id.toolbar)
    Toolbar mToolbar;

    @ViewById
    EditText sum, title;

    @AfterViews
    void readyApp() {
        setSupportActionBar(mToolbar);
        setTitle(getString(R.string.add_transaction));
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Click
    void addTransaction() {
        //todo реализовать проверку на правильный ввод данных в edit text
        new Transaction(title.getText().toString(), sum.getText().toString()).save();
        finish();
    }

    @OptionsItem
    void homeSelected() {
        onBackPressed();
    }
}
