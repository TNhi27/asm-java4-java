package com.truongta.utils;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class RRShare {
	
	public static 	Map<Long, HttpServletRequest> reqs = new HashedMap();
	public static 	Map<Long, HttpServletResponse> resps = new HashedMap();
	
	
	public static void add(HttpServletRequest request, HttpServletResponse response) {
		reqs.put(Thread.currentThread().getId(), request);
		resps.put(Thread.currentThread().getId(), response);
	}
	public static void remove() {
		reqs.remove(Thread.currentThread().getId());
		resps.remove(Thread.currentThread().getId());
	}
	public static HttpServletRequest request() {
		return reqs.get(Thread.currentThread().getId());
	}
	public static HttpServletResponse response() {
		return resps.get(Thread.currentThread().getId());
	}
}
