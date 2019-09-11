package com.example.jobtest.network;

import com.example.jobtest.interfaces.IExecutable;
import com.example.jobtest.network.response.LinksResponse;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkControllerImp implements NetworkController {

    @Inject
    RestApi mRestApi;

    @Inject
    public NetworkControllerImp() {
    }

    @Override
    public void getVideoList(IExecutable<LinksResponse> callback) {
        mRestApi.getVideosPosts().enqueue(new Callback<LinksResponse>() {
            @Override
            public void onResponse(Call<LinksResponse> call, Response<LinksResponse> response) {

                if (response != null && response.isSuccessful()) {
                    callback.execute(response.body());
                }
            }

            @Override
            public void onFailure(Call<LinksResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getLinksList(IExecutable<LinksResponse> callback) {
        mRestApi.getLinksPosts().enqueue(new Callback<LinksResponse>() {
            @Override
            public void onResponse(Call<LinksResponse> call, Response<LinksResponse> response) {

                if (response != null && response.isSuccessful()) {
                    callback.execute(response.body());
                }
            }

            @Override
            public void onFailure(Call<LinksResponse> call, Throwable t) {

            }
        });
    }
}
