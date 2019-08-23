package com.selvamani.recyclerviewmvp.Implementations;

import android.os.Handler;
import android.util.Log;

import com.selvamani.recyclerviewmvp.Contracts.MainContract;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ParentModel;
import com.selvamani.recyclerviewmvp.Remote.Managers.DataManager;
import com.selvamani.recyclerviewmvp.Remote.RxJava.RxTransformerUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class GetQuoteInteractorImpl implements MainContract.GetQuoteInteractor {

    DataManager dataManager;
    CompositeSubscription compositeSubscription = new CompositeSubscription();

    private List<ParentModel> parentModelList;
    MainContract.GetQuoteInteractor.OnFinishedListener mlistener;

    @Override
    public void getData(final MainContract.GetQuoteInteractor.OnFinishedListener listener) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
        mlistener = listener;
        dataManager = new DataManager();

        ApiConnect();
//            }
//        }, 1200);
    }

//    private String getRandomString() {
//
//        Random random = new Random();
//        int index = random.nextInt(parentModelList.size());
//
//
//        return arrayList.get(index);
//    }

    private void ApiConnect() {
        /*   progressDialog.show(MainActivity.this, "Loading...", "Please wait...", true);*/
        Subscription subscription = dataManager.getParenchildData().compose(RxTransformerUtil.androidComputation())
                .subscribe(this::handleRetrofitManagerResponse, this::handleRetrofitManagerError);
        compositeSubscription.add(subscription);
    }

    private void handleRetrofitManagerResponse(List<ParentModel> parentModels) {
        Log.d("fmfkfjkb", "handleLoginResponse: "+parentModels.size());
        parentModelList = parentModels;
//        SendToken(token.getTokens());
        mlistener.onFinished(parentModelList);
    }

    private void handleRetrofitManagerError(Throwable throwable) {
        Log.d("dhhfdfhj", "handleLoginError: "+throwable.getMessage());
//        Toast.makeText(this, "Server under maintenance Please try after sometime" , Toast.LENGTH_SHORT).show();

    }

}
