package com.example.jobtest.network;

import com.example.jobtest.network.response.LinksResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("video_json.json")
    Call<LinksResponse> getVideosPosts();

    @GET("link_json.json")
    Call<LinksResponse> getLinksPosts();
}
