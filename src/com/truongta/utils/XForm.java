package com.truongta.utils;


import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import static com.truongta.utils.RRShare.request;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XForm {
	
	public static boolean exist(String name) {
		return request().getParameter(name)!=null;	
	}
	public static String  getString(String name,String def) {
		String val = request().getParameter(name);
		return val ==null ?def:val;
	}
	public static Integer getInt(String name,Integer def) {
		Integer val = Integer.parseInt(request().getParameter(name));
		return val==null?def:val;
	}
	public static Double getDouble(String name, Double def) {
		Double val = Double.parseDouble(request().getParameter(name));
		return val==null ? def:val;
	}
	public static Boolean getBoolean(String name, Boolean def) {
		Boolean val = Boolean.parseBoolean(request().getParameter(name));
		return val==null ? def:val;
	}
	public static Date getDate(String date,Date def) {
		SimpleDateFormat f = new SimpleDateFormat();
		String day = getString(date, String.valueOf(def));
		try {
			Date time = f.parse(day);
			return time;
		} catch (Exception e) {
			return def;
		}
	}
	
	public static File saveFile(String name,String folder) {
		File dir = new File(request().getServletContext().getRealPath(folder));
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			Part part = request().getPart(name);
			String fn = System.currentTimeMillis()+part.getSubmittedFileName();
			String fileName = Integer.toHexString(fn.hashCode())+fn.substring(fn.lastIndexOf("."));
			System.out.println("File Name Duoc Tao : "+fileName);
			File file = new File(dir,fileName);
			part.write(file.getAbsolutePath());
			return file;
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static <T> T getBean(Class<T> clazz) {
		DateTimeConverter dtc = new DateConverter(new Date());
		dtc.setPattern("MM/dd/yyyy");
		ConvertUtils.register(dtc, Date.class);
		try {
		T bean = clazz.newInstance();
		BeanUtils.populate(bean, request().getParameterMap());
		return bean;
		} catch (Exception e) {
		throw new RuntimeException(e);
		} 
	}
	
	
	
}
