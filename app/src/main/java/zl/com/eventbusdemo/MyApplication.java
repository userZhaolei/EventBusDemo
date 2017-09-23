package zl.com.eventbusdemo;

import android.app.Application;

import com.bandeng.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

/**
 * create user zhaolei  代码无bug
 * 时间:2017/9/13
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();
    }
}
