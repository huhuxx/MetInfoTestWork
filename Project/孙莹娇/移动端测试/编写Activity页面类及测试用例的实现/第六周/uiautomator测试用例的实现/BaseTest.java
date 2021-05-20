package com.example.jszsapplication;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.BeforeClass;

public class BaseTest {
    public static UiDevice mDevice;
    @BeforeClass
    public static void initDevice() throws RemoteException, InterruptedException {
        //初始设备
        mDevice = UiDevice.getInstance
                (InstrumentationRegistry.
                        getInstrumentation());
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();

        }
        //点Home键
        mDevice.pressHome();
        Thread.sleep(4000);
        //点击“健身助手ki”
        UiObject2 todolist1 = mDevice.findObject(By.text("健身助手ki"));
        todolist1.click();

        //登录
        Thread.sleep(8000);
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/edit_loginusernum"))
                .setText("19831125536");
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/edit_loginuserpwd"))
                .setText("123456");
        mDevice.findObject(By.text("登录")).click();
        Thread.sleep(3000);
    }
}
