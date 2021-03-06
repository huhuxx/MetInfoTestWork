package listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import utils.MailUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class JavaMailTestListener extends TestListenerAdapter {
	@Override
	public void onFinish(ITestContext t) {
		// 1，创建freeMarker配置实例
		String path = "D:\\eclipse\\practical\\src\\fm";
		String name ="";
		String result= "";
		Configuration configuration = new Configuration();
		try {
			// 2,获取模板路径
			configuration.setDirectoryForTemplateLoading(new File(path));
			// 3,加载模板文件
			Template template = configuration.getTemplate("/freemarker.ftl");
			// 4,定义数据
			// 打印出所有的测试用例数目
			ITestNGMethod[] methods = this.getAllTestMethods();
			int num1=methods.length;
			System.out.println("一共执行了：" + methods.length);
			List<Map> maps=new ArrayList<Map>();
			// 失败的测试用例名称和数目
			List<ITestResult> failList = this.getFailedTests();
			int len = failList.size();
			System.out.println("失败的测试用例：" + len);
			for (int i = 0; i < len; i++) {
				ITestResult tr = failList.get(i);
				name=tr.getName();
				result="false";
				Map<String, String> p1=new HashMap<String, String>();
				p1.put("name", name);
				p1.put("result",result);
				maps.add(p1);
			}
			// 成功的测试用例名称和数目
			List<ITestResult> passList = this.getPassedTests();
			int len1 = passList.size();
			System.out.println("成功的测试用例：" + len1);
			for (int i = 0; i < len1; i++) {
				ITestResult tr1 = passList.get(i);
				name=tr1.getName();
				result="true";
				Map<String, String> p2=new HashMap<String, String>();
				p2.put("name", name);
				p2.put("result",result);
				maps.add(p2);
			}
			Map<String, Object> context=new HashMap<String, Object>();
			context.put("num1", num1);
			context.put("len",len);
			context.put("len1",len1);
			context.put("maps", maps);
	    	context.put("cur_time",new Date().toString());
	    	context.put("ceshi", "杨佳乐");
			// 5，定义输出
			Writer out = new FileWriter(path + "/freemarker.html");
			template.process(context, out);
			System.out.println("转换成功");
			try {
				MailUtil.Mail();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
