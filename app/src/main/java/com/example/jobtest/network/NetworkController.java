package com.example.jobtest.network;


import com.example.jobtest.interfaces.IExecutable;
import com.example.jobtest.network.response.DataResponse;

public interface NetworkController {

    void getVideoList(IExecutable<DataResponse> callback);
    void getLinksList(IExecutable<DataResponse> callback);
}
