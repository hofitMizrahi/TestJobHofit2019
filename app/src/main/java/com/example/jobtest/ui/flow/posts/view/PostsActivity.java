package com.example.jobtest.ui.flow.posts.view;

import android.os.Bundle;
import com.example.jobtest.R;
import com.example.jobtest.application.JobTestApplication;
import com.example.jobtest.di.components.DaggerPostsComponent;
import com.example.jobtest.di.modules.PostsModule;
import com.example.jobtest.network.NetworkController;
import com.example.jobtest.ui.base.BaseActivity;
import com.example.jobtest.ui.base.BasePresenter;
import com.example.jobtest.ui.flow.posts.contract.PostsContract;
import com.example.jobtest.ui.flow.posts.presenter.PostsPresenter;
import javax.inject.Inject;

public class PostsActivity extends BaseActivity implements PostsContract.View {

    @Inject
    PostsPresenter mPresenter;

    @Inject
    NetworkController mNetworkController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initDependencies() {
        DaggerPostsComponent.builder()
                .postsModule(new PostsModule(this))
                .applicationComponent(JobTestApplication.getInstance().getComponent())
                .build();
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_posts_list;
    }

    @Override
    public void displayData() {

    }

    @Override
    public void initViews() {

    }
}
