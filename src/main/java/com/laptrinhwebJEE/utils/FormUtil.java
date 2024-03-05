package com.laptrinhwebJEE.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

//Sử dụng beanUltil convert từ Url(Client(Post, Get Model)) sang model
public class FormUtil {
	// truyền HttpServletRequest để lấy Url. dùng để convert ra model
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> Clazz, HttpServletRequest request) {
		T object = null;
		try {
			object = Clazz.newInstance();
			// newInstance dùng để tạo ra một đối tượng mới thuộc Clazz vì không thể dùng
			// new Clazz (không thể dùng kiểu News news = new News()) được vì chưa biết T là gì

			// Convert từ Url sang Model
			BeanUtils.populate(object, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return object;
	}
}
