package com.truongta.utils;

import javax.servlet.http.Cookie;

public class XCookie {
	public static void add(String name, String val, int h) {
		Cookie c = new Cookie(name, val);
		c.setMaxAge(h);
		c.setPath("/");
		RRShare.response().addCookie(c);
	}

	public static String get(String name, String defaultValue) {
		Cookie[] cookies = RRShare.request().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return defaultValue;
	}
}
