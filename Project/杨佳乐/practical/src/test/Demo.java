package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listener.JavaMailTestListener;

@Listeners(JavaMailTestListener.class)
public class Demo {
	//成功的方法
	@Test
	public void test1() {
		Assert.assertEquals(1,1);
	}
	@Test
	public void test2() {
		Assert.assertEquals(2,2);
	}
	//失败的方法
	@Test
	public void test3() {
		Assert.assertEquals(3,1);
	}
	@Test
	public void test4() {
		Assert.assertEquals(4,1);
	}
	@Test
	public void test5() {
		Assert.assertEquals(5,1);
	}
}
