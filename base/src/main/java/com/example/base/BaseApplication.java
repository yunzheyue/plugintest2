package com.example.base;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseApplication extends Application {
//    存放所有的要初始化的module的class
    private List<Class<? extends BaseAppLogic>> logicList = new ArrayList<>();
//    存放class反射生成的对象
    private List<BaseAppLogic> logicClassList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initLogic();
        logicCreate();
    }
    protected abstract void initLogic();
//    将要初始化的文件添加到集合中
    protected void registerApplicationLogic(Class<? extends BaseAppLogic> logicClass) {
        logicList.add(logicClass);
    }
//    使用反射获得初始化文件的对象，然后调用其中的方法
    protected void logicCreate() {
        for (Class<? extends BaseAppLogic> logicClass : logicList) {
            try {
                BaseAppLogic baseAppLogic = logicClass.newInstance();
                baseAppLogic.setApplication(this);
                baseAppLogic.onCreate();
                logicClassList.add(baseAppLogic);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (BaseAppLogic logic : logicClassList) {
            logic.onTerminate();
        }
    }
}
