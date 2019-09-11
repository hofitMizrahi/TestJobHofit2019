package com.example.jobtest.di.components;

import android.content.Context;

import com.example.jobtest.di.modules.ApplicationModule;
import com.example.jobtest.di.modules.NetworkModule;
import com.example.jobtest.di.qualifire.ApplicationContext;
import com.example.jobtest.di.scope.PerApplication;
import com.example.jobtest.network.NetworkController;
import com.example.jobtest.ui.base.BaseActivity;
import dagger.Component;

@PerApplication
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    NetworkController networkController();

    void inject (BaseActivity activity);

    @ApplicationContext
    Context provideAppContext();
}
