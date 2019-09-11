package com.example.jobtest.di.components;

import com.example.jobtest.di.modules.PostsModule;
import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.posts.view.PostsActivity;
import dagger.Component;

@PerActivity
@Component(modules = PostsModule.class, dependencies = ApplicationComponent.class)
public interface PostsComponent {

    void inject(PostsActivity activity);
}
