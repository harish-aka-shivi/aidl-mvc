package com.staqu.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import java.util.List;

class MainPresenter implements ServiceConnectionInterface{

    private MainView mainView;
    private Context mContext;
    private AdditionServiceConnection mConnection;

    MainPresenter(MainView mainView) {
        this.mainView = mainView;
        this.mContext = (Context) mainView;
        this.setUpService();
    }

    private void setUpService() {
        mConnection = new AdditionServiceConnection(this);
        Intent i = new Intent();
        i.setClassName("com.example.androidaidlserviceexample",
                AddService.class.getName());
        boolean ret = mContext.bindService(i, mConnection, Context.BIND_AUTO_CREATE);
    }


    void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }

    }

    void onItemClicked(String item) {
        if (mainView != null) {
            mainView.showMessage(String.format("%s clicked", item));
        }
    }

    void onDestroy() {
        mainView = null;
    }

    public void onFinished(List<String> items) {
//        if (mainView != null) {
//            mainView.setItems(items);
//            mainView.hideProgress();
//        }
    }

    public MainView getMainView() {
        return mainView;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
