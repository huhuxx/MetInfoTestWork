package com.example.fitnessdemo;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class BaseTest {
    static UiDevice mDevice;
    @BeforeClass
    public static void initDevice() throws RemoteException, InterruptedException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        //查看设备是否锁屏
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();//锁屏的话就唤醒设备
        }
//        mDevice.registerWatcher("call",new CallWatcher(Device));
        mDevice.pressHome();//回到主界面
        Thread.sleep(5000);
//        打开健身助手ki
        mDevice.findObject(By.text("健身助手ki")).click();
        Thread.sleep(5000);

    }

    @Test
    public void alogin() throws InterruptedException {
        //登陆
        mDevice.findObject(By.text("请输入账号")).setText("18210061413");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        mDevice.findObject(By.text("登录")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/clb_tv_begin_run")).click();
        Thread.sleep(5000);
        mDevice.pressBack();
    }
    @Test
    public void running() throws InterruptedException {
        Thread.sleep(5000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/clb_tv_begin_run")).click();
        Thread.sleep(5000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/pop_iv_stop")).click();
    }
    @Test
    public void undateHeight() throws InterruptedException {
        Thread.sleep(5000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/picture")).click();
        Thread.sleep(5000);
        mDevice.findObject(By.clazz("android.widget.ImageView")).click();
        Thread.sleep(5000);
    }


    @AfterClass
    public static void tearDown() {
//        mDevice.removeWatcher("call");
        mDevice.pressBack();
    }
}
