package com.laptrinhwebJEE.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

//Dùng để convert từ JSON sang Model
public class HttpUtil {
	
private String value;
	
	public HttpUtil (String value) {
		this.value = value;
	}
	
	//Convert Json -> JSONString with type HttpUtil.value = (String)
	public static HttpUtil of (BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			System.out.print("HttpUtil of Error--"+e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
	
//	Mapper JSON String for Model. model dạng truyền vào tClass
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.print("ToModel Error--"+ e.getMessage());
		}
		return null;
	}
	
}
