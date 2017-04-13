package com.javxu.naiveaidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {


    public RemoteService() {
    }

    private class MyBinder extends IRemoteServiceMethod.Stub {

        public MyBinder() {
            Log.d("BindLog", "代理已创建");
        }

        @Override
        public void callRemoteServiceMethod() throws RemoteException {
                Log.d("BindLog", "代理去调用远程服务内方法");
                remoteMethod();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("BindLog", "RemoteService - onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("BindLog", "RemoteService - onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("BindLog", "RemoteService - onBind");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("BindLog", "RemoteService - onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("BindLog", "RemoteService - onDestroy");
    }

    private void remoteMethod() {
        Log.d("BindLog", "远程服务内方法已调用");
    }

}