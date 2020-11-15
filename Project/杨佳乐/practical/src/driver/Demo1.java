package driver;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Demo1 {
	public static void main(String[] args) throws Exception {
		String dir="D:\\eclipse\\practical\\src\\fm";
		Configuration conf = new Configuration();
		//加载模板文件(模板的路径)
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 加载模板
		Template template = conf.getTemplate("/free.ftl");
		// 定义数据
		Map root = new HashMap();
		List<Map> maps = new ArrayList<Map>();
		Map pms1 = new HashMap();
		pms1.put("id1", "范冰冰");
		pms1.put("id2", "李冰冰");
		Map pms2 = new HashMap();
		pms2.put("id1", "曾志伟");
		pms2.put("id2", "何炅");
		maps.add(pms1);
		maps.add(pms2);
		root.put("maps", maps);

		root.put("cur_time",new Date());
 
		// 定义输出
		Writer out = new FileWriter(dir + "/freemarker.html");
		template.process(root, out);
		System.out.println("转换成功");
		out.flush();
		out.close();
	}

}
