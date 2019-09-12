package com.example.jobtest.ui.base;

import android.app.Activity;

public interface BaseView {

    Activity getActivity();

    void displayProgressBar();

    void hideProgressBar();
}
