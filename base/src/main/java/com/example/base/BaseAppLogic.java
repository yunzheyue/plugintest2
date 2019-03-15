package com.example.base;

import android.content.res.Configuration;

public class BaseAppLogic {

    public BaseApplication mApplication;

    public void setApplication(BaseApplication application) {
        mApplication = application;
    }

    public void onCreate() {
    }

    public void onTerminate() {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

}
