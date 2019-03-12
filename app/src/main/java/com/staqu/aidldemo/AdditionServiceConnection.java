package com.staqu.aidldemo;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class AdditionServiceConnection implements ServiceConnection {
    private ServiceConnectionInterface serviceConnectionInterface;

    public AdditionServiceConnection(ServiceConnectionInterface serviceConnectionInterface) {
        this.serviceConnectionInterface = serviceConnectionInterface;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.serviceConnectionInterface.onServiceConnected(name,service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        this.serviceConnectionInterface.onServiceDisconnected(name);
    }

    @Override
    public void onBindingDied(ComponentName name) {

    }

    @Override
    public void onNullBinding(ComponentName name) {

    }
}
