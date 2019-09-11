package com.example.jobtest.di.modules;

import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.video_screen.contract.VideoContract;

import dagger.Module;
import dagger.Provides;

@Module
public class VideoModule {

    private VideoContract.View mView;

    public VideoModule(VideoContract.View view) {
        this.mView = view;
    }

    @Provides
    @PerActivity
    VideoContract.View provideView(){
        return mView;
    }
}
