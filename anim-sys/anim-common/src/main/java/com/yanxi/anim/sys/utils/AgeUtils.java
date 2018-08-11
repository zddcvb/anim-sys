package com.yanxi.anim.sys.utils;

import java.util.Date;

public class AgeUtils {
	public static int getAge(String born) {
		// 1988-01-02
		boolean matches = born.matches("^\\d{4}-\\d{1,2}-\\d{1,2}");
		String currentDate = DateFormate.formateDateToString(new Date());
		String currentYear = currentDate.split(" ")[0].split("-")[0];
		if (matches) {
			String year = born.split("-")[0];
			int age = Integer.parseInt(currentYear) - Integer.parseInt(year);
			return age;
		}
		return 0;

	}
}
