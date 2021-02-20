package com.truongta.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class XScope {
	public static HttpServletRequest scopeInRequest() {
		return RRShare.request();
	}

	public static HttpSession scopeInSession() {
		return RRShare.request().getSession();
	}

	public static ServletContext scopeInApp() {
		return RRShare.request().getServletContext();
	}

	public static void setRequest(String name, Object val) {
		RRShare.request().setAttribute(name, val);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getRequest(String name) {
		return (T) RRShare.request().getAttribute(name);
	}

	public static void removeRequest(String name) {
		RRShare.request().removeAttribute(name);
	}

	public static void setSession(String name, Object value) {
		scopeInSession().setAttribute(name, value);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getSession(String name) {
		return (T) scopeInSession().getAttribute(name);
	}

	public static void removeSession(String name) {
		scopeInSession().removeAttribute(name);
	}

	public static void setApplication(String name, Object value) {
		scopeInApp().setAttribute(name, value);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getApplication(String name) {
		return (T) scopeInApp().getAttribute(name);
	}

	public static void removeApplication(String name) {
		scopeInApp().removeAttribute(name);
	}
}
