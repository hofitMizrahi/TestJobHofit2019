package com.example.jobtest.ui.flow.posts.presenter;

import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.network.NetworkController;
import com.example.jobtest.network.response.LinksResponse;
import com.example.jobtest.ui.flow.posts.contract.PostsContract;

import javax.inject.Inject;

@PerActivity
public class PostsPresenter implements PostsContract.Presenter{

    @Inject
    PostsContract.View mView;

    @Inject
    NetworkController mNetworkController;

    @Inject
    public PostsPresenter() {
    }

    @Override
    public void onStart() {

        mNetworkController.getLinksList(this::videoResponse);
    }

    private void videoResponse(LinksResponse linksResponse) {

        if(linksResponse != null){
        }
    }
}
