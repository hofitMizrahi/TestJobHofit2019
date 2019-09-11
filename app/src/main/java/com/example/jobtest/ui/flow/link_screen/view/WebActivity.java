package com.example.jobtest.ui.flow.link_screen.view;


import com.example.jobtest.R;
import com.example.jobtest.ui.base.BaseActivity;
import com.example.jobtest.ui.flow.video_screen.contract.VideoContract;

public class WebActivity extends BaseActivity implements VideoContract.View{


    @Override
    protected void initDependencies() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_web;
    }
}
