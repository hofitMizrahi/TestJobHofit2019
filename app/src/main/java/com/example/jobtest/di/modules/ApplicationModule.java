package com.example.jobtest.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.jobtest.di.qualifire.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideApplicationContext(){
        return mApplication;
    }
}
