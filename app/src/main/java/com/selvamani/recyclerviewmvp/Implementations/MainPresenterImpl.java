package com.selvamani.recyclerviewmvp.Implementations;


import com.selvamani.recyclerviewmvp.Contracts.MainContract;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ParentModel;

import java.util.List;

public class MainPresenterImpl implements MainContract.Presenter, MainContract.GetQuoteInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetQuoteInteractor getQuoteInteractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetQuoteInteractor getQuoteInteractor) {
        this.mainView = mainView;
        this.getQuoteInteractor = getQuoteInteractor;
    }

    @Override
    public void onAPICalled() {
        if (mainView != null) {
            mainView.showProgress();
        }

        getQuoteInteractor.getData(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(List<ParentModel> parentModels) {
        if (mainView != null) {
            mainView.setAdapter(parentModels);
            mainView.hideProgress();
        }
    }
}
