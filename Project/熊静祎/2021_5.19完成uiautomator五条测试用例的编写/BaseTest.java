package com.example.fitnessdemo;

import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;

public class BaseTest {
    UiDevice mDevice;

    @Before
    public void testOpen() throws InterruptedException, RemoteException {
        //获取设备，连接模拟器
        mDevice = UiDevice.getInstance
                (InstrumentationRegistry.
                        getInstrumentation());
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();

        }
        mDevice.pressHome();
        Thread.sleep(8000);

        UiObject2 NoteTest=mDevice.findObject(By.text("Notes"));
        NoteTest.click();
    }
}
