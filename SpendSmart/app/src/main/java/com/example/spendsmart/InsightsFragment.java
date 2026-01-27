package com.example.spendsmart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spendsmart.R;

/**
 * InsightsFragment: Handles the financial reports and charts.
 * To be implemented by Emmanuel Mwangangi.
 */
public class InsightsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // This links the Java class to fragment_insights.xml
        return inflater.inflate(R.layout.fragment_insights, container, false);
    }
}