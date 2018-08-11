package com.yanxi.anim.sys.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class ObjectDecodeUtil {
	public  static String decode(String jsonData){
		String decode=null;
		try {
			decode=URLDecoder.decode(jsonData, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decode;
	}
	public  static String encode(String jsonData){
		String encode=null;
		try {
			encode=URLEncoder.encode(jsonData, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encode;
	}
}
