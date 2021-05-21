package com.example.ui_module;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;
import org.junit.Test;

public class FitnessTest {
    UiDevice mDevice;
    @Before
    public void testInit() throws InterruptedException, RemoteException {
        //获取设备
        mDevice = UiDevice.getInstance
                (InstrumentationRegistry.getInstrumentation());
        if (!mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }
        mDevice.pressHome();
        UiObject2 notes = mDevice.findObject(By.text("健身助手ki"));
        notes.click();
        Thread.sleep(500);
    }
    @Test//登录成功
    public void testlogin() throws InterruptedException {
        Thread.sleep(5000);
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginusernum")).setText("12345678909");
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/btn_login")).click();
        Thread.sleep(1000);
    }
    @Test//跳转到我的好友界面
    public void testtarget_to_myfriend() throws InterruptedException {
        this.mDevice.findObject(By.text("我的")).click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/user_friend")).click();
        Thread.sleep(1000);
    }
    @Test//取消所有好友关注
    public void testcancel_attention() throws InterruptedException {
        while(true) {
            UiObject2 list = mDevice.findObject(By.res("com.example.fitnessdemo:id/lv_myfriend"));
            int count = list.getChildCount();
            if (count > 0) {
                this.mDevice.findObject(By.text("取消关注")).click();
                Thread.sleep(1000);
            } else {
                break;
            }
        }
    }
    @Test//关注好友
    public void testlcattention_friend() throws InterruptedException {
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/iv_friend")).click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_search")).setText("王小阳");
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/layout_search")).click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.text("关注")).click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/iv_backsearch")).click();
        Thread.sleep(1000);
    }

    @Test()
    public void testacaheckinfo() throws InterruptedException {
        this.mDevice.findObject(By.res("com.example.fitnessdemo:id/img_myuser")).click();
        Thread.sleep(1000);
    }

}
