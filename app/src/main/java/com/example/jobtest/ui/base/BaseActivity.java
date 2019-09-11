package com.example.jobtest.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        initDependencies();

        if(getPresenter() != null){
            getPresenter().onStart();
        }
    }

    protected BasePresenter getPresenter() {
        return null;
    }

    protected abstract void initDependencies();

    protected abstract int getLayoutResource();
}
