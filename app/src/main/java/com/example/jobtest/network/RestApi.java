package com.example.jobtest.network;

import com.example.jobtest.network.response.DataResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("video_json.json")
    Call<DataResponse> getVideosPosts();

    @GET("link_json.json")
    Call<DataResponse> getLinksPosts();
}
