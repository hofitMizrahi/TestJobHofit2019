package com.example.jobtest.di.modules;

import com.example.jobtest.ui.flow.posts.contract.PostsContract;
import com.example.jobtest.ui.flow.posts.presenter.PostsPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class PostsModule {

    private PostsContract.View mView;

    public PostsModule(PostsContract.View view) {
        this.mView = view;
    }

    @Provides
    PostsContract.View provideView(){
        return mView;
    }
}
