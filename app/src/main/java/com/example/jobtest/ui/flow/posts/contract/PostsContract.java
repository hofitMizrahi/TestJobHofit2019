package com.example.jobtest.ui.flow.posts.contract;

import com.example.jobtest.network.response.DataResponse;
import com.example.jobtest.network.response.Entry;
import com.example.jobtest.ui.base.BasePresenter;
import com.example.jobtest.ui.base.BaseView;
import com.example.jobtest.ui.flow.posts.view.adapter.PostsRecyclerAdapter;

import java.util.List;

public interface PostsContract {

    interface View extends BaseView {

        void displayData(List<Entry> postsList);
        void initViews();
        void showNoDataScreen();
        void navigateToWebPage(String url);

        void navigateToVideoPage(String streamSrc);

        void showList();
        void showNoData();
    }

    interface Presenter extends BasePresenter, PostsRecyclerAdapter.IListener {

    }
}
