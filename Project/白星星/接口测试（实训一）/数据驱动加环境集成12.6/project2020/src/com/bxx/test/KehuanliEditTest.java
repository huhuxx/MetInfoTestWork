package com.bxx.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bxx.dataprovider.NSDataProvider;

public class KehuanliEditTest extends BaseTest {
	
	@Test
	public void testEdit1() throws InterruptedException {
		//将第二个放入回收站
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		
		List<WebElement> deleteList = webtest.backlist("xpath=//*[@class='btn btn-sm btn-default']");
		webtest.click(deleteList.get(1));
		webtest.click("xpath=//*[@class='btn btn-sm mr-1 btn-primary btn-table-del-recycle']");
	}
	@Test
	public void testEdit2() throws InterruptedException {
		//将第二个从回收站恢复
		webtest.click("xpath=//a[text()='内容']");
		webtest.click("xpath=//*[@class='fa-recycle']");
		List<WebElement> deleteList = webtest.backlist("xpath=//*[@class='btn btn-sm btn-primary mr-1']");
		webtest.click(deleteList.get(0));
	}
	@Test
	public void testEdit3() throws InterruptedException {
		//将回收站所有的内容删除
		webtest.click("xpath=//a[text()='内容']");
		webtest.click("xpath=//*[@class='fa-recycle']");
		List<WebElement> deleteList = webtest.backlist("xpath=//*[@name='id']");
		System.out.println(deleteList.size()+"-------------");
		for (int i = deleteList.size(); i > 0; i--) {
			webtest.click(deleteList.get(i-1));
		}
		webtest.click("xpath=//*[@class='btn btn-default']");
		webtest.click("xpath=//*[@class='ok btn btn-primary']");
	}
	@Test(dataProvider = "photo",dataProviderClass = NSDataProvider.class)
	public void testEditAdd4(String text) throws InterruptedException {
		//添加新的内容带有本地图片
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='title']","这是新添加的带有本地图片内容");
		//添加本地图片
		webtest.type("xpath=//*[@name='imgurl']",text);
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "这是介绍部分");
		webtest.leaveFrame();
		
		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");
	}
	@Test
	public void testEditAdd5() throws InterruptedException {
		//添加新的内容
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='title']","这是新添加的带有仓库图片的展示");
		//添加仓库图片
		webtest.click("xpath=//*[@class='btn btn-default fileinput-file-choose element-visible']");
		List<WebElement> packageList = webtest.backlist("xpath=//*[@class='fa-folder-open-o h1']");
		System.out.println(packageList.size()+"文件夹的长度");
		webtest.doubleClick(packageList.get(1));
		
		webtest.click("xpath=//*[@class='btn btn-warning float-right btn-img-folder-back']");
		webtest.click("xpath=//*[@class='d-flex align-items-center justify-content-center p-1 border position-relative img']");
		webtest.mouseToElement("xpath=//*[@class='float-right']");
		
		List<WebElement> btnList = webtest.backlist("xpath=//*[@class='btn btn-primary']");
		System.out.println("button的长度"+btnList.size());
		webtest.click(btnList.get(2));
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "这是介绍部分");
		webtest.leaveFrame();
		
		webtest.click(btnList.get(1));
		
	}
	@Test
	public void testEditAdd6() throws InterruptedException {
		//添加新的内容带有网络图片
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='title']","这是新添加的带有网络图片的内容");
		//添加网络图片
		String imgSrc = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605677648442&di=ddaf61fc4a86c56af13714deeba2785e&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F55%2F22%2F20300000929429130630222900050.jpg";
		webtest.click("xpath=//button[@class='btn btn-default fileinput-file-other element-visible']");
		webtest.type("xpath=//*[@name='img_url']", imgSrc);
		//点击保存
		List<WebElement> btnList = webtest.backlist("xpath=//*[@class='btn btn-primary']");
		System.out.println("button的长度"+btnList.size());
		webtest.click(btnList.get(2));
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "这是介绍部分");
		webtest.leaveFrame();
		
		webtest.click(btnList.get(1));
	}
	
	@Test
	public void testEditAdd7() throws InterruptedException {
//		添加新的内容带有本地视频的内容
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='title']","这是新添加的带有本地视频的内容");
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "这是介绍部分");
		webtest.leaveFrame();

		//设置视频内容
		webtest.click("id=edui167_body");
		webtest.enterFrame("edui163_iframe");
		webtest.click("xpath=//*[@id='tabHeads']//span[text()='上传视频']");
		webtest.type("xpath=//input[@class='webuploader-element-invisible']", "D:\\ABCD\\leave.mp4");
		webtest.click("xpath=//*[@class='uploadBtn state-ready']");
		webtest.leaveFrame();
		webtest.click("id=edui165_body");
		
		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");	
	}
	
	@Test
	public void testEditAdd8() throws InterruptedException {
//		添加新的内容带有网络视频的内容
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='title']","这是新添加的带有网络视频的内容");
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "这是介绍部分");
		webtest.leaveFrame();

		//设置视频内容
		webtest.click("id=edui167_body");
		webtest.enterFrame("edui163_iframe");
		webtest.type("id=videoUrl", "https://haokan.baidu.com/v?vid=8729297236018545010&pd=bjh&fr=bjhauthor&type=video");
		Thread.sleep(5000);
		webtest.type("id=videoWidth", "800");
		webtest.type("id=videoHeight", "500");
		webtest.leaveFrame();
		webtest.click("id=edui165_body");
		
		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");	
	}
	
	@Test
	public void testEditAdd9() throws InterruptedException {
//		添加新的内容带有超链接的内容
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='title']","这是新添加的带有超链接的内容");
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "这是介绍部分");
		webtest.leaveFrame();

		//设置超链接内容
		List<WebElement> list2 = webtest.backlist("xpath=//*[@class='edui-button-wrap edui-default']");
		webtest.click(list2.get(21));
		webtest.enterFrame1("xpath=//*[@class='%%-iframe edui-insertimage-iframe']");
		webtest.type("id=text", "请打开网站首页");
		webtest.type("id=href", "127.0.0.1:9900");
		webtest.type("id=title", "这是一个超链接");
		webtest.click("id=target");
		webtest.leaveFrame();
		
		//点击确认
		List<WebElement> list3 = webtest.backlist("xpath=//*[@class='edui-button-body edui-default']");
		webtest.click(list3.get(54));
		
		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");	
	}
	
	@Test
	public void testEditAdd10() throws InterruptedException {
		//详细内容中多图上传
		webtest.click("xpath=//a[text()='内容']");
		List<WebElement> list = webtest.backlist("xpath=//*[@class='py-2 d-block']");
		webtest.click(list.get(4));
		webtest.click("xpath=//*[text()='添加内容']");
		webtest.type("xpath=//*[@name='title']","这是新添加的带有多图上传的内容");
		
		webtest.enterFrame("ueditor_0");
		webtest.type("tag=body", "这是介绍部分");
		webtest.leaveFrame();

		//设置多图上传
		List<WebElement> list2 = webtest.backlist("xpath=//*[@class='edui-button-wrap edui-default']");
		webtest.click(list2.get(23));

		webtest.enterFrame("edui153_iframe");
		webtest.type("name=file","D:\\ABCD\\2.jpg");
		webtest.type("name=file","D:\\ABCD\\3.jpg");
		webtest.type("name=file","D:\\ABCD\\4.jpg");
		webtest.click("xpath=//*[@class='uploadBtn state-ready']");
		webtest.leaveFrame();
		webtest.click("id=edui155_body");
		
		webtest.click("xpath=//div[@class='float-right']//button[text()='保存']");
	}
}
