package com.bxx.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bxx.core.WebTestListener1;

@Listeners(WebTestListener1.class)
public class allTest extends BaseTest {

	@Test
	public void Test1() throws Exception{
		assertEquals(1,1);
		
	}
	@Test
	public void Test2() throws Exception{
		assertEquals(1,1);
		
	}
	@Test
	public void Test3() throws Exception{
		assertEquals(1,2);
		
	}
	@Test
	public void Test4() throws Exception{
		assertEquals(1,3);
		
	}
	@Test
	public void Test5() throws Exception{
		assertEquals(1,1);
		
		
	}
}


