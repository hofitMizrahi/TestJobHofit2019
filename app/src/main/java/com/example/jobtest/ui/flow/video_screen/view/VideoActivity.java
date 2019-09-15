package com.example.jobtest.ui.flow.video_screen.view;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jobtest.R;
import com.example.jobtest.application.JobTestApplication;
import com.example.jobtest.di.components.DaggerVideoComponent;
import com.example.jobtest.di.modules.VideoModule;
import com.example.jobtest.ui.base.BaseActivity;
import com.example.jobtest.ui.base.BasePresenter;
import com.example.jobtest.ui.flow.video_screen.contract.VideoContract;
import com.example.jobtest.ui.flow.video_screen.presenter.VideoPresenter;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;

public class VideoActivity extends BaseActivity implements VideoContract.View, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener {

    public final String VIDEO_STATE = "video_state";

    private int mVideoCurrentPosition;

    @Inject
    String videoUrl;

    @Inject
    VideoPresenter mPresenter;

    @BindView(R.id.video_view)
    VideoView mVideoView;

    @Nullable
    @BindView(R.id.rotate_image)
    ImageView mImage;

    @Override
    protected void initDependencies() {
        DaggerVideoComponent.builder().applicationComponent(JobTestApplication.getInstance().getComponent())
                .videoModule(new VideoModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (savedInstanceState != null) {

            mVideoCurrentPosition = savedInstanceState.getInt(VIDEO_STATE);
        }
        super.onCreate(savedInstanceState);
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
        mVideoView.setOnPreparedListener(this);
        mVideoView.requestFocus();
        mVideoView.start();

        if(mImage != null) {
            rotateAnimation();
        }

    }

    private void rotateAnimation() {

        RotateAnimation rotate = new RotateAnimation(0, 90,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);

        rotate.setDuration(4000);
        rotate.setRepeatCount(Animation.INFINITE);
        mImage.setAnimation(rotate);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(VIDEO_STATE, mVideoCurrentPosition);

        super.onSaveInstanceState(bundle);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoCurrentPosition = mVideoView.getCurrentPosition();
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

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mVideoView.seekTo(mVideoCurrentPosition);
        mVideoView.start();
    }
}
