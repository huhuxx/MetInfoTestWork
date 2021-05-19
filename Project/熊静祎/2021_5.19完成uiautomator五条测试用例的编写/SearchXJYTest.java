package com.example.fitnessdemo;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;

import org.junit.Test;

public class SearchXJYTest extends BaseTest{
    //01 点击“推荐”，点击搜索框
    @Test
    public void test_1searchRecClick() throws InterruptedException {
        Thread.sleep(3000);
        UiObject2 item = mDevice.findObject(By.res("com.example.fitnessdemo:id/title"));
        item.click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.text("推荐")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.clazz("com.example.fitnessdemo:id/et_product_search")).click();
        Thread.sleep(3000);
    }
    //02 点击“推荐”，点击搜索框，输入空格，点击搜索
    @Test
    public void test_2searchRecSpace() throws InterruptedException {
        Thread.sleep(3000);
        UiObject2 item = mDevice.findObject(By.res("com.example.fitnessdemo:id/title"));
        item.click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.text("推荐")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/et_product_search")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.clazz("android.widget.EditText")).setText("  ");
        Thread.sleep(2000);
    }
    //03 点击“推荐”，点击搜索框，输入“上衣”，点击搜索
    @Test
    public void test_3searchRecUp() throws InterruptedException {
        Thread.sleep(3000);
        UiObject2 item = mDevice.findObject(By.res("com.example.fitnessdemo:id/title"));
        item.click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.text("推荐")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/et_product_search")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.clazz("android.widget.EditText")).setText("上衣");
        Thread.sleep(2000);
    }
    //04 点击“推荐”，点击搜索框，输入“Nike”，点击搜索
    @Test
    public void test_4searchRecNike() throws InterruptedException {
        Thread.sleep(3000);
        UiObject2 item = mDevice.findObject(By.res("com.example.fitnessdemo:id/title"));
        item.click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.text("推荐")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/et_product_search")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.clazz("android.widget.EditText")).setText("Nike");
        Thread.sleep(2000);
    }
    //05 点击“推荐”，点击搜索框，输入“裤”，点击搜索
    @Test
    public void test_5searchRecDown() throws InterruptedException {
        Thread.sleep(3000);
        UiObject2 item = mDevice.findObject(By.res("com.example.fitnessdemo:id/title"));
        item.click(3000);
        Thread.sleep(2000);
        mDevice.findObject(By.text("推荐")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.fitnessdemo:id/et_product_search")).click();
        Thread.sleep(3000);
        mDevice.findObject(By.clazz("android.widget.EditText")).setText("裤");
        Thread.sleep(2000);
    }
}
