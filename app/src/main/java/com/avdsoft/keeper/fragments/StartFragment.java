package com.avdsoft.keeper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.avdsoft.keeper.MainActivity;
import com.avdsoft.keeper.R;

/**
 * Created by AVDSOFT on 05.04.2017;
 * project - 329Keeper;
 */

public class StartFragment extends BaseFragment {
    CalendarView calendarView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calendarView = (CalendarView) view.findViewById(R.id.main_calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                replaceFragment((AppCompatActivity) getActivity(), MainActivity.main_container, new ListFragment());
            }
        });

    }
}
