package com.example.jobtest.ui.flow.posts.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.BinderThread;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobtest.R;
import com.example.jobtest.application.JobTestApplication;
import com.example.jobtest.di.components.DaggerPostsComponent;
import com.example.jobtest.di.modules.PostsModule;
import com.example.jobtest.network.NetworkController;
import com.example.jobtest.network.response.DataResponse;
import com.example.jobtest.network.response.Entry;
import com.example.jobtest.ui.base.BaseActivity;
import com.example.jobtest.ui.base.BasePresenter;
import com.example.jobtest.ui.flow.link_screen.view.WebActivity;
import com.example.jobtest.ui.flow.posts.contract.PostsContract;
import com.example.jobtest.ui.flow.posts.presenter.PostsPresenter;
import com.example.jobtest.ui.flow.posts.view.adapter.PostsRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PostsActivity extends BaseActivity implements PostsContract.View, androidx.appcompat.widget.SearchView.OnQueryTextListener {

    public static final String LINK_URL = "link_url";

    private List<Entry> mPostsList;

    @Inject
    PostsPresenter mPresenter;

    @Inject
    PostsRecyclerAdapter mAdapter;

    @Inject
    NetworkController mNetworkController;

    @BindView(R.id.posts_list_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.no_data_view)
    TextView mNoDataTxt;

    @BindView(R.id.search_view)
    androidx.appcompat.widget.SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initDependencies() {
        DaggerPostsComponent.builder()
                .postsModule(new PostsModule(this))
                .applicationComponent(JobTestApplication.getInstance().getComponent())
                .build().inject(this);
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
    public void displayData(List<Entry> postsList) {

        mPostsList = postsList;

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setData(postsList, mPresenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initViews() {

        mSearchView.setOnQueryTextListener(this);
    }

    @Override
    public void showNoDataScreen() {

    }

    @Override
    public void navigateToWebPage(String url) {

        startActivity(new Intent(this, WebActivity.class).putExtra(LINK_URL, url));
    }

    @Override
    public void showList() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mNoDataTxt.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSearchView.setQuery("", false);
        mSearchView.clearFocus();
    }

    @Override
    public void showNoData() {
        mRecyclerView.setVisibility(View.GONE);
        mNoDataTxt.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (mAdapter != null){
            mAdapter.filterList(newText, mPostsList);
        }
        return true;
    }
}
