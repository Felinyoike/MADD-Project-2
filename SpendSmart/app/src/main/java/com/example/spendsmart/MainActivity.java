package com.example.spendsmart;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * MainActivity serves as the entry point and navigation host for SpendSmart.
 * It manages the BottomNavigationView and handles fragment transactions.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize the Bottom Navigation Bar
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);

        // 2. Load the Dashboard as the default landing page on startup
        if (savedInstanceState == null) {
            loadFragment(new DashboardFragment());
        }

        // 3. Set up the Selection Listener to switch between fragments
        navView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            // Match the Menu Item ID (from bottom_nav_menu.xml) to the Fragment class
            if (id == R.id.navigation_dashboard) {
                selectedFragment = new DashboardFragment();
            } else if (id == R.id.navigation_add) {
                selectedFragment = new AddExpenseFragment();
            } else if (id == R.id.navigation_insights) {
                selectedFragment = new InsightsFragment();
            }

            return loadFragment(selectedFragment);
        });
    }

    /**
     * Helper method to perform Fragment Transactions.
     * Replaces the current fragment in the container with a new one.
     */
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .setReorderingAllowed(true)
                    .commit();
            return true;
        }
        return false;
    }
}