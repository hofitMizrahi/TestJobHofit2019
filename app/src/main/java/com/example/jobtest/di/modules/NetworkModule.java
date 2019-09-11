package com.example.jobtest.di.modules;

import com.example.jobtest.di.scope.PerApplication;
import com.example.jobtest.network.NetworkController;
import com.example.jobtest.network.NetworkControllerImp;
import com.example.jobtest.network.RestApi;
import com.example.jobtest.ui.utils.Constants;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @PerApplication
    Retrofit provideRetrofit(){

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    @Provides
    @PerApplication
    RestApi provideRestApi(Retrofit retrofit){
        return retrofit.create(RestApi.class);
    }

    @Provides
    @PerApplication
    NetworkController provideNetworkController(NetworkControllerImp controller){
        return controller;
    }
}
