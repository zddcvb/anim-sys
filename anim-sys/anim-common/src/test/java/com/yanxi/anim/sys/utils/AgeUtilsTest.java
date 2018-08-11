package com.yanxi.anim.sys.utils;

import java.io.File;

import org.junit.Test;

class AgeUtilsTest {

	@Test
	void test() {
		int age = AgeUtils.getAge("1988-02-03");
		System.out.println(age);
	}

	@Test
	public void test_iamge() {
		ImageUtil.createNewImg(new File("d:/image"));
	}

}
