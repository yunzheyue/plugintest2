package com.example.androidstudiotest5;

import com.example.base.BaseApplication;
import com.example.home.HomeInitLogic;
import com.example.msg.MsgInitLogic;

public class MyApplication extends BaseApplication {

    @Override
    protected void initLogic() {
        registerApplicationLogic(HomeInitLogic.class);
        registerApplicationLogic(MsgInitLogic.class);
    }
}
