package com.example.jobtest.ui.flow.link_screen.view;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.jobtest.R;
import com.example.jobtest.application.JobTestApplication;
import com.example.jobtest.di.components.DaggerWebComponent;
import com.example.jobtest.di.modules.WebModule;
import com.example.jobtest.ui.base.BaseActivity;
import com.example.jobtest.ui.base.BasePresenter;
import com.example.jobtest.ui.flow.link_screen.contract.WebContract;
import com.example.jobtest.ui.flow.link_screen.presenter.WebPresenter;
import javax.inject.Inject;
import butterknife.BindView;

public class WebActivity extends BaseActivity implements WebContract.View{

    @Inject
    String mUrl;

    @Inject
    WebPresenter mPresenter;

    @BindView(R.id.webView)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initDependencies() {
        DaggerWebComponent.builder().applicationComponent(JobTestApplication.getInstance().getComponent())
                .webModule(new WebModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_web;
    }

    @Override
    public void initViews() {

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.clearCache(true);
        mWebView.clearHistory();
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                hideProgressBar();
            }
        });
        mWebView.loadUrl(mUrl);
    }

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }
}
