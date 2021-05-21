package com.example.jszsapplication;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;

import org.junit.Test;

import java.util.List;

public class CourseTest extends BaseTest{

    /**
     * 1
     * 进入我的收藏，添加收藏课程
     * @throws InterruptedException
     */
    @Test
    public void addCollect_inMyCollecting() throws InterruptedException {
        //进入我的收藏
        mDevice.findObject(By.text("我的")).click();
        Thread.sleep(1500);
        mDevice.findObject(By.text("我的收藏")).click();
        Thread.sleep(1500);

        //点击添加，进入“全部课程”，点击第三个课程并收藏
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/tianjia"))
                .click();
        Thread.sleep(1500);
        //获取当前页面课程的列表
        List<UiObject2> courseList=
                mDevice.findObject(By.res("com.example.fitnessdemo:id/course_list")).getChildren();
        //点击第三个课程并收藏
        courseList.get(2).click();
        Thread.sleep(1500);
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/btn_collect"))
                .click();
        Thread.sleep(1500);
        mDevice.pressBack();
        mDevice.pressBack();
    }

    /**
     * 2
     * 在“课程”版块中收藏课程
     * @throws InterruptedException
     */
    @Test
    public void addCollect_inCourse() throws InterruptedException {
        Thread.sleep(3000);
        mDevice.findObject(By.text("课程")).click();
        Thread.sleep(1500);
        //代替-点击“知道了”
        mDevice.findObject(By.text("热门课程")).click();
        Thread.sleep(1500);
        //获取当前页面课程的列表
        List<UiObject2> courseList=
                mDevice.findObject(By.res("com.example.fitnessdemo:id/course_list")).getChildren();
        //点击第1个课程并收藏
        courseList.get(0).click();
        Thread.sleep(1500);
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/btn_collect"))
                .click();
        Thread.sleep(1500);
        mDevice.pressBack();
    }

    /**
     * 3
     * 在更多 热门课程中，收藏第2个课程
     * @throws InterruptedException
     */
    @Test
    public void addCollect_inRemenCourse() throws InterruptedException {
        Thread.sleep(3000);
        mDevice.findObject(By.text("课程")).click();
        Thread.sleep(1500);
        //代替-点击“知道了”
        mDevice.findObject(By.text("热门课程")).click();
        Thread.sleep(1500);
        //进入“热门课程”
        mDevice.findObject(By.res("com.example.fitnessdemo:id/remenquanbu")).click();
        Thread.sleep(1500);
        //获取当前页面课程的列表
        List<UiObject2> courseList=
                mDevice.findObject(By.res("com.example.fitnessdemo:id/remen")).getChildren();
        //点击第2个课程并收藏
        courseList.get(1).click();
        Thread.sleep(1500);
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/btn_collect"))
                .click();
        Thread.sleep(1500);
        mDevice.pressBack();
        mDevice.pressBack();
    }

    /**
     * 4
     * 在“最新课程”中收藏课程
     * @throws InterruptedException
     */
    @Test
    public void addCollect_inNewestCourse() throws InterruptedException {
        Thread.sleep(3000);
        mDevice.findObject(By.text("课程")).click();
        Thread.sleep(1500);
        //代替-点击“知道了”
        mDevice.findObject(By.text("热门课程")).click();
        Thread.sleep(1500);
        //点击更多 最新课程
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/zuixinquanbu"))
                .click();
        Thread.sleep(1500);
        //获取最新课程的列表
        List<UiObject2> courseList=
                mDevice.findObject(By.res("com.example.fitnessdemo:id/zuixin")).getChildren();
        //点击第3个课程并收藏
        courseList.get(2).click();
        Thread.sleep(1500);
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/btn_collect"))
                .click();
        Thread.sleep(1500);
        mDevice.pressBack();
        mDevice.pressBack();
    }
    @Test
    public void repeatAddCollect() throws InterruptedException {
        //进入我的收藏
        mDevice.findObject(By.text("我的")).click();
        Thread.sleep(1500);
        mDevice.findObject(By.text("我的收藏")).click();
        Thread.sleep(1500);
        //获取已收藏的课程列表
        List<UiObject2> courseList=
                mDevice.findObject(By.res("com.example.fitnessdemo:id/shoucang")).getChildren();
        //点击第一个课程，进行重复收藏
        courseList.get(0).click();
        Thread.sleep(1500);
        mDevice.findObject
                (By.res("com.example.fitnessdemo:id/btn_collect"))
                .click();
        Thread.sleep(1500);
        mDevice.pressBack();
        mDevice.pressBack();
    }
}
