package com.example.jobtest.ui.flow.posts.presenter;

import com.example.jobtest.di.scope.PerActivity;
import com.example.jobtest.network.NetworkController;
import com.example.jobtest.network.response.DataResponse;
import com.example.jobtest.network.response.Entry;
import com.example.jobtest.ui.flow.posts.contract.PostsContract;
import com.example.jobtest.ui.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

@PerActivity
public class PostsPresenter implements PostsContract.Presenter {

    private List<Entry> mPostsList;

    @Inject
    PostsContract.View mView;

    @Inject
    NetworkController mNetworkController;

    @Inject
    public PostsPresenter() {
    }

    @Override
    public void onStart() {

        mView.displayProgressBar();
        mView.initViews();
        mNetworkController.getLinksList(this::saveLinksData);
    }

    private void saveLinksData(DataResponse dataResponse) {

        mPostsList = new ArrayList<>();

        if (dataResponse != null) {
            mPostsList.addAll(dataResponse.getEntry());
        }
        mNetworkController.getVideoList(this::displayResponseOnList);
    }

    private void displayResponseOnList(DataResponse dataResponse) {

        if (dataResponse != null) {
            mPostsList.addAll(dataResponse.getEntry());
        }

        if (Utils.isListFull(mPostsList)) {

            //mix all like facebook (;
            Collections.shuffle(mPostsList);
            mView.displayData(mPostsList);

        } else {
            mView.showNoDataScreen();
        }
        mView.hideProgressBar();
    }

    @Override
    public void onLinkClicked(String url) {
        mView.navigateToWebPage(url);
    }

    @Override
    public void onPlayVideoClicked(Entry entry) {

    }

    @Override
    public void filterFinish(boolean isFull) {

        if (isFull) {
            mView.showList();
        } else {
            mView.showNoData();
        }
    }
}
