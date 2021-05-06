package com.mail.send;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.first.Listener.JavaCreateHtmlListener;
import com.first.Listener.JavaMailTestListener;

/*
 *  * 胡学杨
 */
@Listeners(JavaMailTestListener.class)
public class test {
//	@Test
//	public void test1() {
//		assertEquals("1", "2");
//	}
	@Test
	public void test2() {
		assertEquals("2", "2");
	}
	@Test
	public void test3() {
		assertEquals("4", "2");
	}
	@Test
	public void test4() {
		assertEquals("9", "2");
	}
	@Test
	public void test5() {
		assertEquals("6", "2");
	}
	@Test
	public void test6() {
		assertEquals("2", "2");
	}
}
