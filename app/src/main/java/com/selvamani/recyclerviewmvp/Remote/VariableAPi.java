package com.selvamani.recyclerviewmvp.Remote;

import com.google.gson.JsonObject;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ParentModel;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface VariableAPi {

//    @FormUrlEncoded
//    @POST("api/tokenlog")  //Login
//    Observable<Token> getResponseToken(@Field("sending") JsonObject object);
//
//    @FormUrlEncoded
//    @POST("api/post")  //Login
//    Observable<Token> sendTokens(@Field("Bearer") String tok);

    @GET("bins/o798f")
    Observable<List<ParentModel>> getParenchildData();
}
