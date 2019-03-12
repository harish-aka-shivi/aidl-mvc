package com.staqu.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AddService extends Service {
    public AddService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IAddServiceAidl.Stub() {
            @Override
            public int add(int ValueFirst, int valueSecond) throws RemoteException {
                return valueSecond + valueSecond;
            }
        };

    }
}