package testNG;

import org.testng.annotations.Test;

public class TestsParallel 
{
	@Test
	public void test1() 
	{
		System.out.println("I am test1 : "+Thread.currentThread().getId());
	}
	
	@Test
	public void test2() 
	{
		System.out.println("I am test2 : "+Thread.currentThread().getId());
	}
	
	@Test
	public void test3() 
	{
		System.out.println("I am test3 : "+Thread.currentThread().getId());
	}
	
	@Test
	public void test4() 
	{
		System.out.println("I am test4 : "+Thread.currentThread().getId());
	}
	
	@Test
	public void test5() 
	{
		System.out.println("I am test5 : "+Thread.currentThread().getId());
	}
	
	@Test
	public void test6() 
	{
		System.out.println("I am test6 : "+Thread.currentThread().getId());
	}
	
	@Test
	public void test7() 
	{
		System.out.println("I am test7 : "+Thread.currentThread().getId());
	}
}
