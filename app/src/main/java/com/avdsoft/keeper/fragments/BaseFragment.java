package com.avdsoft.keeper.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by AVDSOFT on 05.04.2017;
 * project - 329Keeper;
 */

public class BaseFragment extends Fragment {

    public void replaceFragment(AppCompatActivity appCompatActivity, View container) {
        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(container.getId(), this).commit();
    }

    public void replaceFragment(AppCompatActivity appCompatActivity, View container, Fragment fragment) {
        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(container.getId(), fragment).commit();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
