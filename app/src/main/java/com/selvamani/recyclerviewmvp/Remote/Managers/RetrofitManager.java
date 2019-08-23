package com.selvamani.recyclerviewmvp.Remote.Managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.selvamani.recyclerviewmvp.Remote.ApiConstants;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ChildModel;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ParentModel;
import com.selvamani.recyclerviewmvp.Remote.Deserializers.ChildModelDeserializer;
import com.selvamani.recyclerviewmvp.Remote.Deserializers.ParentModelDeserializer;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ${Selva} on 17/06/19.
 */


public class RetrofitManager {

    private OkHttpClient okHttpClient;
    private Retrofit apiService;
//    private Retrofit apiService1;

    public RetrofitManager(OkHttpClient okHttpClient){
        this.okHttpClient = okHttpClient;
        this.apiService = createAPIService();
//        this.apiService1 = createAPIService1();
    }

    private Retrofit createAPIService(){
        Gson gson = new GsonBuilder()

                .registerTypeAdapter(ParentModel.class, new ParentModelDeserializer())
                .registerTypeAdapter(ChildModel.class, new ChildModelDeserializer())
                .create();

        return (new Retrofit.Builder()).baseUrl(ApiConstants.BASE_ENDPOINT_Local).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public Retrofit getApiService(){
        return this.apiService;
    }
}
