package com.example.jobtest.ui.flow.video_screen.presenter;

import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.video_screen.contract.VideoContract;

import javax.inject.Inject;

@PerActivity
public class VideoPresenter implements VideoContract.Presenter{

    @Inject
    VideoContract.View mView;

    @Inject
    public VideoPresenter() {
    }

    @Override
    public void onStart() {

        mView.displayProgressBar();
        mView.initViews();
    }
}
