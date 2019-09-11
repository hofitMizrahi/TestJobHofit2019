package com.example.jobtest.di.modules;

import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.link_screen.contract.WebContract;

import dagger.Module;
import dagger.Provides;

@Module
public class WebModule {

    private WebContract.View mView;

    public WebModule(WebContract.View view) {
        this.mView = view;
    }

    @Provides
    @PerActivity
    WebContract.View provideView(){
        return mView;
    }
}
