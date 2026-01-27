package com.example.spendsmart;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);

        // Set default fragment to Dashboard
        loadFragment(new DashboardPlaceholder());

        navView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            if (id == R.id.navigation_dashboard) {
                selectedFragment = new DashboardPlaceholder();
            } else if (id == R.id.navigation_add) {
                selectedFragment = new AddExpenseFragment();
            } else if (id == R.id.navigation_insights) {
                selectedFragment = new InsightsPlaceholder();
            }

            return loadFragment(selectedFragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

// Simple Placeholders for the team to replace later
class DashboardPlaceholder extends Fragment {}
class InsightsPlaceholder extends Fragment  {}