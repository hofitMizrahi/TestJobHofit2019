package com.example.jobtest.application;

import android.app.Application;
import com.example.jobtest.di.components.ApplicationComponent;
import com.example.jobtest.di.components.DaggerApplicationComponent;
import com.example.jobtest.di.modules.ApplicationModule;

import javax.inject.Inject;

public class JobTestApplication extends Application {

    public ApplicationComponent mApplicationComponent;

    private static JobTestApplication mJobTestApplication;

    public static JobTestApplication getInstance(){
        return mJobTestApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mJobTestApplication = this;
        initDependencies();
    }

    private void initDependencies() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
