package com.example.jobtest.di.components;

import com.example.jobtest.di.modules.WebModule;
import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.link_screen.view.WebActivity;
import dagger.Component;

@PerActivity
@Component(modules = WebModule.class, dependencies = ApplicationComponent.class)
public interface WebComponent {

    void inject(WebActivity activity);
}
