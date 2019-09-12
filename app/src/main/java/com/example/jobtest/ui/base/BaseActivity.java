package com.example.jobtest.ui.base;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import com.example.jobtest.R;
import com.example.jobtest.application.JobTestApplication;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressBar mProgressBar;
    private View mProgressContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        hideProgressBar();
        ButterKnife.bind(this);
        initDependencies();
        initApplicationDependencies();
        if (getPresenter() != null) {
            getPresenter().onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideKeyBoard();
    }

    private void hideKeyBoard() {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private void setContentView() {

        View root = getLayoutInflater().inflate(R.layout.activity_base, null);
        setContentView(root);

        View view = getLayoutInflater().inflate(getLayoutResource(), null);
        ViewGroup mContainer = findViewById(R.id.container);
        mProgressBar = findViewById(R.id.progress_bar);
        mProgressContainer = findViewById(R.id.progress_bar_container);
        mContainer.addView(view);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    private void initApplicationDependencies() {

        JobTestApplication.getInstance().mApplicationComponent.inject(this);
    }

    @Override
    public void displayProgressBar() {
        mProgressContainer.bringToFront();
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressContainer.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    protected BasePresenter getPresenter() {
        return null;
    }

    protected abstract void initDependencies();

    protected abstract int getLayoutResource();
}
