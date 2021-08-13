package org.testngsample;

import org.testng.annotations.Test;

public class TestNGGroup {

	@Test(groups="group1")
	public void test00() {
		System.out.println("Test01");
	}
	@Test(groups="group2")
	public void test01() {
		System.out.println("Test02");
	}
	@Test(groups="group3")
	public void test03() {
		System.out.println("Test03");
	}
	@Test(groups="group2")
	public void test04() {
		System.out.println("Test04");
	}
	@Test(groups="group1")
	public void test05() {
		System.out.println("Test05");
	}
	@Test
	public void test06() {
		System.out.println("Test06");
	}
	
	
}
