package com.example.jobtest.ui.flow.link_screen.presenter;


import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.video_screen.contract.VideoContract;

import javax.inject.Inject;

@PerActivity
public class WebPresenter implements VideoContract.Presenter{

    @Inject
    public WebPresenter() {
    }

    @Override
    public void onStart() {

    }
}
