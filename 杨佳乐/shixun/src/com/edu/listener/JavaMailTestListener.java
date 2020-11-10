package com.edu.listener;

import java.io.IOException;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.edu.utils.MailUtil;

public class JavaMailTestListener extends TestListenerAdapter{
	@Override
	public void onFinish(ITestContext t) {
		String name = null;
		//打印出所有的测试用例数目
		ITestNGMethod[] methods=this.getAllTestMethods();
		System.out.println("一共执行了："+methods.length);
		//失败的测试用例名称和数目
		List<ITestResult> failList=this.getFailedTests();
		int len=failList.size();
		System.out.println("失败的测试用例："+len);
		for(int i=0;i<len;i++) {
			ITestResult tr=failList.get(i);
			name+=tr.getInstanceName()+":"+tr.getName()+"失败了";
		}
		//成功的测试用例名称和数目
		List<ITestResult> passList=this.getPassedTests();
		int len1=passList.size();
		System.out.println("成功的测试用例："+len1);
		for(int i=0;i<len1;i++) {
			ITestResult tr1=passList.get(i);
			name+=tr1.getInstanceName()+":"+tr1.getName()+"成功了";
		}
		try {
			MailUtil.Mail(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
