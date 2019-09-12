package com.example.jobtest.di.components;

import com.example.jobtest.di.modules.VideoModule;
import com.example.jobtest.di.modules.WebModule;
import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.video_screen.view.VideoActivity;
import dagger.Component;

@PerActivity
@Component(modules = VideoModule.class, dependencies = ApplicationComponent.class)
public interface VideoComponent {

    void inject(VideoActivity activity);
}
