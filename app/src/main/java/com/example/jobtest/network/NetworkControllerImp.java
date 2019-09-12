package com.example.jobtest.network;

import android.util.Log;
import com.example.jobtest.interfaces.IExecutable;
import com.example.jobtest.network.response.DataResponse;
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
    public void getVideoList(IExecutable<DataResponse> callback) {
        mRestApi.getVideosPosts().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                if (response != null && response.isSuccessful()) {
                    callback.execute(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getLinksList(IExecutable<DataResponse> callback) {
        mRestApi.getLinksPosts().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                if (response != null && response.isSuccessful()) {
                    callback.execute(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.i("network","fail");
            }
        });
    }
}
