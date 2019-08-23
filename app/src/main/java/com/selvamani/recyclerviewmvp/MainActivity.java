package com.selvamani.recyclerviewmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.selvamani.recyclerviewmvp.Adapter.ParentChildExpandableAdapter;
import com.selvamani.recyclerviewmvp.Contracts.MainContract;
import com.selvamani.recyclerviewmvp.Implementations.GetQuoteInteractorImpl;
import com.selvamani.recyclerviewmvp.Implementations.MainPresenterImpl;
import com.selvamani.recyclerviewmvp.Remote.Datamodel.ParentModel;

import java.util.List;

import static android.view.View.GONE;


public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private ExpandableListView expandableListView;
    private ProgressBar progressBar;
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.exl_parentchildlist);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        presenter = new MainPresenterImpl(this, new GetQuoteInteractorImpl());

        presenter.onAPICalled();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        expandableListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        expandableListView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setAdapter(List<ParentModel> parentModels) {
        ParentChildExpandableAdapter  parentChildExpandableAdapter = new ParentChildExpandableAdapter(this, parentModels);
//        expandableListView.setGroupIndicator(null);
        expandableListView.setAdapter(parentChildExpandableAdapter);
    }
}
