package com.selvamani.recyclerviewmvp.Contracts;

import com.selvamani.recyclerviewmvp.Remote.Datamodel.ParentModel;

import java.util.List;

/**
 * Created by selva on 11/08/17.
 */

public interface MainContract {

    interface MainView {
        void showProgress();

        void hideProgress();

        void setAdapter(List<ParentModel> parentModels);
    }

    interface GetQuoteInteractor {
        interface OnFinishedListener {
            void onFinished(List<ParentModel> parentModelList);
        }

        void getData(OnFinishedListener onFinishedListener);
    }

    interface Presenter {
        void onAPICalled();

        void onDestroy();
    }
}
