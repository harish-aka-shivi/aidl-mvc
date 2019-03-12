package com.staqu.aidldemo;

import android.content.ComponentName;
import android.os.IBinder;

public interface ServiceConnectionInterface {

    void onServiceConnected(ComponentName name, IBinder service);
    void onServiceDisconnected(ComponentName name);


}
