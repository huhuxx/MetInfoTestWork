package com.example.fitnessdemo;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;


import org.junit.After;
import org.junit.Test;

import java.util.List;


public class PageTest{
    UiDevice mDevice;
    @Test
    public void initDevice() throws RemoteException, InterruptedException {
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

        //登陆
        mDevice.findObject(By.text("请输入账号")).setText("18210061413");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        mDevice.findObject(By.text("登录")).click();
        Thread.sleep(3000);
        //open  Running
        mDevice.findObject(By.res("com.example.fitnessdemo:id/clb_tv_begin_run")).click();
        Thread.sleep(5000);
        Thread.sleep(5000);
//        mDevice.findObject(By.res("com.example.fitnessdemo:id/pop_iv_stop")).click();
        mDevice.pressBack();

    }

    @Test
    public void undateHeight() throws InterruptedException, RemoteException {
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

        //登陆
        mDevice.findObject(By.text("请输入账号")).setText("18210061413");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        mDevice.findObject(By.text("登录")).click();
        Thread.sleep(3000);

        //
        Thread.sleep(5000);
        mDevice.findObject(By.text("我的")).click();
        Thread.sleep(5000);
        mDevice.findObject(By.clazz("android.widget.ImageView")).click();

        Thread.sleep(2000);
        mDevice.findObject(By.text("身体数据")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/shenti_img4")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/wsdialog_num")).setText("195");
        Thread.sleep(3000);
        mDevice.findObject(By.text("保存")).click();
        Thread.sleep(5000);
    }

    @Test
    public void undateWeight() throws InterruptedException, RemoteException {
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

        //登陆
        mDevice.findObject(By.text("请输入账号")).setText("18210061413");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        mDevice.findObject(By.text("登录")).click();
        Thread.sleep(3000);

        //
        Thread.sleep(5000);
        mDevice.findObject(By.text("我的")).click();
        Thread.sleep(5000);
        mDevice.findObject(By.clazz("android.widget.ImageView")).click();

        Thread.sleep(2000);
        mDevice.findObject(By.text("身体数据")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/shenti_img2")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/wsdialog_num")).setText("85");
        Thread.sleep(3000);
        mDevice.findObject(By.text("保存")).click();
        Thread.sleep(5000);
    }

    @Test
    public void undateHeightAndWeight() throws InterruptedException, RemoteException {
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

        //登陆
        mDevice.findObject(By.text("请输入账号")).setText("18210061413");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        mDevice.findObject(By.text("登录")).click();
        Thread.sleep(3000);

        //
        Thread.sleep(5000);
        mDevice.findObject(By.text("我的")).click();
        Thread.sleep(5000);
        mDevice.findObject(By.clazz("android.widget.ImageView")).click();

        Thread.sleep(2000);
        mDevice.findObject(By.text("身体数据")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/shenti_img2")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/wsdialog_num")).setText("95");
        Thread.sleep(3000);
        mDevice.findObject(By.text("保存")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/shenti_img4")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/wsdialog_num")).setText("195");
        Thread.sleep(5000);
        mDevice.findObject(By.text("保存")).click();
        Thread.sleep(5000);
    }

    @Test
    public void updatePhoto() throws InterruptedException, RemoteException {
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

        //登陆
        mDevice.findObject(By.text("请输入账号")).setText("18210061413");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        mDevice.findObject(By.text("登录")).click();
        Thread.sleep(3000);

        //
        Thread.sleep(5000);
        mDevice.findObject(By.text("我的")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/myinfo_touxiang")).click();
        Thread.sleep(3000);
        //点击相册
        mDevice.findObject(By.res("com.example.fitnessdemo:id/tv_photo")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.android.gallery3d:id/gl_root_view")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.android.gallery3d:id/gl_root_view")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.text("保存")).click();
        Thread.sleep(3000);

    }

    @After
    public void tearDown() {
//        mDevice.removeWatcher("call");
        mDevice.pressBack();
    }
}
