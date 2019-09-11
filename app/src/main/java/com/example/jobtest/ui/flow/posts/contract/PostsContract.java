package com.example.jobtest.ui.flow.posts.contract;

import com.example.jobtest.ui.base.BasePresenter;
import com.example.jobtest.ui.base.BaseView;

public interface PostsContract {

    interface View extends BaseView {

        void displayData();
        void initViews();
    }

    interface Presenter extends BasePresenter {

    }
}
