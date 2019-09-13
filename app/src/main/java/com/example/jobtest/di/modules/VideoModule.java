package com.example.jobtest.di.modules;

import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.ui.flow.video_screen.contract.VideoContract;
import dagger.Module;
import dagger.Provides;
import static com.example.jobtest.ui.flow.posts.view.PostsActivity.VIDEO_SRC;

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

    @Provides
    @PerActivity
    String provideVideoUrl(){
        return (String) mView.getActivity().getIntent().getSerializableExtra(VIDEO_SRC);
    }
}
