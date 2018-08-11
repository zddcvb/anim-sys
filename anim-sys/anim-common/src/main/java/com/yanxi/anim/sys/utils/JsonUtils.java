package com.yanxi.anim.sys.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static <T> String listToJson(Object obj) {
		String string = null;
		try {
			string = MAPPER.writeValueAsString(obj);
			return new String(string.getBytes(), "utf-8");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> jsonToList(String jsonData, Class<T> classType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, classType);
		try {
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String objectToJson(Object obj) {
		String string = null;
		try {
			string = MAPPER.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return string;
	}

	public static <T> T jsonToPojo(String jsonData, Class<T> valueType) {
		try {
			T readValue = MAPPER.readValue(jsonData, valueType);
			return readValue;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T jsonToObj(String jsonData, TypeReference<T> valueTypeRef) {
		try {
			T readValue = MAPPER.readValue(jsonData, valueTypeRef);
			return readValue;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
