package com.example.jobtest.network;


import com.example.jobtest.interfaces.IExecutable;
import com.example.jobtest.network.response.LinksResponse;

public interface NetworkController {

    void getVideoList(IExecutable<LinksResponse> callback);
    void getLinksList(IExecutable<LinksResponse> callback);
}
