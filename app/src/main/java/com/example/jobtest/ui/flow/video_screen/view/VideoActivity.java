package com.example.jobtest.ui.flow.video_screen.view;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.jobtest.R;
import com.example.jobtest.application.JobTestApplication;
import com.example.jobtest.di.components.DaggerVideoComponent;
import com.example.jobtest.di.modules.VideoModule;
import com.example.jobtest.ui.base.BaseActivity;
import com.example.jobtest.ui.base.BasePresenter;
import com.example.jobtest.ui.flow.video_screen.contract.VideoContract;
import com.example.jobtest.ui.flow.video_screen.presenter.VideoPresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class VideoActivity extends BaseActivity implements VideoContract.View, MediaPlayer.OnInfoListener {

    @Inject
    String videoUrl;

    @Inject
    VideoPresenter mPresenter;

    @BindView(R.id.video_view)
    VideoView mVideoView;

    @Override
    protected void initDependencies() {
        DaggerVideoComponent.builder().applicationComponent(JobTestApplication.getInstance().getComponent())
                .videoModule(new VideoModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getSupportActionBar().hide();
        } catch (NullPointerException ee) {
            ee.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_play_video;
    }

    @Override
    public void initViews() {

        mVideoView.setMediaController(new MediaController(this));
        mVideoView.setVideoURI(Uri.parse(videoUrl));
        mVideoView.setOnInfoListener(this);
        mVideoView.start();
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public boolean onInfo(MediaPlayer mediaPlayer, int info, int i) {

        if (info == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {

            hideProgressBar();
            return true;
        }
        return false;
    }
}
