package com.example.ch12uiauto;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoTest1 {
    UiDevice mDevice;
    @BeforeClass
    public void shixun() throws InterruptedException {
        //获取设备，连接模拟器
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiObject2 sx = mDevice.findObject(By.text("健身助手ki"));
        sx.click();
        Thread.sleep(1000);
        UiObject2 log = mDevice.findObject(By.res("com.example.todolist:id/loginBtn"));
        Thread.sleep(1000);

    }

    //登录
    @Test
    public void test_1() throws InterruptedException {
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginusernum")).setText("15226500915");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/edit_loginuserpwd")).setText("123456");
        mDevice.findObject(By.res("com.example.fitnessdemo:id/btn_login")).click();
        Thread.sleep(1000);
    }
    //查看全部课程
    @Test
    public void test_2() throws InterruptedException {
        mDevice.findObject(By.text("课程")).click();
        mDevice.findObject(By.text("课程")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/quanbu")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.text("健身")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/fanhui")).click();
        Thread.sleep(2000);
    }

    //推荐-品牌精选
    @Test
    public void test_3() throws InterruptedException {
        mDevice.findObject(By.text("推荐")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.text("品牌精选")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/img_fanhui"));
        Thread.sleep(1000);
    }

    //一周严选-查看全部
    @Test
    public void test_4() throws InterruptedException {
        mDevice.findObject(By.text("推荐")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/findAll")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/img_fanhui"));
        Thread.sleep(1000);
    }

    //退出
    @Test
    public void test_5() throws InterruptedException {
        mDevice.findObject(By.text("我的")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/myinfo_setting")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/tuichu")).click();
        Thread.sleep(1000);

    }


}
