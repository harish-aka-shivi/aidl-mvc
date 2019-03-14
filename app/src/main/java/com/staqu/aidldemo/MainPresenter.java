package com.staqu.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

class MainPresenter implements ServiceConnectionInterface{

    private MainView mainView;
    private Context mContext;
    private AdditionServiceConnection mConnection;
    private IAddServiceAidl serviceAidl;

    MainPresenter(MainView mainView) {
        this.mainView = mainView;
        this.mContext = (Context) mainView;
        this.setUpService();
    }

    private void setUpService() {
        mConnection = new AdditionServiceConnection(this);
        Intent i = new Intent();
        i.setClassName("com.staqu.aidldemo",
                AddService.class.getName());
        boolean ret = mContext.bindService(i, mConnection, Context.BIND_AUTO_CREATE);
    }


    void onResume() {
//        if (mainView != null) {
//            mainView.showProgress();
//        }

    }

    void onItemClicked() {
        int number1,number2,result = 0;
        number1 = Integer.parseInt(mainView.getNumber1());
        number2 = Integer.parseInt(mainView.getNumber2());

        try {
            result = serviceAidl.add(number1, number2);
            mainView.setResultNumber(result);
        } catch (RemoteException e) {
            Log.i("aidl", "Data fetch failed with: " + e);
            e.printStackTrace();
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
        Toast.makeText(mContext,"service connected", Toast.LENGTH_SHORT).show();
       serviceAidl  = IAddServiceAidl.Stub.asInterface((IBinder) service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
