package com.yanxi.anim.sys.utils;

import java.util.UUID;

public class IdGeneratorUtils {
	/**
	 * 生成uuid键值，去掉其中的-线
	 * @return
	 */
	public static  String generatorUUID(){
		String uuid = UUID.randomUUID().toString();
		if (uuid.contains("-")) {
			uuid = uuid.replace("-", "");
		}	
		return uuid;
	}
	
	/**
	 * 处理传递的uuid值，将-去掉
	 * @return
	 */
	public static  String updateUUUID(String uuid){
		if (uuid.contains("-")) {
			uuid = uuid.replace("-", "");
		}		
		return uuid;
	}
}
