package com.namazed.moneytracker;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initNavigationView();
        if (savedInstanceState == null) {
            setFragment(new TransactionsFragment());
            mToolbar.setTitle("Траты");
        }
    }

    private void initToolbar() {
        /*
        * Инициализация Toolbar.
         */
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        //visible button navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initNavigationView() {
        /*
        * Инициализация NavigationView. Обработка нажатий на MenuItem NavigationView.
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer
        ) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                mDrawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.action_waste:
                        menuItem.setChecked(true);
                        setFragment(new TransactionsFragment());
                        mToolbar.setTitle(getString(R.string.nav_menu_waste));
                        return true;
                    case R.id.action_categories:
                        menuItem.setChecked(true);
                        setFragment(new CategoriesFragment());
                        mToolbar.setTitle(getString(R.string.nav_menu_categories));
                        return true;
                    case R.id.action_statistic:
                        menuItem.setChecked(true);
                        setFragment(new StatisticFragment());
                        mToolbar.setTitle(getString(R.string.nav_menu_statistic));
                        return true;
                    default:
                        return true;
                }

            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

//    @Override
//    public void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        drawerToggle.syncState();
//    }
}
