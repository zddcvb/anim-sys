package com.yanxi.anim.sys.console;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yanxi.anim.sys.service.FastdfsService;
import com.yanxi.anim.sys.utils.IdGeneratorUtils;

public class TestUtils {
	@Autowired
	// private AnimDeptService animDeptService;
	@Test
	public void test_utile() {
		/*
		 * Date formateDate = DateFormate.formateDate("2017-05-06");
		 * System.out.println(formateDate);
		 */
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-mybatis.xml");
		FastdfsService fastdfsService = context.getBean("fastdfsService", FastdfsService.class);
		// List<AnimDept> parent =
		// animDeptService.findParentDept("98becc7314a74224a3cc9e9a8709e5e3");
		// System.out.println(parent);
		System.out.println(fastdfsService);
	}

	@Test
	public void test_uuid() {
		String updateUUUID = IdGeneratorUtils.updateUUUID("4513b824-9d5c-4707-b582-264c1d21baa0");
		System.out.println(updateUUUID);
	}
	@Test
	public void test_view(){
		File file=new File("d:/res_catas.xls");
		System.out.println(file.getName());
	}
}
