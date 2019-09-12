package com.example.jobtest.ui.flow.link_screen.presenter;


import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.link_screen.contract.WebContract;
import javax.inject.Inject;

@PerActivity
public class WebPresenter implements WebContract.Presenter{

    @Inject
    WebContract.View mView;

    @Inject
    public WebPresenter() {

    }

    @Override
    public void onStart() {

        mView.displayProgressBar();
        mView.initViews();
    }
}
